package net.wickedbog.arcanetechmod.data.lang;

import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.BlockInit;
import net.wickedbog.arcanetechmod.core.init.ItemInit;

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

        // Blocks

        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");
        addBlock(BlockInit.ARCANE_ORE, "Arcane Ore");

        // Others
        add("creativetab.arcanemod", "ArcaneTech Tab");
    }

    private void add(Component component, String translation) {
        add(component.getString(), translation);
    }
}
