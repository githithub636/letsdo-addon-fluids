package dev.ninjdai.doaddoncreate.fabric.dependant;

import io.github.fabricators_of_create.porting_lib.fluids.FluidStack;

public interface WineUtilsFabric {

    static dev.architectury.fluid.FluidStack toArchitecturyFluidStack(FluidStack stack) {
        return dev.architectury.fluid.FluidStack.create(stack.getFluid(), stack.getAmount(), stack.getTag());
    }

    static FluidStack toPLFluidStack(dev.architectury.fluid.FluidStack fluidStack) {
        return new FluidStack(fluidStack.getFluid(), fluidStack.getAmount(), fluidStack.getTag());
    }

}
