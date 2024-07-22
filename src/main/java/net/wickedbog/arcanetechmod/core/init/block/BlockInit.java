package net.wickedbog.arcanetechmod.core.init.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.custom.ArcaneGatewayBlock;
import net.wickedbog.arcanetechmod.core.init.block.custom.RunicOreBlock;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ArcaneTechMod.MOD_ID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE)));

    public static final DeferredBlock<Block> RUNIC_ORE = registerBlock("runic_ore", () -> new
            RunicOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_RUNIC_ORE = registerBlock("deepslate_runic_ore", () -> new
            RunicOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final DeferredBlock<Block> ARCANE_ORE = registerBlock("arcane_ore", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_ARCANE_ORE = registerBlock("deepslate_arcane_ore", () -> new
            Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final DeferredBlock<Block> ARCANE_GATEWAY = registerBlock("arcane_gateway", () -> new
            ArcaneGatewayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_PORTAL).noOcclusion()));

    //public static final DeferredBlock<Block> ARCANE_LOG = registerBlock("arcane_log", () -> log(MapColor.WOOD, MapColor.PODZOL));

    public static DeferredBlock<Block> registerBlock(
            String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }

    public static Block log(MapColor pTopMapColor, MapColor pSideMapColor) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopMapColor : pSideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        );
    }
}
