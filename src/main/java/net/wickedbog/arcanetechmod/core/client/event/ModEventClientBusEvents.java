package net.wickedbog.arcanetechmod.core.client.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.particle.ParticleInit;
import net.wickedbog.arcanetechmod.core.particle.custom.FairySwarmParticles;

@Mod.EventBusSubscriber(modid = ArcaneTechMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleInit.FAIRY_SWARM_PARTICLES.get(), FairySwarmParticles.Provider::new);
    }
}
