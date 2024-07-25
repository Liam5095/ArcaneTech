package net.wickedbog.arcanetechmod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.wickedbog.arcanetechmod.ArcaneTechMod;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ARCANE_ORE = createKey("arcane_ore");
    public static final ResourceKey<PlacedFeature> RUNIC_ORE = createKey("runic_ore");
    public static final ResourceKey<PlacedFeature> MYTHIC_ESSENCE_ORE = createKey("mythic_essence_ore");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?,? >> holder =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.MYTHICAL_REALM_ARCANE_ORE_KEY);
        Holder<ConfiguredFeature<?,? >> holder1 =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUNIC_ORE_KEY);
        Holder<ConfiguredFeature<?,? >> holder2 =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MYTHIC_ESSENCE_ORE_KEY);


        // 3 veins per chunk, between y -64 and 50
        register(context, ARCANE_ORE, holder, ModOrePlacement.commonOrePlacements(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(20))));
        register(context, RUNIC_ORE, holder1, ModOrePlacement.commonOrePlacements(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-15), VerticalAnchor.absolute(42))));
        register(context, MYTHIC_ESSENCE_ORE, holder2, ModOrePlacement.commonOrePlacements(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-25), VerticalAnchor.absolute(30))));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ArcaneTechMod.MOD_ID, name));
    }


    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> feature, List<PlacementModifier> placements) {
        context.register(key, new PlacedFeature(feature, placements));
    }
}
