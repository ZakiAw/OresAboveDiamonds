package oresAboveDiamonds.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.OresAboveDiamonds;

public class ModItemGroups {

    public static final ItemGroup OAD_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(OresAboveDiamonds.MODID, "tab"),
        FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.AMETHYST))
            .displayName(Text.translatable("itemGroup." + OresAboveDiamonds.MODID))
            .entries((context, entries) -> {
                // Add all your mod items here
                entries.add(ModItems.AMETHYST);
                entries.add(ModItems.BLACK_OPAL);
                entries.add(ModItems.AMETHYST_SWORD);
                entries.add(ModItems.BLACK_OPAL_SWORD);
                entries.add(ModItems.NETHERITE_OPAL_SWORD);
                entries.add(ModItems.AMETHYST_BLOCK);
                entries.add(ModItems.BLACK_OPAL_BLOCK);
                // etc.
            })
            .build()
    );

    public static void registerItemGroups() {
        // No-op in Fabric, just ensures the static initializer runs
    }
}
