package net.wickedbog.arcanetechmod.data.recipes.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.wickedbog.arcanetechmod.core.init.ItemInit;
import net.wickedbog.arcanetechmod.data.recipes.MainModRecipeProvider;

public class FurnaceRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput output;

    public FurnaceRecipeProvider(DataGenerator generator, RecipeOutput output) {
        super(generator);
        this.output = output;
    }

    public void build() {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.RAW_ARCANE.get()), RecipeCategory.MISC, ItemInit.ARCANE_CRYSTAL.get(), 0.6f, 300)
                .unlockedBy("has_item", has(ItemInit.RAW_ARCANE.get()))
                .save(output, getModId("raw_arcane_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ItemInit.RAW_ARCANE.get()), RecipeCategory.MISC, ItemInit.ARCANE_CRYSTAL.get(), 0.3f, 200)
                .unlockedBy("has_item", has(ItemInit.RAW_ARCANE.get()))
                .save(output, getModId("raw_arcane_blasting"));
    }
}
