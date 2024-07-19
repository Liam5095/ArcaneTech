package net.wickedbog.arcanetechmod.data.lootable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.BlockInit;
import net.wickedbog.arcanetechmod.core.init.ItemInit;
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
        add(BlockInit.ARCANE_ORE.get(), createOreDrop(BlockInit.ARCANE_ORE.get(), ItemInit.RAW_ARCANE.get()));

        dropSelf(BlockInit.EXAMPLE_BLOCK.get());
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
