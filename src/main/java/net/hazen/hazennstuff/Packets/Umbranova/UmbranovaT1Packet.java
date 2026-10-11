package net.hazen.hazennstuff.Packets.Umbranova;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T1.UmbranovaT1AttackManager;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record UmbranovaT1Packet() implements CustomPacketPayload {
    public static final Type<UmbranovaT1Packet> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "umbranova_t1_attack"));
    public static final StreamCodec<RegistryFriendlyByteBuf, UmbranovaT1Packet> STREAM_CODEC =
            StreamCodec.unit(new UmbranovaT1Packet());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(UmbranovaT1Packet packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                UmbranovaT1AttackManager.attack(player);
            }
        });
    }
}
