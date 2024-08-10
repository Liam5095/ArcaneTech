package net.wickedbog.arcanetechmod.core.init.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.cables.block.entity.CableBlockEntity;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.cables.block.entity.FacadeBlockEntity;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.entity.FanBlockEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ArcaneTechMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FAN_BLOCK_ENTITY = register("fan", BlockInit.FAN, FanBlockEntity::new);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CABLE_BLOCK_ENTITY = register("cable", BlockInit.CABLE, CableBlockEntity::new);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FACADE_BLOCK_ENTITY = register("facade", BlockInit.FACADE_BLOCK, FacadeBlockEntity::new);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GENERATOR_BLOCK_ENTITY = register("generator", BlockInit.GENERATOR_BLOCK, FacadeBlockEntity::new);

    private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return BLOCK_ENTITIES.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FAN_BLOCK_ENTITY.get(), (blockEntity, side) -> ((FanBlockEntity) blockEntity).getItemHandler());
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, FAN_BLOCK_ENTITY.get(), (blockEntity, side) -> ((FanBlockEntity) blockEntity).getEnergyStorage());
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, CABLE_BLOCK_ENTITY.get(), (blockEntity, side) -> ((CableBlockEntity) blockEntity).getEnergyHandler());
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, FACADE_BLOCK_ENTITY.get(), (blockEntity, side) -> ((CableBlockEntity) blockEntity).getEnergyHandler());
    }
}
