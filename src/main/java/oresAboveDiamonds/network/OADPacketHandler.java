package oresAboveDiamonds.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.config.OADConfig;

public class OADNetwork {

    public static final Identifier SYNC_CONFIG = new Identifier("oresabovediamonds", "sync_config");

    // Send the config to a player
    public static void sendConfig(ServerPlayerEntity player) {
        // Serialize the config to a simple packet
        ConfigSyncPacket packet = new ConfigSyncPacket(OADConfig.get());
        ServerPlayNetworking.send(player, SYNC_CONFIG, packet.toPacketByteBuf());
    }
}
