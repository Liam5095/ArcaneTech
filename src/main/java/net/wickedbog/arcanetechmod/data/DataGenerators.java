package net.wickedbog.arcanetechmod.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.data.lang.ModEnLangProvider;
import net.wickedbog.arcanetechmod.data.lootable.ModLootTables;
import net.wickedbog.arcanetechmod.data.recipes.MainModRecipeProvider;
import net.wickedbog.arcanetechmod.data.tags.ModBlockTagProvider;
import net.wickedbog.arcanetechmod.data.tags.ModItemTagProvider;
import net.wickedbog.arcanetechmod.data.texture.ModBlockStateProvider;
import net.wickedbog.arcanetechmod.data.texture.ModItemStateProvider;
import net.wickedbog.arcanetechmod.data.world.ModWorldGenProvider;

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
            generator.addProvider(true, new MainModRecipeProvider(generator));
            ModBlockTagProvider blockTagProvider = new ModBlockTagProvider(output, event.getLookupProvider(), existingFileHelper);
            generator.addProvider(true, blockTagProvider);
            generator.addProvider(true, new ModItemTagProvider(output, event.getLookupProvider(), blockTagProvider, existingFileHelper));
            generator.addProvider(true, new ModWorldGenProvider(output, event.getLookupProvider()));
        } catch (RuntimeException runtimeException) {
            ArcaneTechMod.logger.error("Failed to generate data",runtimeException);
        }
    }
}
