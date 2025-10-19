package oresAboveDiamonds.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.util.KeyboardUtil;

import javax.annotation.Nullable;
import java.util.List;

public class TooltipBlockItem extends BlockItem {

    public TooltipBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    private void addDescription(List<Component> tooltip, double chance, double vein, int height, String world, String color, double disappearChance) {
        tooltip.add(Component.literal("\u00A7aGenerating in the " + world));
        if (world.equalsIgnoreCase("Nether")) {
            tooltip.add(Component.literal(color + (2 * chance) + "x\u00A7r rarer than Nether Gold Ore"));
        } else if (world.equalsIgnoreCase("End")) {
            tooltip.add(Component.literal(color + chance + "x\u00A7r less dense than Overworld Diamonds"));
        } else {
            tooltip.add(Component.literal(color + chance + "x\u00A7r rarer than Diamonds"));
        }
        tooltip.add(Component.literal("Max vein size of " + color + vein));
        tooltip.add(Component.literal("Spawns below " + color + "y:" + height));
        tooltip.add(Component.literal(color + Math.round(disappearChance * 100) + "%\u00A7r chance of disappearing if exposed to air"));
    }

    private void addDisabled(List<Component> tooltip) {
        tooltip.add(Component.literal("\u00A7cDISABLED"));
        tooltip.add(Component.literal("Not supported for 1.19.3+. Can still be added with data packs"));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        String blockName = this.getDescriptionId().toUpperCase();
        blockName = blockName.substring(blockName.lastIndexOf('.') + 1);

        if (KeyboardUtil.isHoldingShift()) {
            switch (blockName) {
                case "DEEPSLATE_AMETHYST_ORE" -> {
                    if (OADConfig.spawn_amethyst_overworld.getDefault()) {
                        tooltip.add(Component.literal("Spawns when a normal Amethyst Ore generates in a deepslate block."));
                    } else addDisabled(tooltip);
                }
                case "AMETHYST_ORE" -> {
                    if (OADConfig.spawn_amethyst_overworld.getDefault()) {
                        addDescription(
                            tooltip,
                            OADConfig.amethyst_times_rarer.getDefault(),
                            OADConfig.amethyst_vein_size.getDefault(),
                            OADConfig.amethyst_max_spawn_height_overworld.getDefault(),
                            "Overworld",
                            "\u00A7d",
                            OADConfig.overworld_discard_chance_on_air_exposure.getDefault()
                        );
                    } else addDisabled(tooltip);
                }
                case "NETHER_AMETHYST_ORE" -> {
                    if (OADConfig.spawn_amethyst_nether.getDefault()) {
                        int spawnChance = Math.max(1, (int) (OADConfig.amethyst_times_rarer.getDefault() / OADConfig.nether_chance_multiplier.getDefault()));
                        int veinSize = (int) (OADConfig.amethyst_vein_size.getDefault() * OADConfig.nether_vein_multiplier.getDefault());
                        addDescription(tooltip, spawnChance, veinSize, OADConfig.amethyst_max_spawn_height_nether.getDefault(), "Nether", "\u00A7d", OADConfig.nether_discard_chance_on_air_exposure.getDefault());
                    } else addDisabled(tooltip);
                }
                case "END_AMETHYST_ORE" -> {
                    if (OADConfig.spawn_amethyst_end.getDefault()) {
                        int spawnChance = Math.max(1, (int) (OADConfig.amethyst_times_rarer.getDefault() / OADConfig.end_chance_multiplier.getDefault()));
                        int veinSize = (int) (OADConfig.amethyst_vein_size.getDefault() * OADConfig.end_vein_multiplier.getDefault());
                        addDescription(tooltip, spawnChance, veinSize, OADConfig.amethyst_max_spawn_height_end.getDefault(), "End", "\u00A7d", OADConfig.end_discard_chance_on_air_exposure.getDefault());
                    } else addDisabled(tooltip);
                }
                case "DEEPSLATE_BLACK_OPAL_ORE" -> {
                    if (OADConfig.spawn_black_opal_overworld.getDefault()) {
                        tooltip.add(Component.literal("Spawns when a normal Black Opal Ore generates in a deepslate block."));
                    } else addDisabled(tooltip);
                }
                case "BLACK_OPAL_ORE" -> {
                    if (OADConfig.spawn_black_opal_overworld.getDefault()) {
                        addDescription(tooltip, OADConfig.black_opal_times_rarer.getDefault(), OADConfig.black_opal_vein_size.getDefault(), OADConfig.black_opal_max_spawn_height_overworld.getDefault(), "Overworld", "\u00A75", OADConfig.overworld_discard_chance_on_air_exposure.getDefault());
                    } else addDisabled(tooltip);
                }
                case "NETHER_BLACK_OPAL_ORE" -> {
                    if (OADConfig.spawn_black_opal_nether.getDefault()) {
                        int spawnChance = Math.max(1, (int) (OADConfig.black_opal_times_rarer.getDefault() / OADConfig.nether_chance_multiplier.getDefault()));
                        int veinSize = (int) (OADConfig.black_opal_vein_size.getDefault() * OADConfig.nether_vein_multiplier.getDefault());
                        addDescription(tooltip, spawnChance, veinSize, OADConfig.black_opal_max_spawn_height_nether.getDefault(), "Nether", "\u00A75", OADConfig.nether_discard_chance_on_air_exposure.getDefault());
                    } else addDisabled(tooltip);
                }
                case "END_BLACK_OPAL_ORE" -> {
                    if (OADConfig.spawn_black_opal_end.getDefault()) {
                        int spawnChance = Math.max(1, (int) (OADConfig.black_opal_times_rarer.getDefault() / OADConfig.end_chance_multiplier.getDefault()));
                        int veinSize = (int) (OADConfig.black_opal_vein_size.getDefault() * OADConfig.end_vein_multiplier.getDefault());
                        addDescription(tooltip, spawnChance, veinSize, OADConfig.black_opal_max_spawn_height_end.getDefault(), "End", "\u00A75", OADConfig.end_discard_chance_on_air_exposure.getDefault());
                    } else addDisabled(tooltip);
                }
                default -> { }
            }
        } else {
            tooltip.add(Component.literal("\u00A77\u00A7oHold \u00A76\u00A7oSHIFT \u00A77\u00A7ofor more information"));
        }
    }
}
