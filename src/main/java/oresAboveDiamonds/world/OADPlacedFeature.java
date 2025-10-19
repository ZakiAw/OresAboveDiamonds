package oresAboveDiamonds.world;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import java.util.ArrayList;
import java.util.List;

public class OADPlacedFeatureFabric {

    public static void register() {
        // Overworld Amethyst
        registerPlaced(OADConfiguredFeatureFabric.AMETHYST_SMALL, "ore_amethyst",
                OADConfig.spawn_amethyst_overworld.get(), 7.0 / OADConfig.amethyst_times_rarer.get(),
                buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get(), true));

        registerPlaced(OADConfiguredFeatureFabric.AMETHYST_BURIED, "ore_amethyst_buried",
                OADConfig.spawn_amethyst_overworld.get(), 4.0 / OADConfig.amethyst_times_rarer.get(),
                buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get(), true));

        registerPlaced(OADConfiguredFeatureFabric.AMETHYST_LARGE, "ore_amethyst_large",
                OADConfig.spawn_amethyst_overworld.get(), 1.0 / (OADConfig.amethyst_times_rarer.get() * 9),
                buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get(), true));

        // Overworld Black Opal
        registerPlaced(OADConfiguredFeatureFabric.BLACK_OPAL_SMALL, "ore_black_opal",
                OADConfig.spawn_black_opal_overworld.get(), 7.0 / OADConfig.black_opal_times_rarer.get(),
                buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get(), true));

        registerPlaced(OADConfiguredFeatureFabric.BLACK_OPAL_BURIED, "ore_black_opal_buried",
                OADConfig.spawn_black_opal_overworld.get(), 4.0 / OADConfig.black_opal_times_rarer.get(),
                buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get(), true));

        registerPlaced(OADConfiguredFeatureFabric.BLACK_OPAL_LARGE, "ore_black_opal_large",
                OADConfig.spawn_black_opal_overworld.get(), 1.0 / (OADConfig.black_opal_times_rarer.get() * 9),
                buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get(), true));

        // Nether Amethyst
        registerPlaced(OADConfiguredFeatureFabric.NETHER_AMETHYST, "ore_nether_amethyst",
                OADConfig.spawn_amethyst_nether.get(),
                9.0 * OADConfig.nether_chance_multiplier.get() / OADConfig.amethyst_times_rarer.get(),
                buildPlacement(0, OADConfig.amethyst_max_spawn_height_nether.get(), false));

        // Nether Black Opal
        registerPlaced(OADConfiguredFeatureFabric.NETHER_BLACK_OPAL, "ore_nether_black_opal",
                OADConfig.spawn_black_opal_nether.get(),
                9.0 * OADConfig.nether_chance_multiplier.get() / OADConfig.black_opal_times_rarer.get(),
                buildPlacement(0, OADConfig.black_opal_max_spawn_height_nether.get(), false));

        // End Amethyst
        registerPlaced(OADConfiguredFeatureFabric.END_AMETHYST, "ore_end_amethyst",
                OADConfig.spawn_amethyst_end.get(),
                3.0 * OADConfig.end_chance_multiplier.get() / OADConfig.amethyst_times_rarer.get(),
                buildPlacement(0, OADConfig.amethyst_max_spawn_height_end.get(), false));

        // End Black Opal
        registerPlaced(OADConfiguredFeatureFabric.END_BLACK_OPAL, "ore_end_black_opal",
                OADConfig.spawn_black_opal_end.get(),
                3.0 * OADConfig.end_chance_multiplier.get() / OADConfig.black_opal_times_rarer.get(),
                buildPlacement(0, OADConfig.black_opal_max_spawn_height_end.get(), false));
    }

    private static void registerPlaced(ConfiguredFeature<?, ?> configured, String name, boolean enabled, double veinsPerChunk, List<PlacementModifier> placementModifiers) {
        if (!enabled) return;

        int integerPart = (int) veinsPerChunk;
        double fractionalPart = veinsPerChunk - integerPart;
        int[] denominators = closestDenominators(fractionalPart);

        // Main integer placements
        List<PlacementModifier> mainPlacement = new ArrayList<>(placementModifiers);
        mainPlacement.add(CountPlacement.of(integerPart));
        PlacedFeature mainFeature = new PlacedFeature(BuiltinRegistries.CONFIGURED_FEATURE.getKey(configured).orElseThrow(), mainPlacement);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(OresAboveDiamonds.MOD_ID, name), mainFeature);
        addToBiome(mainFeature, name);

        // Fractional placements
        if (denominators[0] > 0) registerFractional(configured, name + "_frac1", denominators[0], placementModifiers);
        if (denominators[1] > 0) registerFractional(configured, name + "_frac2", denominators[1], placementModifiers);
    }

    private static void registerFractional(ConfiguredFeature<?, ?> configured, String name, int rarity, List<PlacementModifier> baseModifiers) {
        List<PlacementModifier> modifiers = new ArrayList<>(baseModifiers);
        modifiers.add(RarityFilter.onAverageOnceEvery(rarity));
        PlacedFeature feature = new PlacedFeature(BuiltinRegistries.CONFIGURED_FEATURE.getKey(configured).orElseThrow(), modifiers);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(OresAboveDiamonds.MOD_ID, name), feature);
        addToBiome(feature, name);
    }

    private static void addToBiome(PlacedFeature feature, String name) {
        if (name.contains("nether")) {
            BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                    Registry.PLACED_FEATURE.getKey(feature).get());
        } else if (name.contains("end")) {
            BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                    Registry.PLACED_FEATURE.getKey(feature).get());
        } else {
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    Registry.PLACED_FEATURE.getKey(feature).get());
        }
    }

    private static List<PlacementModifier> buildPlacement(int maxHeight, boolean isOverworld) {
        return buildPlacement(-64, maxHeight, isOverworld);
    }

    private static List<PlacementModifier> buildPlacement(int minHeight, int maxHeight, boolean isOverworld) {
        List<PlacementModifier> modifiers = new ArrayList<>();
        modifiers.add(InSquarePlacement.spread());

        if (isOverworld) {
            modifiers.add(HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(minHeight), VerticalAnchor.aboveBottom(maxHeight)));
        } else {
            modifiers.add(HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)));
        }

        modifiers.add(BiomeFilter.biome());
        return modifiers;
    }

    // Replicates Forge closestDenominators() for fractional vein counts
    private static int[] closestDenominators(double c) {
        if (c <= 0) return new int[]{-1, -1};
        int x = 0, y = 0;
        double error = Double.MAX_VALUE;

        double s = 2.0 / c;
        if (Math.floor(s) == Math.ceil(s)) {
            x = (int) s;
            y = (int) s;
            error = 0;
        } else {
            s = 1.0 / c;
            int min = (int) Math.ceil(s);
            double r = -(double) min / (1 - (c * min));

            if (Math.floor(r) == Math.ceil(r)) {
                x = min;
                y = (int) Math.ceil(r);
                error = 0;
            } else {
                int max = (int) Math.floor(r);
                for (int i = min; i <= max; i++) {
                    double exact = -(double) i / (1 - (c * i));
                    double localError = Math.abs(c - (1.0 / i) - (1.0 / Math.round(exact)));
                    if (localError < error) {
                        error = localError;
                        x = i;
                        y = (int) Math.round(exact);
                    }
                }
            }
        }
        return new int[]{x, y};
    }
}
