package net.wickedbog.arcanetechmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.brewing.BrewingRecipeRegistry;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.core.init.CreativeModeTabInit;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;
import net.wickedbog.arcanetechmod.data.DataGenerators;
import net.wickedbog.arcanetechmod.worldgen.biome.ModTerraBlenderAPI;
import net.wickedbog.arcanetechmod.worldgen.biome.surface.ModSurfaceRules;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

@Mod("arcanetechmod")
public class ArcaneTechMod {
    public static final String MOD_ID = "arcanetechmod";
    public static Logger logger = LoggerFactory.getLogger(ArcaneTechMod.class);


    public ArcaneTechMod(IEventBus bus) {
        // Registers
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);

        ModTerraBlenderAPI.registerRegions();

        // Listeners
        bus.addListener(DataGenerators::gatherData);
        bus.addListener(this::commonSetup);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Loaded {}, using version {}", modContainer.getModInfo().getDisplayName(), modContainer.getModInfo().getVersion());
                });
            });
        }));
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
        });
    }
}
