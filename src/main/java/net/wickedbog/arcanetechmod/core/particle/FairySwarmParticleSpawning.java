package net.wickedbog.arcanetechmod.core.particle;

import net.minecraft.world.level.LevelAccessor;

public class FairySwarmParticleSpawning {
    public static void spawn(LevelAccessor world, double x, double y, double z) {
        world.addParticle(ParticleInit.FAIRY_SWARM_PARTICLES.get(), x, y, z, 0, -0.02, 0);
    }
}