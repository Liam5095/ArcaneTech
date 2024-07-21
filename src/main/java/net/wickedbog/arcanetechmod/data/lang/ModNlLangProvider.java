package net.wickedbog.arcanetechmod.data.lang;

import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;

public class ModNlLangProvider extends LanguageProvider {
    public ModNlLangProvider(PackOutput output) {
        super(output, ArcaneTechMod.MOD_ID, "nl_nl");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(ItemInit.EXAMPLE_ITEM, "Voorbeeld Item");
        addItem(ItemInit.ARCANE_CRYSTAL, "Arcane Krystal");
        addItem(ItemInit.RAW_ARCANE, "Rauwe Arcane");

        // Blocks

        addBlock(BlockInit.EXAMPLE_BLOCK, "Voorbeeld Blok");
        addBlock(BlockInit.ARCANE_ORE, "Arcanerts");
        addBlock(BlockInit.DEEPSLATE_ARCANE_ORE, "Wrevelsteenarcanerts");
        addBlock(BlockInit.ARCANE_GATEWAY, "Arcane Poort");

        // Others
        add("creativetab.arcanemod", "ArcaneTech Tabblad");
        add("advancements.arcanetech.title", "Arcane Tech");
        add("advancements.cookedarcane.title", "Prof Chef!");

        // Advancement Descriptions
        add("advancements.arcanetech.description", "Je hebt rauw arcane, goed gedaan!");
        add("advancements.cookedarcane.description", "Wat kan ik hiermee doen?");
    }

    private void add(Component component, String translation) {
        add(component.getString(), translation);
    }
}
