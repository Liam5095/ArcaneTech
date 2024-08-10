
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wickedbog.arcanetechmod.core.init.entity;

import net.wickedbog.arcanetechmod.core.client.entity.renderer.FairySwarmRenderer;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderersInit {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.FAIRY_SWARM.get(), FairySwarmRenderer::new);
	}
}
