package net.wickedbog.arcanetechmod.core.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.entity.EntityInit;

//@Mod.EventBusSubscriber(modid = ArcaneTechMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    //@SubscribeEvent
    //public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
    //    event.register(EntityInit.FAIRY_SWARM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
    //            AmbientCreature::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    //}
}
