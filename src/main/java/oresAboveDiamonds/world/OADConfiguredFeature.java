package oresAboveDiamonds.world;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.init.ModBlocks;

public class OADConfiguredFeature {

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> AMETHYST_ORE_FEATURE =
            Registry.register(Registry.CONFIGURED_FEATURE,
                    new Identifier(OresAboveDiamonds.MOD_ID, "amethyst_ore"),
                    Feature.ORE.configure(new OreFeatureConfig(
                            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                            ModBlocks.AMETHYST_ORE.getDefaultState(),
                            6
                    )));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> BLACK_OPAL_ORE_FEATURE =
            Registry.register(Registry.CONFIGURED_FEATURE,
                    new Identifier(OresAboveDiamonds.MOD_ID, "black_opal_ore"),
                    Feature.ORE.configure(new OreFeatureConfig(
                            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                            ModBlocks.BLACK_OPAL_ORE.getDefaultState(),
                            4
                    )));

    public static void registerAll() {}
}
