package dev.ninjdai.doaddoncreate.utils.fluid;

import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.foundation.utility.Pair;
import dev.architectury.fluid.FluidStack;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.ninjdai.doaddoncreate.utils.CodecUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

public interface CreateFluidUtils {

    // Generic
    static boolean isSupportedFluid(Fluid fluid) {
        return ExtraFluidDataRegistry.SUPPORTED_FLUIDS
                .containsKey(fluid);
    }

    // Emptying
    static boolean canBeEmptied(ItemStack stack) {
        return ExtraFluidDataRegistry.SUPPORTED_FLUID_BOTTLES
                .containsKey(stack.getItem());
    }

    static Pair<FluidStack, ItemStack> emptyBottle(ItemStack IS, boolean simulate) {
        Pair<FluidStack, ItemStack> fluid = CodecUtils.decodeSimple(
                ExtraFluidDataRegistry.FLUID_SUPPORTS.get(
                        ExtraFluidDataRegistry.SUPPORTED_FLUID_BOTTLES.get(IS.getItem())
                ).codec(), IS.save(new CompoundTag())
        ).swap();
        if (!simulate)
            IS.shrink(1);
        return fluid;
    }

    static int getRequiredAmountForItem(Fluid fluid) {
        int index = ExtraFluidDataRegistry.SUPPORTED_FLUIDS.get(fluid);
        return ExtraFluidDataRegistry.FLUID_SUPPORTS.get(index).amountPerBottle();
    }

    // Filling
    static boolean canBeFilled(ItemStack stack) {
        return ExtraFluidDataRegistry.SUPPORTED_EMPTY_BOTTLES
                .contains(stack.getItem());
    }


    static ItemStack fillBottle(ItemStack IS, FluidStack fluid) {
        fluid.grow(1);
        Tag itemStack = CodecUtils.encodeSimple(
                ExtraFluidDataRegistry.FLUID_SUPPORTS.get(
                        ExtraFluidDataRegistry.SUPPORTED_FLUIDS.get(fluid.getFluid())
                ).codec(), Pair.of(IS, fluid)
        );
        fluid.shrink(1);
        return ItemStack.of((CompoundTag) itemStack);
    }

    @ExpectPlatform
    static void setFluidStack(FluidTankBlockEntity be, FluidStack stack) {}

    @ExpectPlatform
    static int getTotalSize(FluidTankBlockEntity be) { return 0; }
}
