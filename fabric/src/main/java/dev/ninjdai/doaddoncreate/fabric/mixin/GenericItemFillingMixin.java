package dev.ninjdai.doaddoncreate.fabric.mixin;

import com.simibubi.create.content.fluids.transfer.GenericItemFilling;
import dev.ninjdai.doaddoncreate.dependant.vinery.WineUtils;
import dev.ninjdai.doaddoncreate.fabric.dependant.WineUtilsFabric;
import dev.ninjdai.doaddoncreate.reflection.annotations.SupportsMod;
import io.github.fabricators_of_create.porting_lib.fluids.FluidStack;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import satisfyu.vinery.registry.ObjectRegistry;

@SupportsMod("vinery")
@Mixin(GenericItemFilling.class)
public class GenericItemFillingMixin {

    @Inject(method = "fillItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;copy()Lnet/minecraft/world/item/ItemStack;"), cancellable = true)
    private static void fillItem(Level world, long requiredAmount, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<ItemStack> cir) {
        dev.architectury.fluid.FluidStack archStack = WineUtilsFabric.toArchitecturyFluidStack(availableFluid);
        if (WineUtils.canFill(stack, archStack)) {
            cir.setReturnValue(WineUtils.fillBottle(cir.getReturnValue(), archStack));
        }
    }

    @Inject(method = "getRequiredAmountForItem", at = @At(value = "HEAD"), cancellable = true)
    private static void getRequiredAmountForItem(Level world, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<Long> cir) {
        if (WineUtils.canFill(stack, WineUtilsFabric.toArchitecturyFluidStack(availableFluid))) {
            cir.setReturnValue(27000L);
        }
    }

    @Inject(method = "canItemBeFilled", at = @At(value = "HEAD"), cancellable = true)
    private static void canItemBeFilled(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(ObjectRegistry.WINE_BOTTLE.get())) cir.setReturnValue(true);
    }
}
