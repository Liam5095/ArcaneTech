package net.wickedbog.arcanetechmod.core.init;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArcaneTechMod.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_ARCANE = ITEMS.register("raw_arcane", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ARCANE_CRYSTAL = ITEMS.register("arcane_crystal", () -> new Item(new Item.Properties()));
}
