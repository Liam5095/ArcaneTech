
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wickedbog.arcanetechmod.core.init.entity;

import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.entity.custom.FairySwarmEntity;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit {
	public static final DeferredRegister<EntityType<?>> ENTITYS = DeferredRegister.create(Registries.ENTITY_TYPE, ArcaneTechMod.MOD_ID);
	public static final DeferredHolder<EntityType<?>, EntityType<FairySwarmEntity>> FAIRY_SWARM = register("fairy_swarm",
			EntityType.Builder.<FairySwarmEntity>of(FairySwarmEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 0.3f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return ENTITYS.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			FairySwarmEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(FAIRY_SWARM.get(), FairySwarmEntity.createAttributes().build());
	}
}
