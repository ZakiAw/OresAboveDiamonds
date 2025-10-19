package oresAboveDiamonds.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.OresAboveDiamonds;

public class ModItems {

    public static final Item BLACK_OPAL = registerItem("black_opal",
            new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static void registerAll() {}

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(OresAboveDiamonds.MOD_ID, name), item);
    }
}
