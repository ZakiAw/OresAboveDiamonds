package oresAboveDiamonds.world;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDataProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import oresAboveDiamonds.OresAboveDiamonds;

import java.util.concurrent.CompletableFuture;

/**
 * Fabric version of registry and data generation for OAD.
 * Registers configured and placed features for Fabric.
 */
public class OADRegistriesFabric {

    public static void registerConfiguredFeatures() {
        // Register each configured feature in the built-in registry
        registerConfigured(OADConfiguredFeatureFabric.AMETHYST_SMALL, "amethyst_small");
        registerConfigured(OADConfiguredFeatureFabric.AMETHYST_BURIED, "amethyst_buried");
        registerConfigured(OADConfiguredFeatureFabric.AMETHYST_LARGE, "amethyst_large");

        registerConfigured(OADConfiguredFeatureFabric.BLACK_OPAL_SMALL, "black_opal_small");
        registerConfigured(OADConfiguredFeatureFabric.BLACK_OPAL_BURIED, "black_opal_buried");
        registerConfigured(OADConfiguredFeatureFabric.BLACK_OPAL_LARGE, "black_opal_large");

        registerConfigured(OADConfiguredFeatureFabric.NETHER_AMETHYST, "nether_amethyst");
        registerConfigured(OADConfiguredFeatureFabric.NETHER_BLACK_OPAL, "nether_black_opal");
        registerConfigured(OADConfiguredFeatureFabric.END_AMETHYST, "end_amethyst");
        registerConfigured(OADConfiguredFeatureFabric.END_BLACK_OPAL, "end_black_opal");
    }

    public static void registerPlacedFeatures() {
        OADPlacedFeatureFabric.register(); // call the placed feature registration
    }

    private static void registerConfigured(ConfiguredFeature<?, ?> feature, String name) {
        Registry.register(Registry.CONFIGURED_FEATURE, OresAboveDiamonds.id(name), feature);
    }

    // Optional: Fabric data generator provider
    public static class OADDataProvider implements FabricDataProvider {

        private final FabricDataOutput output;

        public OADDataProvider(FabricDataOutput output) {
            this.output = output;
        }

        @Override
        public void run(CompletableFuture<net.minecraft.server.packs.PackResources> completableFuture) {
            // Implement data generation logic if needed (e.g., JSON for features)
        }

        @Override
        public String getName() {
            return "Ores Above Diamonds Fabric Data Provider";
        }
    }
}
