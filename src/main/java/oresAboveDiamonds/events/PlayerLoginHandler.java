package oresAboveDiamonds.events;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.config.OADConfig;

public class PlayerLoginHandler {

    // Unique ID for your packet
    public static final Identifier SYNC_CONFIG_PACKET = new Identifier("oresabovediamonds", "sync_config");

    public static void register() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.player;

            sendConfigToPlayer(player);
        });
    }

    private static void sendConfigToPlayer(ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());

        // Ore rarity
        buf.writeDouble(OADConfig.get().amethystTimesRarer);
        buf.writeDouble(OADConfig.get().blackOpalTimesRarer);

        // Vein sizes
        buf.writeInt(OADConfig.get().amethystVeinSize);
        buf.writeInt(OADConfig.get().blackOpalVeinSize);

        // Max heights
        buf.writeInt(OADConfig.get().amethystMaxSpawnHeightOverworld);
        buf.writeInt(OADConfig.get().blackOpalMaxSpawnHeightOverworld);
        buf.writeInt(OADConfig.get().amethystMaxSpawnHeightNether);
        buf.writeInt(OADConfig.get().blackOpalMaxSpawnHeightNether);
        buf.writeInt(OADConfig.get().amethystMaxSpawnHeightEnd);
        buf.writeInt(OADConfig.get().blackOpalMaxSpawnHeightEnd);

        // Tool stats
        buf.writeInt(OADConfig.get().amethystAttackDamage);
        buf.writeInt(OADConfig.get().amethystEfficiency);
        buf.writeInt(OADConfig.get().amethystDurability);
        buf.writeInt(OADConfig.get().blackOpalAttackDamage);
        buf.writeInt(OADConfig.get().blackOpalEfficiency);
        buf.writeInt(OADConfig.get().blackOpalDurability);

        // Armor stats
        buf.writeInt(OADConfig.get().amethystArmorToughness);
        buf.writeInt(OADConfig.get().blackOpalArmorToughness);

        // Misc
        buf.writeBoolean(OADConfig.get().chestLoot);
        buf.writeBoolean(OADConfig.get().oldCombatMechanics);

        // Ore spawn flags
        buf.writeBoolean(OADConfig.get().spawnAmethystOverworld);
        buf.writeBoolean(OADConfig.get().spawnBlackOpalOverworld);
        buf.writeBoolean(OADConfig.get().spawnAmethystNether);
        buf.writeBoolean(OADConfig.get().spawnBlackOpalNether);
        buf.writeBoolean(OADConfig.get().spawnAmethystEnd);
        buf.writeBoolean(OADConfig.get().spawnBlackOpalEnd);

        // Send the packet
        ServerPlayNetworking.send(player, SYNC_CONFIG_PACKET, buf);
    }
}
