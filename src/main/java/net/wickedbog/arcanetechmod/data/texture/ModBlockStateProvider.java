package net.wickedbog.arcanetechmod.data.texture;

import com.google.gson.JsonObject;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.client.energy.cables.CableModelLoader;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;

import java.util.function.BiConsumer;

public class ModBlockStateProvider extends BlockStateProvider {
    public static final ResourceLocation BOTTOM = new ResourceLocation(ArcaneTechMod.MOD_ID, "block/machine_bottom");
    public static final ResourceLocation TOP = new ResourceLocation(ArcaneTechMod.MOD_ID, "block/machine_top");
    public static final ResourceLocation SIDE = new ResourceLocation(ArcaneTechMod.MOD_ID, "block/machine_side");

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ArcaneTechMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // TESTING

        normalBlock(BlockInit.EXAMPLE_BLOCK.get());

        // ARCANE

        normalBlock(BlockInit.ARCANE_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_ARCANE_ORE.get());

        // RUNIC

        normalBlock(BlockInit.RUNIC_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_RUNIC_ORE.get());

        // MYTHIC ESSENCE

        normalBlock(BlockInit.MYTHIC_ESSENCE_ORE.get());
        normalBlock(BlockInit.DEEPSLATE_MYTHIC_ESSENCE_ORE.get());

        // CRYSTALS

        normalBlock(BlockInit.RED_CRYSTAL.get());
        normalBlock(BlockInit.GREEN_CRYSTAL.get());
        normalBlock(BlockInit.BLUE_CRYSTAL.get());

        // GLOWWOOD

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

        // OTHER

        normalBlock(BlockInit.MYTHIC_STONE.get());

        registerFacade();
        registerCable();
        registerGenerator();
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

    private void registerCable() {
        BlockModelBuilder model = models().getBuilder("cable")
                .parent(models().getExistingFile(mcLoc("cube")))
                .customLoader((builder, helper) -> new CableLoaderBuilder(CableModelLoader.GENERATOR_LOADER, builder, helper, false))
                .end();
        simpleBlock(BlockInit.CABLE.get(), model);
    }

    private void registerFacade() {
        BlockModelBuilder model = models().getBuilder("facade")
                .parent(models().getExistingFile(mcLoc("cube")))
                .customLoader((builder, helper) -> new CableLoaderBuilder(CableModelLoader.GENERATOR_LOADER, builder, helper, true))
                .end();
        simpleBlock(BlockInit.FACADE_BLOCK.get(), model);
    }

    private void registerGenerator() {
        BlockModelBuilder modelOn = models().cube(BlockInit.GENERATOR_BLOCK.getId().getPath()+"_on", BOTTOM, TOP, modLoc("block/generator_block_on"), SIDE, SIDE, SIDE).texture("particle", SIDE);
        BlockModelBuilder modelOff = models().cube(BlockInit.GENERATOR_BLOCK.getId().getPath()+"_off", BOTTOM, TOP, modLoc("block/generator_block"), SIDE, SIDE, SIDE).texture("particle", SIDE);
        directionBlock(BlockInit.GENERATOR_BLOCK.get(), (state, builder) -> {
            builder.modelFile(state.getValue(BlockStateProperties.POWERED) ? modelOn : modelOff);
        });
    }

    private VariantBlockStateBuilder directionBlock(Block block, BiConsumer<BlockState, ConfiguredModel.Builder<?>> model) {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(state -> {
            ConfiguredModel.Builder<?> bld = ConfiguredModel.builder();
            model.accept(state, bld);
            applyRotationBld(bld, state.getValue(BlockStateProperties.FACING));
            return bld.build();
        });
        return builder;
    }

    private void applyRotationBld(ConfiguredModel.Builder<?> builder, Direction direction) {
        switch (direction) {
            case DOWN -> builder.rotationX(90);
            case UP -> builder.rotationX(-90);
            case NORTH -> { }
            case SOUTH -> builder.rotationY(180);
            case WEST -> builder.rotationY(270);
            case EAST -> builder.rotationY(90);
        }
    }

    public static class CableLoaderBuilder extends CustomLoaderBuilder<BlockModelBuilder> {

        private final boolean facade;

        public CableLoaderBuilder(ResourceLocation loader, BlockModelBuilder parent, ExistingFileHelper existingFileHelper,
                                  boolean facade) {
            super(loader, parent, existingFileHelper, facade);
            this.facade = facade;
        }

        @Override
        public JsonObject toJson(JsonObject json) {
            JsonObject obj = super.toJson(json);
            obj.addProperty("facade", facade);
            return obj;
        }
    }
}
