package net.hazen.hazennstuff.particle.nights_edge_strike;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import io.redspace.ironsspellbooks.registries.ParticleRegistry;
import net.hazen.hazennstuff.registries.HnSParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

public class NightsEdgeStrikeParticleOptions implements ParticleOptions {
    public final float scale;
    public final float xf;
    public final float yf;
    public final float zf;
    public final boolean mirror, vertical;

    public NightsEdgeStrikeParticleOptions(float xf, float yf, float zf, boolean mirror, boolean vertical, float scale) {
        this.scale = scale;
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
        this.mirror = mirror;
        this.vertical = vertical;
    }

    public static StreamCodec<? super ByteBuf, NightsEdgeStrikeParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.xf);
                buf.writeFloat(option.yf);
                buf.writeFloat(option.zf);
                buf.writeBoolean(option.mirror);
                buf.writeBoolean(option.vertical);
                buf.writeFloat(option.scale);
            },
            (buf) -> new NightsEdgeStrikeParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readBoolean(), buf.readBoolean(), buf.readFloat())
    );

    public static MapCodec<NightsEdgeStrikeParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("xf").forGetter(p -> ((NightsEdgeStrikeParticleOptions) p).xf),
                    Codec.FLOAT.fieldOf("yf").forGetter(p -> ((NightsEdgeStrikeParticleOptions) p).yf),
                    Codec.FLOAT.fieldOf("zf").forGetter(p -> ((NightsEdgeStrikeParticleOptions) p).zf),
                    Codec.BOOL.fieldOf("mirror").forGetter(p -> ((NightsEdgeStrikeParticleOptions) p).mirror),
                    Codec.BOOL.fieldOf("vertical").forGetter(p -> ((NightsEdgeStrikeParticleOptions) p).vertical),
                    Codec.FLOAT.fieldOf("scale").forGetter(p -> ((NightsEdgeStrikeParticleOptions) p).scale)
            ).apply(object, NightsEdgeStrikeParticleOptions::new
            ));

    public @NotNull ParticleType<NightsEdgeStrikeParticleOptions> getType() {
        return HnSParticleRegistry.NIGHTS_EDGE_STRIKE_PARTICLE.get();
    }
}