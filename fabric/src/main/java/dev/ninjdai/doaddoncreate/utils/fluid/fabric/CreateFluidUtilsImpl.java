package dev.ninjdai.doaddoncreate.utils.fluid.fabric;

import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import io.github.fabricators_of_create.porting_lib.fluids.FluidStack;

public interface CreateFluidUtilsImpl {
    static void setFluidStack(FluidTankBlockEntity be, dev.architectury.fluid.FluidStack stack) {
        FluidStack steak = new FluidStack(stack.getFluid(), stack.getAmount(), stack.getOrCreateTag());
        be.getTankInventory().setFluid(steak);
    }

    static int getTotalSize(FluidTankBlockEntity be) {
     return be.getTotalTankSize();
    }
}
