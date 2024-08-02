package net.wickedbog.arcanetechmod.data.lootable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Arcane
        add(BlockInit.ARCANE_ORE.get(), createOreDrop(BlockInit.ARCANE_ORE.get(), ItemInit.RAW_ARCANE.get()));
        add(BlockInit.DEEPSLATE_ARCANE_ORE.get(), createOreDrop(BlockInit.DEEPSLATE_ARCANE_ORE.get(), ItemInit.RAW_ARCANE.get()));

        // Runic
        add(BlockInit.RUNIC_ORE.get(), createOreDrop(BlockInit.RUNIC_ORE.get(), ItemInit.RAW_RUNIC.get()));
        add(BlockInit.DEEPSLATE_RUNIC_ORE.get(), createOreDrop(BlockInit.DEEPSLATE_RUNIC_ORE.get(), ItemInit.RAW_RUNIC.get()));

        // Mythic Essence
        add(BlockInit.MYTHIC_ESSENCE_ORE.get(), createMythicEssenceDrops(BlockInit.MYTHIC_ESSENCE_ORE.get()));
        add(BlockInit.DEEPSLATE_MYTHIC_ESSENCE_ORE.get(), createMythicEssenceDrops(BlockInit.MYTHIC_ESSENCE_ORE.get()));

        // DropSelf

        dropSelf(BlockInit.EXAMPLE_BLOCK.get());
        dropSelf(BlockInit.ARCANE_GATEWAY.get());

        // DropSelf Crystals
        dropSelf(BlockInit.RED_CRYSTAL.get());
        dropSelf(BlockInit.GREEN_CRYSTAL.get());
        dropSelf(BlockInit.BLUE_CRYSTAL.get());

        // DropSelf Mythic Essence
        dropSelf(BlockInit.MYTHIC_STONE.get());

        // Wood stuff

        dropSelf(BlockInit.GLOWWOOD_LOG.get());
        dropSelf(BlockInit.GLOWWOOD.get());
        dropSelf(BlockInit.STRIPPED_GLOWWOOD_LOG.get());
        dropSelf(BlockInit.STRIPPED_GLOWWOOD.get());
        dropSelf(BlockInit.GLOWWOOD_PLANKS.get());
        dropSelf(BlockInit.GLOWWOOD_SAPLING.get());

        add(BlockInit.GLOWWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, BlockInit.GLOWWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        // Special Blocks

        add(BlockInit.MYSTIC_FLOWER.get(), block ->
                createSinglePropConditionTable(BlockInit.MYSTIC_FLOWER.get(), DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
    }

    protected LootTable.Builder createMythicEssenceDrops(Block pBlock) {
        return createSilkTouchDispatchTable(
                pBlock,
                this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(ItemInit.MYTHIC_POWDER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }

    @Override
    public @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(ArcaneTechMod.MOD_ID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
