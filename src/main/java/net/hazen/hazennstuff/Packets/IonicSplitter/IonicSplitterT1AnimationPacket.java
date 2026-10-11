package net.hazen.hazennstuff.Packets.IonicSplitter;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Client.IonicSplitter.IonicSplitterT1AnimationHandler;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record IonicSplitterT1AnimationPacket(int entityId, boolean rightAttack) implements CustomPacketPayload {
    public static final Type<IonicSplitterT1AnimationPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ionic_splitter_t1_attack_animation"));
    public static final StreamCodec<RegistryFriendlyByteBuf, IonicSplitterT1AnimationPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, IonicSplitterT1AnimationPacket::entityId,
                    ByteBufCodecs.BOOL, IonicSplitterT1AnimationPacket::rightAttack,
                    IonicSplitterT1AnimationPacket::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(IonicSplitterT1AnimationPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (FMLEnvironment.dist == Dist.CLIENT) {
                IonicSplitterT1AnimationHandler.handle(packet);
            }
        });
    }
}
