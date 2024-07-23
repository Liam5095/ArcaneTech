package net.wickedbog.arcanetechmod.core.init.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MythicEssenceOreBlock extends Block {
    public MythicEssenceOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
        return (silktouch == 0 ? 1 + randomSource.nextInt(5) : 0) + 1;
    }
}
