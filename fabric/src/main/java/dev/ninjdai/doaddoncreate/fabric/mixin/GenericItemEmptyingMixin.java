package dev.ninjdai.doaddoncreate.fabric.mixin;

import com.simibubi.create.content.fluids.transfer.GenericItemEmptying;
import com.simibubi.create.foundation.utility.Pair;
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
import satisfyu.vinery.registry.TagRegistry;

@SupportsMod("vinery")
@Mixin(GenericItemEmptying.class)
public class GenericItemEmptyingMixin {

    @Inject(method = "emptyItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Container;setItem(ILnet/minecraft/world/item/ItemStack;)V"), cancellable = true)
    private static void emptyWine(Level world, ItemStack stack, boolean simulate, CallbackInfoReturnable<Pair<FluidStack, ItemStack>> cir) {
        if (stack.is(TagRegistry.WINE)) {
            Pair<dev.architectury.fluid.FluidStack, ItemStack> result = WineUtils.emptyBottle(stack, simulate);
            Pair<FluidStack, ItemStack> fabricatedResult = Pair.of(WineUtilsFabric.toPLFluidStack(result.getFirst()), result.getSecond());
            cir.setReturnValue(fabricatedResult);
        }
    }

    @Inject(method = "canItemBeEmptied", at = @At(value = "HEAD"), cancellable = true)
    private static void isWine(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(TagRegistry.WINE)) cir.setReturnValue(true);
    }

}
