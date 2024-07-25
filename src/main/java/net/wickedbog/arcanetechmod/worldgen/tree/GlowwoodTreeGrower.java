package net.wickedbog.arcanetechmod.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.wickedbog.arcanetechmod.worldgen.ModConfiguredFeatures;

public class GlowwoodTreeGrower {
    public ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean largeHive) {
        return ModConfiguredFeatures.GLOWWOOD_TREE_KEY;
    }
}
