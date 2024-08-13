package dev.ninjdai.doaddoncreate.utils.fluid;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mojang.serialization.Codec;
import com.simibubi.create.foundation.utility.Pair;
import dev.architectury.fluid.FluidStack;
import dev.ninjdai.doaddoncreate.registry.DoAddonFluids;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ExtraFluidDataRegistry {

    LinkedHashMap<Item, Integer> SUPPORTED_FLUID_BOTTLES = new LinkedHashMap<>();
    LinkedHashMap<Fluid, Integer> SUPPORTED_FLUIDS = new LinkedHashMap<>();

    ArrayList<Item> SUPPORTED_EMPTY_BOTTLES = new ArrayList<>();
    ArrayList<Builder.Result> FLUID_SUPPORTS = new ArrayList<>();

    static void registerFluidBottle(Builder builder) {
        int index = FLUID_SUPPORTS.size();
        builder.supports.forEach((fluid, item) -> {
            SUPPORTED_FLUID_BOTTLES.put(item, index);
            SUPPORTED_FLUIDS.put(fluid, index);
        });

        SUPPORTED_EMPTY_BOTTLES.add(builder.emptyBottleItem);
        FLUID_SUPPORTS.add(builder.build());
    }


    class Builder {
        ArrayList<NbtMigrate> migrates = new ArrayList<>();
        int amountPerBottle = 27000;

        Item emptyBottleItem;

        BiMap<Fluid, Item> supports = HashBiMap.create();

        public Builder(Item emptyBottleItem) {
            this.emptyBottleItem = emptyBottleItem;
        }

        /**
         * Treat this method as an emptying simulation,
         * Migrates nbt data from the item to the fluid when emptying.
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
            supports.put(fluid.source().get(), fullBottleItem);
            return this;
        }

        Result build() {
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
                        return Pair.of(new ItemStack(emptyBottleItem), FluidStack.create(supports.inverse().get(itemStack.getItem()), amountPerBottle, fluidTag));
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
                        ItemStack stack = new ItemStack(supports.get(pair.getSecond().getFluid()));
                        stack.setTag(itemTag);
                        return stack;
                    }
            );
            return new Result(codec, amountPerBottle);
        }

        record NbtMigrate(String from, String to, Tag defaultValue) {}

        public record Result(Codec<Pair<ItemStack, FluidStack>> codec, int amountPerBottle) {}
    }
}
