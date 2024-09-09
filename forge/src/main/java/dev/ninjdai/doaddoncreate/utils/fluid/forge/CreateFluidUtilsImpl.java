package dev.ninjdai.doaddoncreate.utils.fluid.forge;

import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

public interface CreateFluidUtilsImpl {
    static void setFluidStack(FluidTankBlockEntity be, dev.architectury.fluid.FluidStack stack) {
        FluidStack steak = new FluidStack(stack.getFluid(), (int)stack.getAmount(), stack.getOrCreateTag());
        be.getTankInventory().fill(steak, IFluidHandler.FluidAction.EXECUTE);
    }

    static int getTotalSize(FluidTankBlockEntity be) {
        return be.getTotalTankSize();
    }
}
