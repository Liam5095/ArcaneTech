package net.wickedbog.arcanetechmod.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.wickedbog.arcanetechmod.ArcaneTechMod;

public class TagsInit {

    public static class BlockTagsInit {
        public static TagKey<Block> ARCANE_ORE = BlockTags.create(createResourceLocation("ores/arcane_ore"));
        public static TagKey<Block> RUNIC_ORE = BlockTags.create(createResourceLocation("ores/runic_ore"));
        public static TagKey<Block> MYTHIC_ESSENCE_ORE = BlockTags.create(createResourceLocation("ores/mythic_essence_ore"));
        public static TagKey<Block> CUSTOM_ORES = BlockTags.create(createResourceLocation("custom_ores"));
        public static TagKey<Block> ALL_ORES = BlockTags.create(createResourceLocation("all_ores"));

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

    public static class BiomeTagsInit {
        public static TagKey<Biome> IS_MYTHICAL_REALM = createBiomeTag("is_mythical_realm");

        private static TagKey<Biome> createBiomeTag(String pName) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(pName));
        }
    }
}
