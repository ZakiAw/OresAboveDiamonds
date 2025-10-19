package oresAboveDiamonds.network;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.config.OADConfig;

public class ConfigSyncPacket {

    public static final Identifier SYNC_CONFIG = new Identifier("oresabovediamonds", "sync_config");

    private final OADConfig config;

    public ConfigSyncPacket(OADConfig config) {
        this.config = config;
    }

    // Serialize the config into a PacketByteBuf
    public PacketByteBuf toPacketByteBuf() {
        PacketByteBuf buf = PacketByteBufs.create();

        buf.writeDouble(config.amethystTimesRarer);
        buf.writeDouble(config.blackOpalTimesRarer);

        buf.writeInt(config.amethystVeinSize);
        buf.writeInt(config.blackOpalVeinSize);

        buf.writeDouble(config.amethystMaxSpawnHeightOverworld);
        buf.writeDouble(config.blackOpalMaxSpawnHeightOverworld);

        buf.writeInt(config.amethystAttackDamage);
        buf.writeInt(config.amethystDurability);
        buf.writeInt(config.amethystEfficiency);

        buf.writeInt(config.blackOpalAttackDamage);
        buf.writeInt(config.blackOpalDurability);
        buf.writeInt(config.blackOpalEfficiency);

        buf.writeBoolean(config.spawnAmethystOverworld);
        buf.writeBoolean(config.spawnBlackOpalOverworld);

        buf.writeBoolean(config.oldCombatMechanics);
        buf.writeBoolean(config.chestLoot);

        // Add more fields as needed, following the same pattern
        return buf;
    }

    // Send the config to a player
    public static void send(ServerPlayerEntity player, OADConfig config) {
        ServerPlayNetworking.send(player, SYNC_CONFIG, new ConfigSyncPacket(config).toPacketByteBuf());
    }
}
