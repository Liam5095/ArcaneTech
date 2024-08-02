package net.wickedbog.arcanetechmod.core.init.entity.ai;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.wickedbog.arcanetechmod.core.init.entity.custom.FairySwarmEntity;
import net.wickedbog.arcanetechmod.core.particle.FairySwarmParticleSpawning;

public class FairySwarmGoal extends Goal {
    public final FairySwarmEntity fairySwarm;

    public FairySwarmGoal(FairySwarmEntity fairySwarm) {
        this.fairySwarm = fairySwarm;
    }

    @Override
    public boolean canUse() {
        Level level = this.fairySwarm.level();
        double x = this.fairySwarm.getX() + 0.5;
        double y = this.fairySwarm.getY() + 1;
        double z = this.fairySwarm.getZ() + 0.5;
        FairySwarmParticleSpawning.spawn(this.fairySwarm.level(), x, y, z);
        if (!level.isClientSide) {
            Player nearestPlayer = level.getNearestPlayer(this.fairySwarm, 4);
            if (nearestPlayer != null) {
                this.fairySwarm.getNavigation().moveTo(nearestPlayer, 0.8);
                //level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.1, 0.0);
            }
        }
        return true;
    }
}
