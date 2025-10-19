package net.hazen.hazennstuff.Registries.Particle.General;

import net.hazen.hazennstuff.Spells.Shadow.ChaoticTeleportSpell;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class HnSRodOfDiscordParticlesPacket implements CustomPacketPayload {
    private final Vec3 pos1;
    private final Vec3 pos2;
    public static final CustomPacketPayload.Type<HnSRodOfDiscordParticlesPacket> TYPE = new CustomPacketPayload.Type(ResourceLocation.fromNamespaceAndPath("hazennstuff", "teleport_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, HnSRodOfDiscordParticlesPacket> STREAM_CODEC = CustomPacketPayload.codec(HnSRodOfDiscordParticlesPacket::write, HnSRodOfDiscordParticlesPacket::new);

    public HnSRodOfDiscordParticlesPacket(Vec3 pos1, Vec3 pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public HnSRodOfDiscordParticlesPacket(FriendlyByteBuf buf) {
        this.pos1 = buf.readVec3();
        this.pos2 = buf.readVec3();
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeVec3(this.pos1);
        buf.writeVec3(this.pos2);
    }

    public static void handle(HnSRodOfDiscordParticlesPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            Level level = context.player().level();
            if (level != null) {
                ChaoticTeleportSpell.particleCloud(level, packet.pos1);
                ChaoticTeleportSpell.particleCloud(level, packet.pos2);
            }
        });
    }


    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
