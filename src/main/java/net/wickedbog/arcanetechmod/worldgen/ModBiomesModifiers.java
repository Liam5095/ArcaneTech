package net.wickedbog.arcanetechmod.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.TagsInit;
import net.wickedbog.arcanetechmod.worldgen.biome.ModBiomes;

public class ModBiomesModifiers {
    protected static ResourceKey<BiomeModifier> ADD_ARCANE_ORE = registerKey("add_arcane_ore");
    protected static ResourceKey<BiomeModifier> ADD_RUNIC_ORE = registerKey("add_runic_ore");
    protected static ResourceKey<BiomeModifier> ADD_MYTHIC_ESSENCE_ORE = registerKey("add_mythic_essence_ore");

    protected static ResourceKey<BiomeModifier> ADD_TREE_GLOWWOOD = registerKey("add_tree_glowwood");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        // ORE

        context.register(
                ADD_ARCANE_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(TagsInit.BiomeTagsInit.IS_MYTHICAL_REALM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ARCANE_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(
                ADD_RUNIC_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUNIC_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(
                ADD_MYTHIC_ESSENCE_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MYTHIC_ESSENCE_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES));
        // WOOD

        context.register(
                ADD_TREE_GLOWWOOD,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(TagsInit.BiomeTagsInit.IS_ENHANCED_FOREST),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GLOWWOOD_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(
                NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ArcaneTechMod.MOD_ID, name));
    }
}
