package net.hazen.hazennstuff.Registries.Particle.SlashParticles.Spells.NightsEdgeStrike;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

public class NightsEdgeStrikeOptions implements ParticleOptions {
    public final float scale;
    public final float xf;
    public final float yf;
    public final float zf;
    public final boolean mirror;
    public final boolean vertical;
    public static StreamCodec<? super ByteBuf, NightsEdgeStrikeOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.xf);
        buf.writeFloat(option.yf);
        buf.writeFloat(option.zf);
        buf.writeBoolean(option.mirror);
        buf.writeBoolean(option.vertical);
        buf.writeFloat(option.scale);
    }, (buf) -> new NightsEdgeStrikeOptions(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readBoolean(), buf.readBoolean(), buf.readFloat()));
    public static MapCodec<NightsEdgeStrikeOptions> MAP_CODEC = RecordCodecBuilder.mapCodec((object) -> object.group(Codec.FLOAT.fieldOf("xf").forGetter((p) -> p.xf), Codec.FLOAT.fieldOf("yf").forGetter((p) -> p.yf), Codec.FLOAT.fieldOf("zf").forGetter((p) -> p.zf), Codec.BOOL.fieldOf("mirror").forGetter((p) -> p.mirror), Codec.BOOL.fieldOf("vertical").forGetter((p) -> p.vertical), Codec.FLOAT.fieldOf("scale").forGetter((p) -> p.scale)).apply(object, NightsEdgeStrikeOptions::new));

    public NightsEdgeStrikeOptions(float xf, float yf, float zf, boolean mirror, boolean vertical, float scale) {
        this.scale = scale;
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
        this.mirror = mirror;
        this.vertical = vertical;
    }

    public @NotNull ParticleType<NightsEdgeStrikeOptions> getType() {
        return (ParticleType) HnSParticleRegistry.NIGHTS_EDGE_STRIKE_PARTICLE.get();
    }
}
