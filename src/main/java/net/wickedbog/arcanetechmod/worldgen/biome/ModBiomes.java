package net.wickedbog.arcanetechmod.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.entity.EntityInit;

public class ModBiomes {
    //BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);

    //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_TAIGA);

    //BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
    //BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

    //biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.ARCANE_ORE); dont know if works

    public static final ResourceKey<Biome> ENCHANED_FOREST = register("enchaned_forest");
    public static final ResourceKey<Biome> CRYSTAL_CAVES = register("crystal_caves");

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(ENCHANED_FOREST, enchanedForest(context));
    }

    public static void enchanedForestGeneration(BiomeGenerationSettings.Builder builder, MobSpawnSettings.Builder spawnBuilder) {
        // FEATURES

        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultFlowers(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultGrass(builder);

        // CUSTOM SPAWNS

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 2, 5));
        spawnBuilder.addSpawn(MobCategory.MISC, new MobSpawnSettings.SpawnerData(EntityInit.FAIRY_SWARM.get(), 5, 2, 4));

        // DEFAULT SPAWNS

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
    }

    public static void crystalCavesGeneration(BiomeGenerationSettings.Builder builder, MobSpawnSettings.Builder spawnBuilder) {
        // FEATURES

        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultGrass(builder);

        // CUSTOM SPAWNS


        // DEFAULT SPAWNS

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome enchanedForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        enchanedForestGeneration(biomeBuilder, spawnBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .skyColor(7907327)
                        .fogColor(12638463)
                        .waterColor(4159204)
                        .waterFogColor(4159204).build())
                .build();
    }

    public static final Biome crystalCaves(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        crystalCavesGeneration(biomeBuilder, spawnBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(7907327)
                        .fogColor(12638463)
                        .waterColor(4159204)
                        .waterFogColor(4159204)
                        .ambientMoodSound(new AmbientMoodSettings(
                                SoundEvents.AMBIENT_CAVE,
                                6000,
                                8,
                                2))
                        .build())
                .build();
    }

    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(ArcaneTechMod.MOD_ID, name));
    }
}
