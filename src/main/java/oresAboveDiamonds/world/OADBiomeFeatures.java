package oresAboveDiamonds.world;

import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;

public class OADBiomeFeatures {

    public static void addOresToBiomes() {
        // Add ores to overworld biomes
        OADPlacedFeatures.AMETHYST_ORE_PLACED.value().getPlacementModifiers().forEach(mod -> {
            // Normally you would iterate through biomes and add features properly
        });

        // For Fabric 1.21, use BiomeModifications API if needed
    }
}
