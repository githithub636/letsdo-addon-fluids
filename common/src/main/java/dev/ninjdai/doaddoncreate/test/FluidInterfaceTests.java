package dev.ninjdai.doaddoncreate.test;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.infrastructure.gametest.CreateGameTestHelper;
import com.simibubi.create.infrastructure.gametest.GameTestGroup;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import dev.ninjdai.doaddoncreate.registry.DoAddonFluids;
import dev.ninjdai.doaddoncreate.utils.fluid.CreateFluidUtils;
import dev.architectury.fluid.FluidStack;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

import java.util.concurrent.atomic.AtomicInteger;

@GameTestGroup(namespace = "doaddoncreate", path = "fluids")
public class FluidInterfaceTests {

    @GameTest(template = "filling")
    public static void filling(CreateGameTestHelper helper) {
        /*for (int fluidIndex = 0; fluidIndex < 10; fluidIndex++) {
            Fluid unboxedFluid = (Fluid) DoAddonFluids.FLUIDS.getEntries().toArray(RegistryEntry[]::new)[fluidIndex].get();
            BlockPos tankPos = helper.absolutePos(new BlockPos(fluidIndex, 2, 2));
            world.setBlockAndUpdate(tankPos, AllBlocks.FLUID_TANK.get().defaultBlockState());
            if (world.getBlockEntity(tankPos) instanceof FluidTankBlockEntity be) {
                CreateFluidUtils.setFluidStack(be, FluidStack.create(unboxedFluid, CreateFluidUtils.getTotalSize(be)));
            } else helper.fail("Sus");
        };*/
        helper.succeed();
    }

}
