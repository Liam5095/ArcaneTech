package net.wickedbog.arcanetechmod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;

import java.util.List;

public class ModConfiguredFeatures {

    // ORES

    protected static ResourceKey<ConfiguredFeature<?,?>> MYTHICAL_REALM_ARCANE_ORE_KEY = createKey("arcane_ore");
    protected static ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_RUNIC_ORE_KEY = createKey("runic_ore");
    protected static ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_MYTHIC_ESSENCE_ORE_KEY = createKey("mythic_essence_ore");

    // TREES

    public static ResourceKey<ConfiguredFeature<?,?>> GLOWWOOD_TREE_KEY = createKey("glowwood_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplacable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> arcaneOre = List.of(OreConfiguration.target(stoneReplacable, BlockInit.ARCANE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, BlockInit.DEEPSLATE_ARCANE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> runicOre = List.of(OreConfiguration.target(stoneReplacable, BlockInit.RUNIC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, BlockInit.DEEPSLATE_RUNIC_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> mythicEssence = List.of(OreConfiguration.target(stoneReplacable, BlockInit.MYTHIC_ESSENCE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, BlockInit.DEEPSLATE_MYTHIC_ESSENCE_ORE.get().defaultBlockState()));

        register(context, MYTHICAL_REALM_ARCANE_ORE_KEY, Feature.ORE, new OreConfiguration(arcaneOre,4));
        register(context, OVERWORLD_RUNIC_ORE_KEY, Feature.ORE, new OreConfiguration(runicOre,6));
        register(context, OVERWORLD_MYTHIC_ESSENCE_ORE_KEY, Feature.ORE, new OreConfiguration(mythicEssence,5));

        register(context, GLOWWOOD_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockInit.GLOWWOOD_LOG.get()),
                new StraightTrunkPlacer(5, 4, 3),
                BlockStateProvider.simple(BlockInit.GLOWWOOD_LEAVES.get()),
                new PineFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(4)),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ArcaneTechMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
