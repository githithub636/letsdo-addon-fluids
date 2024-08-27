package dev.ninjdai.doaddoncreate.utils.fluid;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mojang.serialization.Codec;
import com.simibubi.create.foundation.utility.Pair;
import dev.architectury.fluid.FluidStack;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ninjdai.doaddoncreate.registry.DoAddonFluids;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.function.Supplier;

public record FluidDataAttachment(
        Codec<Pair<ItemStack, FluidStack>> codec,
        int amountPerBottle,
        ArrayList<Builder.NbtMigrate> migrates,
        BiMap<Fluid, Supplier<Item>> supports,
        Item emptyBottleItem) {

    public static Builder create(Item emptyBottleItem) {
        return new Builder(emptyBottleItem);
    }

    public static class Builder {
        ArrayList<NbtMigrate> migrates = new ArrayList<>();
        int amountPerBottle = 27000;

        Item emptyBottleItem;

        BiMap<Fluid, Supplier<Item>> supports = HashBiMap.create();

        private Builder(Item emptyBottleItem) {
            this.emptyBottleItem = emptyBottleItem;
        }

        /**
         * Treat this method as an emptying simulation,
         * It is used both ways when emptying or filling
         */
        public Builder nbtMigrateFluidwards(String from, String to, Tag defaultVal) {
            migrates.add(new NbtMigrate(from, to, defaultVal));
            return this;
        }

        public Builder amountPerBottle(int amount) {
            amountPerBottle = amount;
            return this;
        }

        public Builder supports(DoAddonFluids.StateIndependantFluid fluid, Item fullBottleItem) {
            supports.put(fluid.source().get(), () -> fullBottleItem);
            return this;
        }

        public Builder supports(DoAddonFluids.StateIndependantFluid fluid, Supplier<Item> fullBottleItem) {
            supports.put(fluid.source().get(), fullBottleItem);
            return this;
        }

        public Builder supports(DoAddonFluids.StateIndependantFluid fluid, RegistrySupplier<Block> fullBottleBlockItem) {
            supports.put(fluid.source().get(), () -> fullBottleBlockItem.get().asItem());
            return this;
        }

        public FluidDataAttachment build() {
            Codec<Pair<ItemStack, FluidStack>> codec = ItemStack.CODEC.xmap(
                    itemStack -> {
                        CompoundTag fluidTag = new CompoundTag();
                        migrates.forEach(migrate -> {
                            if (itemStack.getOrCreateTag().contains(migrate.from)) {
                                fluidTag.put(migrate.to, itemStack.getTag().get(migrate.from));
                            } else {
                                fluidTag.put(migrate.to, migrate.defaultValue);
                            }
                        });
                        Supplier<Item> itemSupplier = null;
                        for (Supplier<Item> key: supports.inverse().keySet()) {
                            if (key.get() == itemStack.getItem()) itemSupplier = key;
                        }
                        return Pair.of(new ItemStack(emptyBottleItem), FluidStack.create(supports.inverse().get(itemSupplier), amountPerBottle, fluidTag));
                    },
                    pair -> {
                        CompoundTag itemTag = new CompoundTag();
                        CompoundTag fluidTag = pair.getSecond().getOrCreateTag();
                        migrates.forEach(migrate -> {
                            if (fluidTag.contains(migrate.to)) {
                                itemTag.put(migrate.from, fluidTag.get(migrate.to));
                            } else {
                                itemTag.put(migrate.from, migrate.defaultValue);
                            }
                        });
                        ItemStack stack = new ItemStack(supports.get(pair.getSecond().getFluid()).get());
                        stack.setTag(itemTag);
                        return stack;
                    }
            );
            return new FluidDataAttachment(codec, amountPerBottle, migrates, supports, emptyBottleItem);
        }

        record NbtMigrate(String from, String to, Tag defaultValue) {}
    }
}
