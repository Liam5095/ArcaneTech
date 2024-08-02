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
import net.wickedbog.arcanetechmod.worldgen.features.ModPlacedFeatures;

public class ModBiomesModifiers {

    // ORES

    public static final ResourceKey<BiomeModifier> ADD_ARCANE_ORE = registerKey("add_arcane_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUNIC_ORE = registerKey("add_runic_ore");
    public static final ResourceKey<BiomeModifier> ADD_MYTHIC_ESSENCE_ORE = registerKey("add_mythic_essence_ore");

    // TREES

    public static final ResourceKey<BiomeModifier> ADD_TREE_GLOWWOOD = registerKey("add_tree_glowwood");

    // ENTITY SPAWNING

    //public static final ResourceKey<BiomeModifier> SPAWN_FAIRY_SWARM = registerKey("spawn_fairy_swarm");

    // FLOWERS

    public static final ResourceKey<BiomeModifier> ADD_MYSTIC_FLOWER = registerKey("add_mystic_flower");

    // CRYSTALS

    public static final ResourceKey<BiomeModifier> ADD_RED_CRYSTAL = registerKey("add_red_crystal");
    public static final ResourceKey<BiomeModifier> ADD_GREEN_CRYSTAL = registerKey("add_green_crystal");
    public static final ResourceKey<BiomeModifier> ADD_BLUE_CRYSTAL = registerKey("add_blue_crystal");

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

        // ENTITY SPAWNING

        //context.register(
        //        SPAWN_FAIRY_SWARM,
        //        new BiomeModifiers.AddSpawnsBiomeModifier(
        //                biomes.getOrThrow(TagsInit.BiomeTagsInit.IS_ENHANCED_FOREST),
        //                List.of(new MobSpawnSettings.SpawnerData(EntityInit.FAIRY_SWARM.get(), 50,1 ,4))
        //        )
        //);

        // FLOWERS

        context.register(ADD_MYSTIC_FLOWER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(TagsInit.BiomeTagsInit.IS_ENHANCED_FOREST),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MYSTIC_FLOWER_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                ));

        // CRYSTALS

        context.register(ADD_RED_CRYSTAL,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(TagsInit.BiomeTagsInit.IS_CRYSTAL_CAVES),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RED_CRYSTAL_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_DECORATION
                ));

        context.register(ADD_GREEN_CRYSTAL,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(TagsInit.BiomeTagsInit.IS_CRYSTAL_CAVES),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GREEN_CRYSTAL_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_DECORATION
                ));

        context.register(ADD_BLUE_CRYSTAL,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(TagsInit.BiomeTagsInit.IS_CRYSTAL_CAVES),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLUE_CRYSTAL_PLACED_KEY    )),
                        GenerationStep.Decoration.UNDERGROUND_DECORATION
                ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(
                NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ArcaneTechMod.MOD_ID, name));
    }
}
