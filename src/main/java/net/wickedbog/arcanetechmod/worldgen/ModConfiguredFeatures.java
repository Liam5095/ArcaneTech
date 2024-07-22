package net.wickedbog.arcanetechmod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;

import java.util.List;

public class ModConfiguredFeatures {

    protected static ResourceKey<ConfiguredFeature<?,?>> MYTHICAL_REALM_ARCANE_ORE = createKey("arcane_ore");
    protected static ResourceKey<ConfiguredFeature<?,?>> RUNIC_ORE = createKey("runic_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplacable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> arcaneOre = List.of(OreConfiguration.target(stoneReplacable, BlockInit.ARCANE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, BlockInit.DEEPSLATE_ARCANE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> runicOre = List.of(OreConfiguration.target(stoneReplacable, BlockInit.RUNIC_ORE.get().defaultBlockState()));

        register(context, MYTHICAL_REALM_ARCANE_ORE, Feature.ORE, new OreConfiguration(arcaneOre,4));
        register(context, RUNIC_ORE, Feature.ORE, new OreConfiguration(arcaneOre,6));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ArcaneTechMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
