package net.wickedbog.arcanetechmod.data.texture;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ArcaneTechMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlock(BlockInit.EXAMPLE_BLOCK.get());
        normalBlock(BlockInit.ARCANE_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_ARCANE_ORE.get());
        normalBlock(BlockInit.RUNIC_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_RUNIC_ORE.get());
        normalBlock(BlockInit.MYTHIC_ESSENCE_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_MYTHIC_ESSENCE_ORE.get());
        normalBlock(BlockInit.MYTHIC_STONE.get());

        logBlock(((RotatedPillarBlock) BlockInit.GLOWWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockInit.GLOWWOOD.get()), blockTexture(BlockInit.GLOWWOOD_LOG.get()), blockTexture(BlockInit.GLOWWOOD_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockInit.STRIPPED_GLOWWOOD_LOG.get(), new ResourceLocation(ArcaneTechMod.MOD_ID, "block/stripped_glowwood_log"),
                new ResourceLocation(ArcaneTechMod.MOD_ID, "block/stripped_glowwood_log_top"));
        axisBlock((RotatedPillarBlock) BlockInit.STRIPPED_GLOWWOOD.get(), new ResourceLocation(ArcaneTechMod.MOD_ID, "block/stripped_glowwood_log"),
                new ResourceLocation(ArcaneTechMod.MOD_ID, "block/stripped_glowwood_log"));

        blockItem(BlockInit.GLOWWOOD_LOG.get());
        blockItem(BlockInit.GLOWWOOD.get());
        blockItem(BlockInit.STRIPPED_GLOWWOOD_LOG.get());
        blockItem(BlockInit.STRIPPED_GLOWWOOD.get());

        normalBlock(BlockInit.GLOWWOOD_PLANKS.get());

        leavesBlock(BlockInit.GLOWWOOD_LEAVES.get());
        saplingBlock(BlockInit.GLOWWOOD_SAPLING.get());
        //normalBlock(BlockInit.ARCANE_GATEWAY.get());
    }

    protected void normalBlock(Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block, models().cubeAll(path, modLoc("block/" + path)));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path)));
    }

    private void leavesBlock(Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlockWithItem(block,
                models().cubeAll(path, blockTexture(block)).renderType("cutout"));
    }

    private void saplingBlock(Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block,
                models().cross(path, blockTexture(block)).renderType("cutout"));
    }

    private void blockItem(Block block, String appendix) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("arcanetechmod:block/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + appendix));
    }

    private void blockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("arcanetechmod:block/" + BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }
}
