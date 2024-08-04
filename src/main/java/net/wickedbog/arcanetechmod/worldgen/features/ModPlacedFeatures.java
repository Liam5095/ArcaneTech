package net.wickedbog.arcanetechmod.worldgen.features;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.worldgen.ModOrePlacement;

import java.util.List;

public class ModPlacedFeatures {

    // ORES

    public static final ResourceKey<PlacedFeature> ARCANE_ORE_PLACED_KEY = createKey("arcane_ore_placed");
    public static final ResourceKey<PlacedFeature> RUNIC_ORE_PLACED_KEY = createKey("runic_ore_placed");
    public static final ResourceKey<PlacedFeature> MYTHIC_ESSENCE_ORE_PLACED_KEY = createKey("mythic_essence_ore_placed");

    // TREES

    public static final ResourceKey<PlacedFeature> GLOWWOOD_PLACED_KEY = createKey("glowwood_placed");

    // FLOWERS

    public static final ResourceKey<PlacedFeature> MYSTIC_FLOWER_PLACED_KEY = createKey("mystic_flower_placed");

    // CRYSTALS

    public static final ResourceKey<PlacedFeature> RED_CRYSTAL_PLACED_KEY = createKey("red_crystal_placed");
    public static final ResourceKey<PlacedFeature> GREEN_CRYSTAL_PLACED_KEY = createKey("green_crystal_placed");
    public static final ResourceKey<PlacedFeature> BLUE_CRYSTAL_PLACED_KEY = createKey("blue_crystal_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // ORES

        Holder<ConfiguredFeature<?,? >> holder =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.MYTHICAL_REALM_ARCANE_ORE_KEY);
        Holder<ConfiguredFeature<?,? >> holder1 =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUNIC_ORE_KEY);
        Holder<ConfiguredFeature<?,? >> holder2 =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MYTHIC_ESSENCE_ORE_KEY);

        Holder<ConfiguredFeature<?,? >> holder3 =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_CRYSTAL_KEY);
        Holder<ConfiguredFeature<?,? >> holder4 =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.GREEN_CRYSTAL_KEY);
        Holder<ConfiguredFeature<?,? >> holder5 =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUE_CRYSTAL_KEY);

        // ORES

        // 3 veins per chunk, between y -64 and 50
        register(context, ARCANE_ORE_PLACED_KEY, holder, ModOrePlacement.commonOrePlacements(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(20))));
        register(context, RUNIC_ORE_PLACED_KEY, holder1, ModOrePlacement.commonOrePlacements(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-15), VerticalAnchor.absolute(42))));
        register(context, MYTHIC_ESSENCE_ORE_PLACED_KEY, holder2, ModOrePlacement.commonOrePlacements(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-25), VerticalAnchor.absolute(30))));

        // WOOD

        register(context, GLOWWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GLOWWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        BlockInit.GLOWWOOD_SAPLING.get()));

        // FLOWERS

        register(context, MYSTIC_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MYSTIC_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        // CRYSTALS

        register(context, RED_CRYSTAL_PLACED_KEY, holder3, ModOrePlacement.commonOrePlacements(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(35))));
        register(context, GREEN_CRYSTAL_PLACED_KEY, holder4, ModOrePlacement.commonOrePlacements(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(35))));
        register(context, BLUE_CRYSTAL_PLACED_KEY, holder5, ModOrePlacement.rareOrePlacements(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-15), VerticalAnchor.absolute(30))));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ArcaneTechMod.MOD_ID, name));
    }


    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> feature, List<PlacementModifier> placements) {
        context.register(key, new PlacedFeature(feature, placements));
    }
}
