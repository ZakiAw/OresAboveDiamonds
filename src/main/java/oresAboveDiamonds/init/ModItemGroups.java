package oresAboveDiamonds.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemGroup;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.init.ModBlocks;

public class ModItemGroups {
    public static ItemGroup OAD_GROUP;

    public static void registerItemGroups() {
        OAD_GROUP = ItemGroup.TAB_MISC; // Or use Fabric API ItemGroup builder
    }
}
