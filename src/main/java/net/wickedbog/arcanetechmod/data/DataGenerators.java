package net.wickedbog.arcanetechmod.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.data.lang.ModEnLangProvider;
import net.wickedbog.arcanetechmod.data.lootable.ModLootTables;
import net.wickedbog.arcanetechmod.data.texture.ModBlockStateProvider;
import net.wickedbog.arcanetechmod.data.texture.ModItemStateProvider;

public class DataGenerators {

    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = event.getGenerator().getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            generator.addProvider(true, new ModEnLangProvider(output));
            generator.addProvider(true, new ModItemStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModLootTables(output));
        } catch (RuntimeException runtimeException) {
            ArcaneTechMod.logger.error("Failed to generate data",runtimeException);
        }
    }
}
