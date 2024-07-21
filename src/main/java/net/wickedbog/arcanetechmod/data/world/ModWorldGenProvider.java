package net.wickedbog.arcanetechmod.data.world;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.worldgen.ModBiomesModifiers;
import net.wickedbog.arcanetechmod.worldgen.ModConfiguredFeatures;
import net.wickedbog.arcanetechmod.worldgen.ModPlacedFeatures;
import net.wickedbog.arcanetechmod.worldgen.dimension.ModDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                new RegistrySetBuilder()
                        .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
                        .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
                        .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomesModifiers::bootstrap)
                        .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
                        .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType),
                Set.of(ArcaneTechMod.MOD_ID));
    }
}
