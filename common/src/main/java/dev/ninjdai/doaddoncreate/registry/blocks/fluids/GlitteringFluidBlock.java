package dev.ninjdai.doaddoncreate.registry.blocks.fluids;

import earth.terrarium.botarium.common.registry.fluid.BotariumLiquidBlock;
import earth.terrarium.botarium.common.registry.fluid.FluidData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GlitteringFluidBlock extends BotariumLiquidBlock {
    public GlitteringFluidBlock(FluidData data, Properties properties) {
        super(data, properties);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource randomSource) {
        super.animateTick(blockState, level, pos, randomSource);
        if (randomSource.nextInt(16) == 0) {
            BlockPos blockPos = pos.below();
            if (FallingBlock.isFree(level.getBlockState(blockPos))) {
                double d = pos.getX() + randomSource.nextDouble();
                double e = pos.getY() + 1;
                double f = pos.getZ() + randomSource.nextDouble();
                level.addParticle(ParticleTypes.END_ROD, d, e, f, 0.0, 0.2, 0.0);
            }
        }
    }
}
