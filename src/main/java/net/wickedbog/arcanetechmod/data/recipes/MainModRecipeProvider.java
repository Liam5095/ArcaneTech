package net.wickedbog.arcanetechmod.data.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.data.recipes.provider.FurnaceRecipeProvider;
import net.wickedbog.arcanetechmod.data.recipes.provider.NormalCraftingTableRecipeProvider;

public class MainModRecipeProvider extends RecipeProvider {
    protected final DataGenerator generator;

    public MainModRecipeProvider(DataGenerator generator) {
        super(generator.getPackOutput());
        this.generator = generator;
    }

    @Override
    protected void buildRecipes(RecipeOutput RecipeOutput) {
        new NormalCraftingTableRecipeProvider(generator, RecipeOutput).build();
        new FurnaceRecipeProvider(generator, RecipeOutput).build();
    }

    public ResourceLocation getModId(String path) {
        return new ResourceLocation(ArcaneTechMod.MOD_ID, path);
    }
}
