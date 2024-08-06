package net.wickedbog.arcanetechmod.core.init.gui;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.gui.menu.ArcaneCapacitorMenu;

public class MenuTypeInit {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, ArcaneTechMod.MOD_ID);
    public static final DeferredHolder<MenuType<?>, MenuType<ArcaneCapacitorMenu>> ARCANE_CAPACITOR_GUI = MENUS.register("arcane_capacitor_gui",
            () -> IMenuTypeExtension.create(ArcaneCapacitorMenu::new));
}
