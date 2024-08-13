package dev.ninjdai.doaddoncreate.forge.mixin;

import com.simibubi.create.content.fluids.transfer.GenericItemEmptying;
import com.simibubi.create.foundation.utility.Pair;
import dev.ninjdai.doaddoncreate.forge.platform.FluidUtilsForge;
import dev.ninjdai.doaddoncreate.utils.fluid.CreateFluidUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GenericItemEmptying.class, remap = false)
public class GenericItemEmptyingMixin {

    @Inject(method = "emptyItem", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/items/wrapper/RecipeWrapper;setItem(ILnet/minecraft/world/item/ItemStack;)V"), cancellable = true)
    private static void docreate$emptyItem(Level world, ItemStack stack, boolean simulate, CallbackInfoReturnable<Pair<FluidStack, ItemStack>> cir) {
        if (CreateFluidUtils.canBeEmptied(stack)) {
            Pair<dev.architectury.fluid.FluidStack, ItemStack> result = CreateFluidUtils.emptyBottle(stack, simulate);
            Pair<FluidStack, ItemStack> forgedResult = Pair.of(FluidUtilsForge.toForgeFluidStack(result.getFirst()), result.getSecond());
            cir.setReturnValue(forgedResult);
        }
    }

    @Inject(method = "canItemBeEmptied", at = @At(value = "HEAD"), cancellable = true)
    private static void docreate$canBeEmptied(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (CreateFluidUtils.canBeEmptied(stack)) cir.setReturnValue(true);
    }

}
