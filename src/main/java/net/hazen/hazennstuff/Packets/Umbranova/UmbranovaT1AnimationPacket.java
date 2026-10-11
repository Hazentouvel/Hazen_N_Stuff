package net.hazen.hazennstuff.Packets.Umbranova;

import net.hazen.hazennstuff.Client.Umbranova.UmbranovaT1AnimationHandler;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record UmbranovaT1AnimationPacket(int entityId, boolean rightAttack) implements CustomPacketPayload {
    public static final Type<UmbranovaT1AnimationPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "umbranova_t1_attack_animation"));
    public static final StreamCodec<RegistryFriendlyByteBuf, UmbranovaT1AnimationPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, UmbranovaT1AnimationPacket::entityId,
                    ByteBufCodecs.BOOL, UmbranovaT1AnimationPacket::rightAttack,
                    UmbranovaT1AnimationPacket::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(UmbranovaT1AnimationPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (FMLEnvironment.dist == Dist.CLIENT) {
                UmbranovaT1AnimationHandler.handle(packet);
            }
        });
    }
}
