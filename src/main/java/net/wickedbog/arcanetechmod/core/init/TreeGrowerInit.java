package net.wickedbog.arcanetechmod.core.init;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.wickedbog.arcanetechmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class TreeGrowerInit {
    public static final TreeGrower GLOWWOOD = new TreeGrower(
        "glowwood",
        0.1F,
        Optional.empty(),
        Optional.empty(),
        Optional.of(ModConfiguredFeatures.GLOWWOOD_TREE_KEY),
        Optional.of(TreeFeatures.SPRUCE),
            Optional.empty(),
            Optional.empty()
    );
}
