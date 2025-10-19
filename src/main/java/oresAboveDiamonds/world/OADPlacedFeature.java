package oresAboveDiamonds.world;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.OresAboveDiamonds;

import java.util.List;

public class OADPlacedFeature {

    public static final RegistryEntry<PlacedFeature> AMETHYST_ORE_PLACED = PlacedFeatures.register(
            OresAboveDiamonds.id("amethyst_ore_placed"),
            ModConfiguredFeatures.AMETHYST_ORE,
            List.of(
                    CountPlacementModifier.of(6), // veins per chunk
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
            )
    );

    public static final RegistryEntry<PlacedFeature> BLACK_OPAL_ORE_PLACED = PlacedFeatures.register(
            OresAboveDiamonds.id("black_opal_ore_placed"),
            ModConfiguredFeatures.BLACK_OPAL_ORE,
            List.of(
                    CountPlacementModifier.of(4),
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))
            )
    );

    public static void register() {
        // Just accessing the fields ensures they are loaded
        AMETHYST_ORE_PLACED.toString();
        BLACK_OPAL_ORE_PLACED.toString();
    }
}
