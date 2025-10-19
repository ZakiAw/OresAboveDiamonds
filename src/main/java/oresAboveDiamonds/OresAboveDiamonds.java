package oresAboveDiamonds;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.init.ModItems;

public class OresAboveDiamonds implements ModInitializer {
    public static final String MOD_ID = "oresabovediamonds";

    @Override
    public void onInitialize() {
        OADConfig.register();
        PlayerLoginHandler.register();
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModItemGroups.registerItemGroups();
        OADPlacedFeatureFabric.register();

        System.out.println("[OresAboveDiamonds] Mod initialized successfully!");
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
