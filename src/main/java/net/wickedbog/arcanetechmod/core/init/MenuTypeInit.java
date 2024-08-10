package net.wickedbog.arcanetechmod.core.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wickedbog.arcanetechmod.ArcaneTechMod;
import net.wickedbog.arcanetechmod.core.init.block.custom.energy.screen.GeneratorContainer;

import java.util.function.Supplier;

public class MenuTypeInit {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, ArcaneTechMod.MOD_ID);

    public static final Supplier<MenuType<GeneratorContainer>> GENERATOR_CONTAINER = MENU_TYPES.register("generator_block", () ->
            IMenuTypeExtension.create(((windowId, inv, data) -> new GeneratorContainer(windowId, inv.player, data.readBlockPos()))));


}
