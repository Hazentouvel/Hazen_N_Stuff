package net.hazen.hazennstuff.Packets.IonicSplitter;

import net.hazen.hazennstuff.Client.IonicSplitter.IonicSplitterT2AnimationHandler;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record IonicSplitterT2AnimationPacket(int entityId, boolean rightAttack, boolean barrage) implements CustomPacketPayload {
    public static final Type<IonicSplitterT2AnimationPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ionic_splitter_t2_attack_animation"));
    public static final StreamCodec<RegistryFriendlyByteBuf, IonicSplitterT2AnimationPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, IonicSplitterT2AnimationPacket::entityId,
                    ByteBufCodecs.BOOL, IonicSplitterT2AnimationPacket::rightAttack,
                    ByteBufCodecs.BOOL, IonicSplitterT2AnimationPacket::barrage,
                    IonicSplitterT2AnimationPacket::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(IonicSplitterT2AnimationPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (FMLEnvironment.dist == Dist.CLIENT) {
                IonicSplitterT2AnimationHandler.handle(packet);
            }
        });
    }
}
