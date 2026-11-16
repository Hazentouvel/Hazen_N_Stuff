package net.hazen.hazennstuff.Packets.FireblossomRapier;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Weapons.Special.FireblossomRapier.FireblossomRapierAttackManager;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record FireblossomRapierPacket() implements CustomPacketPayload {
    public static final Type<FireblossomRapierPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_rapier_attack"));
    public static final StreamCodec<RegistryFriendlyByteBuf, FireblossomRapierPacket> STREAM_CODEC =
            StreamCodec.unit(new FireblossomRapierPacket());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(FireblossomRapierPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                FireblossomRapierAttackManager.attack(player);
            }
        });
    }
}
