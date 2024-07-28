package net.wickedbog.arcanetechmod.data.lang;

import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;

public class ModEnLangProvider extends LanguageProvider {
    public ModEnLangProvider(PackOutput output) {
        super(output, ArcaneTechMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(ItemInit.EXAMPLE_ITEM, "Example Item");
        addItem(ItemInit.ARCANE_CRYSTAL, "Arcane Crystal");
        addItem(ItemInit.RAW_ARCANE, "Raw Arcane");
        addItem(ItemInit.RAW_RUNIC, "Raw Runic");
        addItem(ItemInit.RUNIC_INGOT, "Runic Ingot");
        addItem(ItemInit.RUNIC_PLATE, "Runic Plate");
        addItem(ItemInit.MYTHIC_POWDER, "Mythic Powder");

        // Blocks

        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");
        addBlock(BlockInit.ARCANE_ORE, "Arcane Ore");
        addBlock(BlockInit.DEEPSLATE_ARCANE_ORE, "Deepslate Arcane Ore");
        addBlock(BlockInit.ARCANE_GATEWAY, "Arcane Gateway");
        addBlock(BlockInit.RUNIC_ORE, "Runic Ore");
        addBlock(BlockInit.DEEPSLATE_RUNIC_ORE, "Deepslate Runic Ore");
        addBlock(BlockInit.MYTHIC_ESSENCE_ORE, "Mythic Essence Ore");
        addBlock(BlockInit.DEEPSLATE_MYTHIC_ESSENCE_ORE, "Deepslate Mythic Essence Ore");
        addBlock(BlockInit.MYTHIC_STONE, "Mythic Stone");
        addBlock(BlockInit.GLOWWOOD_LOG, "Glowwood Log");
        addBlock(BlockInit.GLOWWOOD, "Glowwood");
        addBlock(BlockInit.STRIPPED_GLOWWOOD_LOG, "Stripped Glowwood Log");
        addBlock(BlockInit.STRIPPED_GLOWWOOD, "Stripped Glowwood");
        addBlock(BlockInit.GLOWWOOD_PLANKS, "Glowwood Planks");
        addBlock(BlockInit.GLOWWOOD_LEAVES, "Glowwood Leaves");
        addBlock(BlockInit.GLOWWOOD_SAPLING, "Glowwood Sapling");
        addBlock(BlockInit.MYSTIC_FLOWER, "Mystic Flower");

        // Others
        add("creativetab.arcanemod", "ArcaneTech Tab");
        add("advancements.arcanetech.title", "Arcane Tech");
        add("advancements.cookedarcane.title", "Cooking Master");

        // Advancement Descriptions
        add("advancements.arcanetech.description", "You got raw arcane, good job!");
        add("advancements.cookedarcane.description", "Now what can i do with this?");
    }

    private void add(Component component, String translation) {
        add(component.getString(), translation);
    }
}
