package oresAboveDiamonds.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.OresAboveDiamonds;

public class OADConfiguredFeature {

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> AMETHYST_ORE =
            Feature.ORE.configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.AMETHYST_ORE.getDefaultState(),
                    5 // vein size
            ));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> BLACK_OPAL_ORE =
            Feature.ORE.configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.BLACK_OPAL_ORE.getDefaultState(),
                    4
            ));

    public static void register() {
        // Ensures registration
        AMETHYST_ORE.toString();
        BLACK_OPAL_ORE.toString();
    }
}
