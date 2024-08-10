package dev.ninjdai.doaddoncreate.dependant.vinery;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.simibubi.create.foundation.utility.Pair;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import dev.architectury.fluid.FluidStack;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ninjdai.doaddoncreate.registry.DoAddonFluids;
import dev.ninjdai.doaddoncreate.registry.DoAddonTags;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import satisfyu.vinery.registry.ObjectRegistry;

public interface WineUtils {
    static FluidStack agingYear(RegistryEntry<Fluid> flowableFluid, int amount, int age) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("vinery:production_year", age);
        return FluidStack.create(flowableFluid.get(), amount, tag);
    }

    static ItemStack fillBottle(ItemStack stack, FluidStack availableFluid) {
        CompoundTag tag = availableFluid.getOrCreateTag();
        ItemStack bottleStack = new ItemStack(ObjectRegistry.NOIR_WINE_ITEM.get());
        bottleStack.getOrCreateTag().putInt("Year", tag.getInt("vinery:production_year"));
        return bottleStack;
    }

    static Pair<FluidStack, ItemStack> emptyBottle(ItemStack stack, boolean simulate) {
        RegistryEntry<Fluid> fl = FLUIDS_TO_BOTTLES.inverse().get(stack.getItem());
        CompoundTag fluidTag = new CompoundTag();
        fluidTag.putInt("vinery:production_year", stack.getOrCreateTag().getInt("Year"));
        FluidStack fluidStack = FluidStack.create(fl, 27000, fluidTag);
        if (!simulate)
            stack.shrink(1);
        return Pair.of(fluidStack, new ItemStack(ObjectRegistry.WINE_BOTTLE.get()));
    }

    static boolean canFill(ItemStack stack, FluidStack availableFluid) {
        //noinspection SuspiciousMethodCalls
        return stack.is(ObjectRegistry.WINE_BOTTLE.get()) &&
                FLUIDS_TO_BOTTLES.containsKey(
                        BuiltInRegistries.FLUID.getKey(availableFluid.getFluid())
                );
    }

    BiMap<RegistryEntry<Fluid>, Item> FLUIDS_TO_BOTTLES = ImmutableBiMap.of(
            Vinery.NOIR_WINE.flowing(), ObjectRegistry.NOIR_WINE_ITEM.get()
    );
}
