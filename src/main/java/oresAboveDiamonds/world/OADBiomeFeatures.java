package oresAboveDiamonds.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class OADBiomeFeatures {

    public static void addFeatures() {

        // Overworld
        addFeature(OADConfiguredFeature.AMETHYST_SMALL, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.foundInOverworld());
        addFeature(OADConfiguredFeature.AMETHYST_BURIED, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.foundInOverworld());
        addFeature(OADConfiguredFeature.AMETHYST_LARGE, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.foundInOverworld());

        addFeature(OADConfiguredFeature.BLACK_OPAL_SMALL, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.foundInOverworld());
        addFeature(OADConfiguredFeature.BLACK_OPAL_BURIED, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.foundInOverworld());
        addFeature(OADConfiguredFeature.BLACK_OPAL_LARGE, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.foundInOverworld());

        // Nether
        addFeature(OADConfiguredFeature.NETHER_AMETHYST, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.tag(net.minecraft.tags.BiomeTags.IS_NETHER));
        addFeature(OADConfiguredFeature.NETHER_BLACK_OPAL, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.tag(net.minecraft.tags.BiomeTags.IS_NETHER));

        // End
        addFeature(OADConfiguredFeature.END_AMETHYST, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.tag(net.minecraft.tags.BiomeTags.IS_END));
        addFeature(OADConfiguredFeature.END_BLACK_OPAL, GenerationStep.Decoration.UNDERGROUND_ORES, BiomeSelectors.tag(net.minecraft.tags.BiomeTags.IS_END));
    }

    private static void addFeature(Holder<ConfiguredFeature<?, ?>> feature, GenerationStep.Decoration step, BiomeSelectors.BiomeSelector selector) {
        BiomeModifications.addFeature(selector, step, feature);
    }
}
