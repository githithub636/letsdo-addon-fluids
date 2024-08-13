package dev.ninjdai.doaddoncreate.forge.platform;

import net.minecraftforge.fluids.FluidStack;

public interface FluidUtilsForge {

    static dev.architectury.fluid.FluidStack toArchitecturyFluidStack(FluidStack stack) {
        return dev.architectury.fluid.FluidStack.create(stack.getFluid(), stack.getAmount(), stack.getTag());
    }

    static FluidStack toForgeFluidStack(dev.architectury.fluid.FluidStack fluidStack) {
        return new FluidStack(fluidStack.getFluid(), (int) fluidStack.getAmount(), fluidStack.getTag());
    }

}
