package oresAboveDiamonds.events;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.config.OADConfig;

public class LootTableHandler {

    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (!id.getNamespace().equals("minecraft")) return;

            String path = id.getPath();
            if (!path.startsWith("chests/")) return;

            if (!OADConfig.get().chestLoot) return;

            switch (path.substring("chests/".length())) {
                case "abandoned_mineshaft":
                case "bastion_treasure":
                case "jungle_temple":
                case "buried_treasure":
                case "desert_pyramid":
                case "end_city_treasure":
                case "nether_bridge":
                case "shipwreck_treasure":
                case "village_toolsmith":
                case "village_weaponsmith":
                    tableBuilder.pool(LootPool.builder()
                            .with(ItemEntry.builder(Item.byRawId( /* your ore item ID */ ))
                                    .weight(1)
                                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))))
                            .name("oresabovediamonds_inject")
                    );
                    break;
                default:
                    break;
            }
        });
    }
}
