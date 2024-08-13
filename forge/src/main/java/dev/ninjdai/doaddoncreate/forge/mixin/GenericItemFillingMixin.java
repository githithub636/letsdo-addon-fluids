package dev.ninjdai.doaddoncreate.forge.mixin;

import com.simibubi.create.content.fluids.transfer.GenericItemFilling;
import dev.ninjdai.doaddoncreate.forge.platform.FluidUtilsForge;
import dev.ninjdai.doaddoncreate.utils.fluid.CreateFluidUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GenericItemFilling.class, remap = false)
public class GenericItemFillingMixin {

    @Inject(method = "fillItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;copy()Lnet/minecraft/world/item/ItemStack;"), cancellable = true)
    private static void docreate$fillItem(Level world, int requiredAmount, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<ItemStack> cir) {
        dev.architectury.fluid.FluidStack archStack = FluidUtilsForge.toArchitecturyFluidStack(availableFluid);
        if (CreateFluidUtils.canBeFilled(stack) && CreateFluidUtils.isSupportedFluid(availableFluid.getFluid())) {
            stack.shrink(1);
            cir.setReturnValue(CreateFluidUtils.fillBottle(stack, archStack));
        }
    }

    @Inject(method = "getRequiredAmountForItem", at = @At(value = "HEAD"), cancellable = true)
    private static void docreate$getReqAmount(Level world, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<Long> cir) {
        if (CreateFluidUtils.canBeFilled(stack) && CreateFluidUtils.isSupportedFluid(availableFluid.getFluid())) {
            cir.setReturnValue((long) CreateFluidUtils.getRequiredAmountForItem(availableFluid.getFluid()));
        }
    }

    @Inject(method = "canItemBeFilled", at = @At(value = "HEAD"), cancellable = true)
    private static void docreate$canItemBeFilled(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (CreateFluidUtils.canBeFilled(stack)) cir.setReturnValue(true);
    }
}
