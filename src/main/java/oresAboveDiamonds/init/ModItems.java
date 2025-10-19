package oresAboveDiamonds.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.CreativeModeTab;
import oresAboveDiamonds.items.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {
    public static final Map<String, Item> ITEMS = new LinkedHashMap<>();

    // Armor materials
    public static final ArmorMaterial AMETHYST_ARMOR = new ModArmorMaterial("amethyst", 25, new int[]{2, 5, 6, 2}, 15, 2.0F, 0.0F);
    public static final ArmorMaterial BLACK_OPAL_ARMOR = new ModArmorMaterial("black_opal", 33, new int[]{3, 6, 8, 3}, 20, 3.0F, 0.1F);

    // Items
    public static final Item AMETHYST_INGOT = register("amethyst_ingot", new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final Item BLACK_OPAL = register("black_opal", new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    // Armor Items (example)
    public static final Item AMETHYST_HELMET = register("amethyst_helmet", new CustomArmorItem(AMETHYST_ARMOR, net.minecraft.world.entity.EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final Item BLACK_OPAL_HELMET = register("black_opal_helmet", new CustomArmorItem(BLACK_OPAL_ARMOR, net.minecraft.world.entity.EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static void registerItems() {
        // Already added in ITEMS map
    }

    private static Item register(String name, Item item) {
        ITEMS.put(name, item);
        return item;
    }
}
