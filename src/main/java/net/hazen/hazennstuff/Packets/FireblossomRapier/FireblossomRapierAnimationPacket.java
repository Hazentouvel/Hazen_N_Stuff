package net.hazen.hazennstuff.Packets.FireblossomRapier;

import net.hazen.hazennstuff.Client.FireblossomRapier.FireblossomRapierAnimationHandler;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record FireblossomRapierAnimationPacket(int entityId, boolean basicAttack, boolean barrage) implements CustomPacketPayload {
    public static final Type<FireblossomRapierAnimationPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_rapier_attack_animation"));
    public static final StreamCodec<RegistryFriendlyByteBuf, FireblossomRapierAnimationPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, FireblossomRapierAnimationPacket::entityId,
                    ByteBufCodecs.BOOL, FireblossomRapierAnimationPacket::basicAttack,
                    ByteBufCodecs.BOOL, FireblossomRapierAnimationPacket::barrage,
                    FireblossomRapierAnimationPacket::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(FireblossomRapierAnimationPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (FMLEnvironment.dist == Dist.CLIENT) {
                FireblossomRapierAnimationHandler.handle(packet);
            }
        });
    }
}
