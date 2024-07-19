package net.wickedbog.arcanetechmod.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.wickedbog.arcanetechmod.ArcaneTechMod;

public class TagsInit {

    public static class BlockTagsInit {
        public static TagKey<Block> ARCANE_ORE = BlockTags.create(createResourceLocation("ores/arcane_ore"));

        private static ResourceLocation createResourceLocation(String name) {
            return new ResourceLocation("forge", name);
        }

        private static ResourceLocation createCustomResourceLocation(String name) {
            return new ResourceLocation(ArcaneTechMod.MOD_ID, name);
        }
    }

    public static class ItemTagsInit {
        public static TagKey<Item> ARCANE_ORE = ItemTags.create(createResourceLocation("ores/arcane_ore"));

        private static ResourceLocation createResourceLocation(String name) {
            return new ResourceLocation("forge", name);
        }
    }
}
