package net.wickedbog.arcanetechmod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Mod("arcanetechmod")
public class ArcaneTechMod {
    public static final String MOD_ID = "arcanetechmod";
    public static Logger logger = LoggerFactory.getLogger(ArcaneTechMod.class);


    public ArcaneTechMod(IEventBus bus) {
        // Registers

        // Listeners

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Loaded {}, using version {}", modContainer.getModInfo().getDisplayName(), modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}
