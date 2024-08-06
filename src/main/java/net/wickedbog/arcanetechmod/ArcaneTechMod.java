package net.wickedbog.arcanetechmod;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.handling.IPlayPayloadHandler;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.core.init.CreativeModeTabInit;
import net.wickedbog.arcanetechmod.core.init.entity.EntityInit;
import net.wickedbog.arcanetechmod.core.init.item.ItemInit;
import net.wickedbog.arcanetechmod.core.particle.ParticleInit;
import net.wickedbog.arcanetechmod.data.DataGenerators;
import net.wickedbog.arcanetechmod.worldgen.biome.ModTerraBlenderAPI;
import net.wickedbog.arcanetechmod.worldgen.biome.surface.ModSurfaceRules;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod("arcanetechmod")
public class ArcaneTechMod {
    public static final String MOD_ID = "arcanetechmod";
    public static Logger logger = LoggerFactory.getLogger(ArcaneTechMod.class);


    public ArcaneTechMod(IEventBus bus) {
        // Registers
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        EntityInit.ENTITYS.register(bus);

        ParticleInit.PARTICLE_TYPES.register(bus);
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

    private static boolean networkingRegistered = false;
    private static final Map<ResourceLocation, NetworkMessage<?>> MESSAGES = new HashMap<>();

    private record NetworkMessage<T extends CustomPacketPayload>(FriendlyByteBuf.Reader<T> reader, IPlayPayloadHandler<T> handler) {
    }

    public static <T extends CustomPacketPayload> void addNetworkMessage(ResourceLocation id, FriendlyByteBuf.Reader<T> reader, IPlayPayloadHandler<T> handler) {
        if (networkingRegistered)
            throw new IllegalStateException("Cannot register new network messages after networking has been registered");
        MESSAGES.put(id, new NetworkMessage<>(reader, handler));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void registerNetworking(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(MOD_ID);
        MESSAGES.forEach((id, networkMessage) -> registrar.play(id, ((NetworkMessage) networkMessage).reader(), networkMessage.handler()));
        networkingRegistered = true;
    }

    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workQueue.add(new Tuple<>(action, tick));
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setB(work.getB() - 1);
                if (work.getB() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getA().run());
            workQueue.removeAll(actions);
        }
    }


}
