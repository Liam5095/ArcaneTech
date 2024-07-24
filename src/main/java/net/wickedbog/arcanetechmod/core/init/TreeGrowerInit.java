package net.wickedbog.arcanetechmod.core.init;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Map;
import java.util.Optional;

public class TreeGrowerInit {

    private static final Map<String, TreeGrower> GROWERS = new Object2ObjectArrayMap<>();
    public static final TreeGrower GLOWWOOD = new TreeGrower(
            "glowwood",
            0.1F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(TreeFeatures.PINE),
            Optional.of(TreeFeatures.FANCY_OAK),
            Optional.of(TreeFeatures.FANCY_OAK_BEES),
            Optional.empty()
    );
}
