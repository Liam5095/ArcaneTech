package net.wickedbog.arcanetechmod.data.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;

import java.util.Optional;
import java.util.function.Consumer;

public class ModAdvancementsProvider implements AdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ItemInit.RAW_ARCANE.get()),
                        Component.translatable("advancements.arcanetech.title"), Component.translatable("advancements.arcanetech.description"),
                        Optional.of(new ResourceLocation(ArcaneTechMod.MOD_ID, "textures/block/arcane_ore.png")), AdvancementType.TASK,
                        true, true, false))
                .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.RAW_ARCANE)) // How the advancement is unlocked
                .save(saver, new ResourceLocation(ArcaneTechMod.MOD_ID, "arcanetech"), existingFileHelper).value(); // Add data to builder

        Advancement cookedArcane = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ItemInit.ARCANE_CRYSTAL.get()),
                        Component.translatable("advancements.cookedarcane.title"), Component.translatable("advancements.cookedarcane.description"),
                        Optional.of(new ResourceLocation(ArcaneTechMod.MOD_ID, "textures/block/arcane_ore.png")), AdvancementType.TASK,
                        true, true, false))
                .parent(new AdvancementHolder(new ResourceLocation(ArcaneTechMod.MOD_ID, "arcanetech"), rootAdvancement))
                .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.ARCANE_CRYSTAL)) // How the advancement is unlocked
                .save(saver, new ResourceLocation(ArcaneTechMod.MOD_ID, "cookedarcane"), existingFileHelper).value(); // Add data to builder
    }
}
