package net.wickedbog.arcanetechmod.core.rendering.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.wickedbog.arcanetechmod.core.init.entity.EntityInit;
import net.wickedbog.arcanetechmod.core.init.entity.renderer.FairySwarmRenderer;

public class ModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.FAIRY_SWARM.get(), FairySwarmRenderer::new);
    }
}
