package oresAboveDiamonds.world;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import oresAboveDiamonds.OresAboveDiamonds;

import java.util.List;

public class OADPlacedFeature {

    public static final RegistryEntry<PlacedFeature> AMETHYST_ORE_PLACED =
            Registry.register(Registry.PLACED_FEATURE,
                    new Identifier(OresAboveDiamonds.MOD_ID, "amethyst_ore_placed"),
                    new PlacedFeature(OADConfiguredFeature.AMETHYST_ORE_FEATURE,
                            List.of(
                                    CountPlacementModifier.of(10),
                                    HeightRangePlacementModifier.uniform(UniformHeightProvider.create(0, 64))
                            )));

    public static final RegistryEntry<PlacedFeature> BLACK_OPAL_ORE_PLACED =
            Registry.register(Registry.PLACED_FEATURE,
                    new Identifier(OresAboveDiamonds.MOD_ID, "black_opal_ore_placed"),
                    new PlacedFeature(OADConfiguredFeature.BLACK_OPAL_ORE_FEATURE,
                            List.of(
                                    CountPlacementModifier.of(6),
                                    HeightRangePlacementModifier.uniform(UniformHeightProvider.create(0, 32))
                            )));

    public static void registerAll() {}
}
