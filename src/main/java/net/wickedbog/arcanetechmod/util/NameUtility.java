package net.wickedbog.arcanetechmod.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.wickedbog.arcanetechmod.ArcaneTechMod;

public class NameUtility {

    public static String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(ArcaneTechMod.MOD_ID + ":", "");
    }

    public static String getBlockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).toString().replace(ArcaneTechMod.MOD_ID + ":", "");
    }
}
