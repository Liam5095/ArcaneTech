package net.wickedbog.arcanetechmod.data.texture;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;
import net.wickedbog.arcanetechmod.util.NameUtility;

public class ModItemStateProvider extends ItemModelProvider {
    public ModItemStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ArcaneTechMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ItemInit.EXAMPLE_ITEM.get());
        item(ItemInit.ARCANE_CRYSTAL.get());
        item(ItemInit.RAW_ARCANE.get());
        item(ItemInit.RAW_RUNIC.get());
        item(ItemInit.RUNIC_INGOT.get());
        item(ItemInit.RUNIC_PLATE.get());
        item(ItemInit.MYTHIC_POWDER.get());

        saplingItem(BlockInit.GLOWWOOD_SAPLING.get());
        withExistingParent(ItemInit.FAIRY_SWARM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void item(Item item) {
        String name = NameUtility.getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + name);
    }

    private void tool(Item item) {
        String name = NameUtility.getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/" + name);
    }

    private void saplingItem(Block Block) {
        String name = NameUtility.getBlockName(Block);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "block/" + name);
    }
}
