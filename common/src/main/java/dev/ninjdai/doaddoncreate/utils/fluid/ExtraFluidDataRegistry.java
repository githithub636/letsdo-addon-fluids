package dev.ninjdai.doaddoncreate.utils.fluid;

import dev.ninjdai.doaddoncreate.DoAddonCreate;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ExtraFluidDataRegistry {

    LinkedHashMap<Item, Integer> SUPPORTED_FLUID_BOTTLES = new LinkedHashMap<>();
    LinkedHashMap<Fluid, Integer> SUPPORTED_FLUIDS = new LinkedHashMap<>();

    ArrayList<Item> SUPPORTED_EMPTY_BOTTLES = new ArrayList<>();
    ArrayList<FluidDataAttachment> FLUID_SUPPORTS = new ArrayList<>();

    static void registerFluidDA(FluidDataAttachment fluidAttachment) {
        int index = FLUID_SUPPORTS.size();
        fluidAttachment.supports().forEach((fluid, item) -> {
            SUPPORTED_FLUID_BOTTLES.put(item.get(), index);
            SUPPORTED_FLUIDS.put(fluid, index);
        });

        SUPPORTED_EMPTY_BOTTLES.add(fluidAttachment.emptyBottleItem());
        FLUID_SUPPORTS.add(fluidAttachment);
    }

}
