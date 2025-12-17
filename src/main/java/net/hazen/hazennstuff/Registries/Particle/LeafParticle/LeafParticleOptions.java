package net.hazen.hazennstuff.Registries.Particle.LeafParticle;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.codec.StreamCodec;
import org.joml.Vector3f;

public class LeafParticleOptions implements ParticleOptions {
    public final Vector3f color;
    public static StreamCodec<? super ByteBuf, LeafParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.color.x);
        buf.writeFloat(option.color.y);
        buf.writeFloat(option.color.z);
    }, (buf) -> new LeafParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<LeafParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec((object) -> object.group(Codec.FLOAT.fieldOf("r").forGetter((p) -> p.color.x), Codec.FLOAT.fieldOf("g").forGetter((p) -> p.color.y), Codec.FLOAT.fieldOf("b").forGetter((p) -> p.color.z)).apply(object, LeafParticleOptions::new));

    public LeafParticleOptions(Vector3f color) {
        this.color = color;
    }

    public LeafParticleOptions(float r, float g, float b) {
        this(new Vector3f(r, g, b));
    }

    public ParticleType<?> getType() {
        return (ParticleType) HnSParticleRegistry.LEAF_PARTICLE.get();
    }
}
