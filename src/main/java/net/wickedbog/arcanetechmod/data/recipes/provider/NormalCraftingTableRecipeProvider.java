package net.wickedbog.arcanetechmod.data.recipes.provider;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.RUNIC_PLATE.get())
                .pattern("RR")
                .define('R', ItemInit.RUNIC_INGOT.get())
                .unlockedBy("has_runic_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ItemInit.RUNIC_INGOT.get()).build()))
                .save(output, ArcaneTechMod.MOD_ID);

    }
}
