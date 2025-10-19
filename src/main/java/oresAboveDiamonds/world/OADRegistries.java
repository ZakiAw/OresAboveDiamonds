package oresAboveDiamonds.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import oresAboveDiamonds.OresAboveDiamonds;

public class OADRegistries {

    public static void register() {
        // Ensure configured features are registered first
        ModConfiguredFeatures.register();
        OADPlacedFeatures.register();

        // Add ore features to overworld biomes
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                OADPlacedFeatures.AMETHYST_ORE_PLACED.getKey().orElseThrow()
        );

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                OADPlacedFeatures.BLACK_OPAL_ORE_PLACED.getKey().orElseThrow()
        );
    }
}
