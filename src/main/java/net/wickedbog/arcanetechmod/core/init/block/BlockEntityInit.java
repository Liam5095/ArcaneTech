package net.wickedbog.arcanetechmod.core.init.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.entity.ArcaneCapacitorBlockEntity;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ArcaneTechMod.MOD_ID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ARCANE_CAPACITOR = register("arcane_capacitor", BlockEntityInit.ARCANE_CAPACITOR, ArcaneCapacitorBlockEntity::new);



    private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return BLOCK_ENTITIES.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ARCANE_CAPACITOR.get(), (blockEntity, side) -> ((ArcaneCapacitorBlockEntity) blockEntity).getItemHandler());
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ARCANE_CAPACITOR.get(), (blockEntity, side) -> ((ArcaneCapacitorBlockEntity) blockEntity).getEnergyStorage());
    }

}
