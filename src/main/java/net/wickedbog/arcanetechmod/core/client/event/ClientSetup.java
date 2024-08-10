package net.wickedbog.arcanetechmod.core.client.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.wickedbog.arcanetechmod.core.client.energy.cables.CableModelLoader;
import net.wickedbog.arcanetechmod.core.client.energy.cables.FacadeBlockColor;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;

import static net.wickedbog.arcanetechmod.ArcaneTechMod.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void modelInit(ModelEvent.RegisterGeometryLoaders event) {
        CableModelLoader.register(event);
    }

    @SubscribeEvent
    public static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
        event.register(new FacadeBlockColor(), BlockInit.FACADE_BLOCK.get());
    }
}
