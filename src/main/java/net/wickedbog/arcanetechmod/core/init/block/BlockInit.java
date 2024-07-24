package net.wickedbog.arcanetechmod.core.init.block;

import foundry.veil.api.opencl.VeilOpenCL;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.TreeGrowerInit;
import net.wickedbog.arcanetechmod.core.init.block.custom.ArcaneGatewayBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.ModFlammableRotatedPillarBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.MythicEssenceOreBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.RunicOreBlock;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ArcaneTechMod.MOD_ID);

    // DEBUG / TESTING STUFF

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE)));

    // RUNIC STUFF

    public static final DeferredBlock<Block> RUNIC_ORE = registerBlock("runic_ore", () -> new
            RunicOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_RUNIC_ORE = registerBlock("deepslate_runic_ore", () -> new
            RunicOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));

    // MYTHIC ESSENCE STUFF

    public static final DeferredBlock<Block> MYTHIC_ESSENCE_ORE = registerBlock("mythic_essence_ore", () -> new
            MythicEssenceOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_MYTHIC_ESSENCE_ORE = registerBlock("deepslate_mythic_essence_ore", () -> new
            MythicEssenceOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final DeferredBlock<Block> MYTHIC_STONE = registerBlock("mythic_stone", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    // ARCANE STUFF

    public static final DeferredBlock<Block> ARCANE_ORE = registerBlock("arcane_ore", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_ARCANE_ORE = registerBlock("deepslate_arcane_ore", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final DeferredBlock<Block> ARCANE_GATEWAY = registerBlock("arcane_gateway", () -> new
            ArcaneGatewayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_PORTAL).noOcclusion()));

    // Glowwood

    public static final DeferredBlock<Block> GLOWWOOD_LOG = registerBlock("glowwood_log", () -> new
            ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> GLOWWOOD = registerBlock("glowwood", () -> new
            ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GLOWWOOD_LOG = registerBlock("stripped_glowwood_log", () -> new
            ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_GLOWWOOD = registerBlock("stripped_glowwood", () -> new
            ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> GLOWWOOD_PLANKS = registerBlock("glowwood_planks", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> GLOWWOOD_LEAVES = registerBlock("glowwood_leaves", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> GLOWWOOD_SAPLING = registerBlock("glowwood_sapling", () -> new
            SaplingBlock(TreeGrowerInit.GLOWWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static DeferredBlock<Block> registerBlock(
            String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }
}
