package oresAboveDiamonds.init;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.OresAboveDiamonds;

/**
 * Fabric version of the item registry for OresAboveDiamonds
 */
public class ModItems {

    // ====== Basic Items ======
    public static final Item BLACK_OPAL = register("black_opal",
            new Item(new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST = register("amethyst",
            new Item(new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    // ====== Tool Materials ======
    public static final ToolMaterial AMETHYST_MATERIAL = ToolMaterials.DIAMOND;
    public static final ToolMaterial BLACK_OPAL_MATERIAL = ToolMaterials.NETHERITE;
    public static final ToolMaterial NETHERITE_OPAL_MATERIAL = ToolMaterials.NETHERITE;

    // ====== Amethyst Tools ======
    public static final Item AMETHYST_SWORD = register("amethyst_sword",
            new SwordItem(AMETHYST_MATERIAL, 3, -2.4F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST_PICKAXE = register("amethyst_pickaxe",
            new PickaxeItem(AMETHYST_MATERIAL, 1, -2.8F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST_SHOVEL = register("amethyst_shovel",
            new ShovelItem(AMETHYST_MATERIAL, 1.5F, -3.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST_AXE = register("amethyst_axe",
            new AxeItem(AMETHYST_MATERIAL, 5.0F, -3.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST_HOE = register("amethyst_hoe",
            new HoeItem(AMETHYST_MATERIAL, -4, 1.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    // ====== Black Opal Tools ======
    public static final Item BLACK_OPAL_SWORD = register("black_opal_sword",
            new SwordItem(BLACK_OPAL_MATERIAL, 3, -2.4F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_PICKAXE = register("black_opal_pickaxe",
            new PickaxeItem(BLACK_OPAL_MATERIAL, 1, -2.8F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_SHOVEL = register("black_opal_shovel",
            new ShovelItem(BLACK_OPAL_MATERIAL, 1.5F, -3.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_AXE = register("black_opal_axe",
            new AxeItem(BLACK_OPAL_MATERIAL, 5.0F, -3.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_HOE = register("black_opal_hoe",
            new HoeItem(BLACK_OPAL_MATERIAL, -5, 2.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    // ====== Netherite Opal Tools ======
    public static final Item NETHERITE_OPAL_SWORD = register("netherite_opal_sword",
            new SwordItem(NETHERITE_OPAL_MATERIAL, 3, -2.4F, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));
    public static final Item NETHERITE_OPAL_PICKAXE = register("netherite_opal_pickaxe",
            new PickaxeItem(NETHERITE_OPAL_MATERIAL, 1, -2.8F, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));
    public static final Item NETHERITE_OPAL_SHOVEL = register("netherite_opal_shovel",
            new ShovelItem(NETHERITE_OPAL_MATERIAL, 1.5F, -3.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));
    public static final Item NETHERITE_OPAL_AXE = register("netherite_opal_axe",
            new AxeItem(NETHERITE_OPAL_MATERIAL, 5.0F, -3.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));
    public static final Item NETHERITE_OPAL_HOE = register("netherite_opal_hoe",
            new HoeItem(NETHERITE_OPAL_MATERIAL, -6, 2.0F, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));

    // ====== Armor Materials ======
    public static final ArmorMaterial AMETHYST_ARMOR = new ModArmorMaterial("amethyst", 25, new int[]{2, 5, 6, 2}, 15, 2.0F, 0.0F);
    public static final ArmorMaterial BLACK_OPAL_ARMOR = new ModArmorMaterial("black_opal", 33, new int[]{3, 6, 8, 3}, 20, 3.0F, 0.1F);
    public static final ArmorMaterial NETHERITE_OPAL_ARMOR = new ModArmorMaterial("netherite_opal", 40, new int[]{3, 6, 8, 3}, 25, 3.0F, 0.2F);

    // ====== Amethyst Armor ======
    public static final Item AMETHYST_HELMET = register("amethyst_helmet",
            new ArmorItem(AMETHYST_ARMOR, ArmorItem.Type.HELMET, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST_CHESTPLATE = register("amethyst_chestplate",
            new ArmorItem(AMETHYST_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST_LEGGINGS = register("amethyst_leggings",
            new ArmorItem(AMETHYST_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item AMETHYST_BOOTS = register("amethyst_boots",
            new ArmorItem(AMETHYST_ARMOR, ArmorItem.Type.BOOTS, new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    // ====== Black Opal Armor ======
    public static final Item BLACK_OPAL_HELMET = register("black_opal_helmet",
            new ArmorItem(BLACK_OPAL_ARMOR, ArmorItem.Type.HELMET, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_CHESTPLATE = register("black_opal_chestplate",
            new ArmorItem(BLACK_OPAL_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_LEGGINGS = register("black_opal_leggings",
            new ArmorItem(BLACK_OPAL_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_BOOTS = register("black_opal_boots",
            new ArmorItem(BLACK_OPAL_ARMOR, ArmorItem.Type.BOOTS, new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    // ====== Netherite Opal Armor ======
    public static final Item NETHERITE_OPAL_HELMET = register("netherite_opal_helmet",
            new ArmorItem(NETHERITE_OPAL_ARMOR, ArmorItem.Type.HELMET, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));
    public static final Item NETHERITE_OPAL_CHESTPLATE = register("netherite_opal_chestplate",
            new ArmorItem(NETHERITE_OPAL_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));
    public static final Item NETHERITE_OPAL_LEGGINGS = register("netherite_opal_leggings",
            new ArmorItem(NETHERITE_OPAL_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));
    public static final Item NETHERITE_OPAL_BOOTS = register("netherite_opal_boots",
            new ArmorItem(NETHERITE_OPAL_ARMOR, ArmorItem.Type.BOOTS, new Item.Settings().group(ModItemGroups.OAD_GROUP).fireproof()));

    // ====== Blocks as Items ======
    public static final Item AMETHYST_BLOCK = register("amethyst_block",
            new BlockItem(ModBlocks.AMETHYST_BLOCK, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item BLACK_OPAL_BLOCK = register("black_opal_block",
            new BlockItem(ModBlocks.BLACK_OPAL_BLOCK, new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    // ====== Ore Variants ======
    public static final Item AMETHYST_ORE = register("amethyst_ore",
            new BlockItem(ModBlocks.AMETHYST_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item DEEPSLATE_AMETHYST_ORE = register("deepslate_amethyst_ore",
            new BlockItem(ModBlocks.DEEPSLATE_AMETHYST_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item NETHER_AMETHYST_ORE = register("nether_amethyst_ore",
            new BlockItem(ModBlocks.NETHER_AMETHYST_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item END_AMETHYST_ORE = register("end_amethyst_ore",
            new BlockItem(ModBlocks.END_AMETHYST_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    public static final Item BLACK_OPAL_ORE = register("black_opal_ore",
            new BlockItem(ModBlocks.BLACK_OPAL_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item DEEPSLATE_BLACK_OPAL_ORE = register("deepslate_black_opal_ore",
            new BlockItem(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item NETHER_BLACK_OPAL_ORE = register("nether_black_opal_ore",
            new BlockItem(ModBlocks.NETHER_BLACK_OPAL_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));
    public static final Item END_BLACK_OPAL_ORE = register("end_black_opal_ore",
            new BlockItem(ModBlocks.END_BLACK_OPAL_ORE, new Item.Settings().group(ModItemGroups.OAD_GROUP)));

    // ====== Helper ======
    private static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, new Identifier(OresAboveDiamonds.MODID, name), item);
    }

    public static void registerItems() {
        System.out.println("[OresAboveDiamonds] Items registered!");
    }
}
