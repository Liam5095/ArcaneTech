
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wickedbog.arcanetechmod.core.init.entity;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;
import net.wickedbog.arcanetechmod.core.client.model.ModelFairySwarm;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ModModelsInit {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelFairySwarm.LAYER_LOCATION, ModelFairySwarm::createBodyLayer);
	}
}
