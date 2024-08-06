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
        addItem(ItemInit.RAW_RUNIC, "Rauwe Runiek");
        addItem(ItemInit.RUNIC_INGOT, "Runiek Baar");
        addItem(ItemInit.RUNIC_PLATE, "Runiek Plaat");
        addItem(ItemInit.MYTHIC_POWDER, "Mytische Poeder");

        // Blocks

        addBlock(BlockInit.EXAMPLE_BLOCK, "Voorbeeld Blok");
        addBlock(BlockInit.ARCANE_ORE, "Arcanerts");
        addBlock(BlockInit.DEEPSLATE_ARCANE_ORE, "Wrevelsteenarcanerts");
        addBlock(BlockInit.ARCANE_GATEWAY, "Arcane Poort");
        addBlock(BlockInit.RUNIC_ORE, "Runiekerts");
        addBlock(BlockInit.DEEPSLATE_RUNIC_ORE, "Wrevelsteenruniekerts");
        addBlock(BlockInit.MYTHIC_ESSENCE_ORE, "Mythischeessenceërts");
        addBlock(BlockInit.DEEPSLATE_MYTHIC_ESSENCE_ORE, "Wrevelsteenmythischeëssenceërts");
        addBlock(BlockInit.MYTHIC_STONE, "Mytische Steen");
        addBlock(BlockInit.GLOWWOOD_LOG, "Gloeihoutstam");
        addBlock(BlockInit.GLOWWOOD, "Gloeihout");
        addBlock(BlockInit.STRIPPED_GLOWWOOD_LOG, "Gestripte Gloeihoutstam");
        addBlock(BlockInit.STRIPPED_GLOWWOOD, "Gestripte Gloeihout");
        addBlock(BlockInit.GLOWWOOD_PLANKS, "Gloeihout Planken");
        addBlock(BlockInit.GLOWWOOD_LEAVES, "Gloeihoutbladeren");
        addBlock(BlockInit.GLOWWOOD_SAPLING, "Gloeihoutzaailing");
        addBlock(BlockInit.MYSTIC_FLOWER, "Mytische Bloem");
        addBlock(BlockInit.RED_CRYSTAL, "Rode Krystal");
        addBlock(BlockInit.GREEN_CRYSTAL, "Groene Krystal");
        addBlock(BlockInit.BLUE_CRYSTAL, "Blauwe Krystal");

        // Others
        add("creativetab.arcanemod", "ArcaneTech Tabblad");
        add("advancements.arcanetech.title", "Arcane Tech");
        add("advancements.cookedarcane.title", "Prof Chef!");

        // Advancement Descriptions
        add("advancements.arcanetech.description", "Je hebt rauwe arcane, goed gedaan!");
        add("advancements.cookedarcane.description", "Wat kan ik hiermee doen?");
    }

    private void add(Component component, String translation) {
        add(component.getString(), translation);
    }
}
