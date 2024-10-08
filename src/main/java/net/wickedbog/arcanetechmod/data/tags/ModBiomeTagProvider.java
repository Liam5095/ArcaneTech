package net.wickedbog.arcanetechmod.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.TagsInit;
import net.wickedbog.arcanetechmod.worldgen.biome.ModBiomes;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends BiomeTagsProvider {
    public ModBiomeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, ArcaneTechMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //tag(TagsInit.BiomeTagsInit.IS_ENHANCED_FOREST).add(ModBiomes.ENCHANED_FOREST);
        //tag(TagsInit.BiomeTagsInit.IS_MYTHICAL_REALM).add(ModBiomes.ENCHANED_FOREST);
    }

    @SafeVarargs
    private void tag(ResourceKey<Biome> biome, TagKey<Biome>... tags) {
        for (TagKey<Biome> key : tags) {
            tag(key).add(biome);
        }
    }
}
