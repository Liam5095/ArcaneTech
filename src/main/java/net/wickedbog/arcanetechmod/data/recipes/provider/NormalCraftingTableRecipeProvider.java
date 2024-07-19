package net.wickedbog.arcanetechmod.data.recipes.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeOutput;
import net.wickedbog.arcanetechmod.data.recipes.MainModRecipeProvider;

public class NormalCraftingTableRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput output;

    public NormalCraftingTableRecipeProvider(DataGenerator generator, RecipeOutput output) {
        super(generator);
        this.output = output;
    }

    public void build() {
        //ShapedRecipeBuilder has to be crafted in a certain order like a sword
        //ShapelessRecipeBuilder like making an iron block. no order


    }
}
