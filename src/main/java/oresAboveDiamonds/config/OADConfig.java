package oresAboveDiamonds.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class OADConfig extends ConfigData {

    // Ore spawning
    public boolean spawnAmethystOverworld = true;
    public boolean spawnBlackOpalOverworld = true;
    public boolean spawnAmethystNether = false;
    public boolean spawnBlackOpalNether = false;
    public boolean spawnAmethystEnd = false;
    public boolean spawnBlackOpalEnd = false;

    // Ore rarity
    public double amethystTimesRarer = 3.0;
    public double blackOpalTimesRarer = 9.0;
    public int amethystVeinSize = 8;
    public int blackOpalVeinSize = 8;

    // Ore max heights
    public int amethystMaxSpawnHeightOverworld = 8;
    public int blackOpalMaxSpawnHeightOverworld = 0;
    public int amethystMaxSpawnHeightNether = 128;
    public int blackOpalMaxSpawnHeightNether = 128;
    public int amethystMaxSpawnHeightEnd = 75;
    public int blackOpalMaxSpawnHeightEnd = 75;

    // Tool stats
    public int amethystAttackDamage = 4;
    public int amethystEfficiency = 12;
    public int amethystDurability = 2625;
    public int blackOpalAttackDamage = 5;
    public int blackOpalEfficiency = 16;
    public int blackOpalDurability = 5250;

    // Armor stats
    public int amethystArmorToughness = 3;
    public int blackOpalArmorToughness = 4;

    // Misc
    public boolean chestLoot = true;
    public boolean oldCombatMechanics = false;

    // Network sync (Fabric doesn’t have built-in sync; you’ll need custom packets if desired)
    public boolean enableServerConfigSync = true;
    public boolean sendPacketSyncConfig = true;

    // Load config
    public static void register() {
        AutoConfig.register(OADConfig.class, JanksonConfigSerializer::new);
    }

    // Get the config instance
    public static OADConfig get() {
        return AutoConfig.getConfigHolder(OADConfig.class).getConfig();
    }
}
