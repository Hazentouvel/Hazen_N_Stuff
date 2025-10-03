package net.hazen.hazennstuff.registries;

import com.mojang.serialization.MapCodec;
import io.redspace.ironsspellbooks.particle.SparkParticleOptions;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.registries.particle.LeafParticle.LeafParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HnSParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, HazenNStuff.MOD_ID);


    // Mushroom Particle
    public static final Supplier<SimpleParticleType> MUSHROOM_PARTICLE = PARTICLE_TYPES.register("mushroom_particle",
            () -> new SimpleParticleType(false));

    // Leaf Particle
    public static final Supplier<ParticleType<LeafParticleOptions>> LEAF_PARTICLE =
            PARTICLE_TYPES.register("leaf_particle", () -> new ParticleType<LeafParticleOptions>(true) {
                @Override
                public MapCodec<LeafParticleOptions> codec() {
                    return LeafParticleOptions.MAP_CODEC;
                }

                @Override
                public StreamCodec<? super RegistryFriendlyByteBuf, LeafParticleOptions> streamCodec() {
                    return LeafParticleOptions.STREAM_CODEC;
                }
            });



    public static void register(IEventBus eventBus)
    {
        PARTICLE_TYPES.register(eventBus);
    }
}