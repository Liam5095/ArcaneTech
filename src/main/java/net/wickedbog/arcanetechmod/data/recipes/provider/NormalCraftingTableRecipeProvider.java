package net.wickedbog.arcanetechmod.data.recipes.provider;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
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
                .save(output, "runic_ingot_to_runic_plate_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.MYTHIC_STONE.get())
                .pattern(" C ")
                .pattern("CMC")
                .pattern(" C ")
                .define('C', Blocks.COBBLESTONE)
                .define('M', ItemInit.MYTHIC_POWDER.get())
                .unlockedBy("has_mythic_powder", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ItemInit.MYTHIC_POWDER.get()).build()))
                .save(output, "mythic_stone_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.ARCANE_GATEWAY.get())
                .pattern("RMR")
                .pattern("MAM")
                .pattern("RMR")
                .define('R', ItemInit.RUNIC_PLATE.get())
                .define('A', Items.AMETHYST_SHARD)
                .define('M', BlockInit.MYTHIC_STONE.get())
                .unlockedBy("has_mythic_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(BlockInit.MYTHIC_STONE.get()).build()))
                .save(output, "arcane_gateway_recipe");
    }
}
