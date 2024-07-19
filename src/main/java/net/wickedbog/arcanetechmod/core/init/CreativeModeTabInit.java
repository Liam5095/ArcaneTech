package net.wickedbog.arcanetechmod.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;

public class CreativeModeTabInit {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArcaneTechMod.MOD_ID);

    // Tab title
    public static String ARCANE_MOD_TAB_TITLE = "creativetab.arcanemod";

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ARCANE_MOD_TAB = CREATIVE_MODE_TABS.register("arcane_mod_tab", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();


        builder.displayItems((itemDisplayParameters, output) -> {
            ItemInit.ITEMS.getEntries()
                    .stream()
                    .map(DeferredHolder::get)
                    .forEach(output::accept);

            BlockInit.BLOCKS.getEntries()
                    .stream()
                    .map(DeferredHolder::get)
                    .forEach(output::accept);
        });

        builder.icon(() -> new ItemStack(ItemInit.ARCANE_CRYSTAL.get()));
        builder.title(Component.translatable(ARCANE_MOD_TAB_TITLE));

        return builder.build();
    });
}
