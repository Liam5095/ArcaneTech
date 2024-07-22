package net.wickedbog.arcanetechmod.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.worldgen.biome.custom.ModOverworldRegion;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(ArcaneTechMod.MOD_ID, "overworld"), 3));
    }
}
