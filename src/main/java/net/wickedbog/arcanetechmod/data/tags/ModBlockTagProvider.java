package net.wickedbog.arcanetechmod.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.BlockInit;
import net.wickedbog.arcanetechmod.core.init.TagsInit;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ArcaneTechMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(TagsInit.BlockTagsInit.ARCANE_ORE).add(BlockInit.ARCANE_ORE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.ARCANE_ORE.get())
                .add(BlockInit.DEEPSLATE_ARCANE_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.ARCANE_ORE.get())
                .add(BlockInit.DEEPSLATE_ARCANE_ORE.get());
    }

    private static TagKey<Block> createForgeTag(String name) {
        return BlockTags.create(new ResourceLocation(name));
    }
}
