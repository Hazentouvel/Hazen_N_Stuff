package net.hazen.hazennstuff.Packets.IonicSplitter;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T1.IonicSplitterT1AttackManager;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record IonicSplitterT1Packet() implements CustomPacketPayload {
    public static final Type<IonicSplitterT1Packet> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ionic_splitter_t1_attack"));
    public static final StreamCodec<RegistryFriendlyByteBuf, IonicSplitterT1Packet> STREAM_CODEC =
            StreamCodec.unit(new IonicSplitterT1Packet());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(IonicSplitterT1Packet packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                IonicSplitterT1AttackManager.attack(player);
            }
        });
    }
}
