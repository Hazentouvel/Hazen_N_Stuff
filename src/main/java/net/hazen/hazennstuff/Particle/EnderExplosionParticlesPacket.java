package net.hazen.hazennstuff.Particle;

import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import net.hazen.hazennstuff.Setup.HnSClientSpellCastHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class EnderExplosionParticlesPacket implements CustomPacketPayload {
    private final Vec3 pos1;
    private final float radius;
    public static final CustomPacketPayload.Type<EnderExplosionParticlesPacket> TYPE = new CustomPacketPayload.Type(ResourceLocation.fromNamespaceAndPath("hazennstuff", "fiery_explosion_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EnderExplosionParticlesPacket> STREAM_CODEC = CustomPacketPayload.codec(EnderExplosionParticlesPacket::write, EnderExplosionParticlesPacket::new);

    public EnderExplosionParticlesPacket(Vec3 pos1, float radius) {
        this.pos1 = pos1;
        this.radius = radius;
    }

    public EnderExplosionParticlesPacket(FriendlyByteBuf buf) {
        this.pos1 = buf.readVec3();
        this.radius = buf.readFloat();
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeVec3(this.pos1);
        buf.writeFloat(this.radius);
    }

    public static void handle(EnderExplosionParticlesPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> HnSClientSpellCastHelper.handleClientboundEnderExplosion(packet.pos1, packet.radius));
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
