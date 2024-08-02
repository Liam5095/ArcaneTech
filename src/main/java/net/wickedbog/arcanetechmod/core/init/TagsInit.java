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
        public static TagKey<Block> ARCANE_ORE = BlockTags.create(createResourceLocation("underground/ores/arcane_ore"));
        public static TagKey<Block> RUNIC_ORE = BlockTags.create(createResourceLocation("underground/ores/runic_ore"));
        public static TagKey<Block> MYTHIC_ESSENCE_ORE = BlockTags.create(createResourceLocation("underground/ores/mythic_essence_ore"));
        public static TagKey<Block> CUSTOM_ORES = BlockTags.create(createResourceLocation("underground/ores/custom_ores"));
        public static TagKey<Block> ALL_ORES = BlockTags.create(createResourceLocation("underground/ores/all_ores"));
        public static TagKey<Block> ALL_UNDERGROUND_REPLACABLES = BlockTags.create(createResourceLocation("replacables/underground/all_underground_replacables"));
        public static TagKey<Block> ALL_CRYSTALS = BlockTags.create(createResourceLocation("underground/crystals/all_crystals"));

        private static ResourceLocation createResourceLocation(String name) {
            return new ResourceLocation("forge", name);
        }

        private static ResourceLocation createCustomResourceLocation(String name) {
            return new ResourceLocation(ArcaneTechMod.MOD_ID, name);
        }
    }

    public static class ItemTagsInit {
        public static TagKey<Item> ARCANE_ORE = ItemTags.create(createResourceLocation("underground/ores/arcane_ore"));

        private static ResourceLocation createResourceLocation(String name) {
            return new ResourceLocation("forge", name);
        }
    }

    public static class BiomeTagsInit {
        public static TagKey<Biome> IS_MYTHICAL_REALM = createBiomeTag("is_mythical_realm");
        public static TagKey<Biome> IS_ENHANCED_FOREST = createBiomeTag("is_enhanced_forest");
        public static TagKey<Biome> IS_CRYSTAL_CAVES = createBiomeTag("is_crystal_caves");

        private static TagKey<Biome> createBiomeTag(String pName) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(pName));
        }
    }
}
