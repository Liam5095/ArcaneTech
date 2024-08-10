package net.wickedbog.arcanetechmod.core.init.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.TreeGrowerInit;
import net.wickedbog.arcanetechmod.core.init.block.custom.*;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.FanBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.GeneratorBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.SolarPanelBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.cables.block.CableBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.cables.block.FacadeBlock;
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

    // CRYSTALS

    public static final DeferredBlock<Block> RED_CRYSTAL = registerBlock("red_crystal", () -> new
            CrystalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> GREEN_CRYSTAL = registerBlock("green_crystal", () -> new
            CrystalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> BLUE_CRYSTAL = registerBlock("blue_crystal", () -> new
            CrystalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

    // GLOWWOOD

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
            LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)) {
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

                @Override
                public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> GLOWWOOD_SAPLING = registerBlock("glowwood_sapling", () -> new
            SaplingBlock(TreeGrowerInit.GLOWWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)) {
                @Override
                public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
                    return 8;
                }
            });

    // FLOWERS

    public static final DeferredBlock<Block> MYSTIC_FLOWER = registerBlock("mystic_flower", () ->
            new MysticFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILAC)));

    // ENERGY RELATED

    public static final DeferredBlock<Block> SOLAR_PANEL = registerBlock("solar_panel", () ->
            new SolarPanelBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1f, 10f)));
    public static final DeferredBlock<Block> FAN = registerBlock("fan_block", FanBlock::new);

    public static final DeferredBlock<Block> CABLE = registerBlock("cable", CableBlock::new);

    public static final DeferredBlock<Block> FACADE_BLOCK = registerBlock("facade", FacadeBlock::new);

    public static final DeferredBlock<Block> GENERATOR_BLOCK = registerBlock("generator_block", () ->
            new GeneratorBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1f, 10f)));

    public static DeferredBlock<Block> registerBlock(
            String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }
}
