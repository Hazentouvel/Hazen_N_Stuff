package net.hazen.hazennstuff.Registries;

import com.mojang.serialization.MapCodec;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.Particle.LeafParticle.LeafParticleOptions;
import net.hazen.hazennstuff.Registries.Particle.SlashParticles.Spells.IonicSLash.IonicSlashOptions;
import net.hazen.hazennstuff.Registries.Particle.SlashParticles.Spells.NatureSlash.NatureSlashOptions;
import net.hazen.hazennstuff.Registries.Particle.SlashParticles.Spells.NightsEdgeStrike.NightsEdgeStrikeOptions;
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

    // Ball Particles
    public static final Supplier<SimpleParticleType> NIGHTS_EDGE_PARTICLE = PARTICLE_TYPES.register("nights_edge_particle",
            () -> new SimpleParticleType(false));

    // Ball Particles
    public static final Supplier<SimpleParticleType> ROD_OF_DISCORD_PARTICLE = PARTICLE_TYPES.register("rod_of_discord_particle",
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

    public static final Supplier<ParticleType<NightsEdgeStrikeOptions>> NIGHTS_EDGE_STRIKE_PARTICLE =
            PARTICLE_TYPES.register("nights_edge_strike_particle", () -> new ParticleType<NightsEdgeStrikeOptions>(true) {
        public MapCodec<NightsEdgeStrikeOptions> codec() {
            return NightsEdgeStrikeOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, NightsEdgeStrikeOptions> streamCodec() {
            return NightsEdgeStrikeOptions.STREAM_CODEC;
        }
    });

    public static final Supplier<ParticleType<NatureSlashOptions>> NATURE_SLASH_PARTICLE =
            PARTICLE_TYPES.register("nature_slash_particle", () -> new ParticleType<NatureSlashOptions>(true) {
                public MapCodec<NatureSlashOptions> codec() {
                    return NatureSlashOptions.MAP_CODEC;
                }

                public StreamCodec<? super RegistryFriendlyByteBuf, NatureSlashOptions> streamCodec() {
                    return NatureSlashOptions.STREAM_CODEC;
                }
            });


    public static final Supplier<ParticleType<IonicSlashOptions>> IONIC_STRIKE =
            PARTICLE_TYPES.register("ionic_strike_particle", () -> new ParticleType<IonicSlashOptions>(true) {
                public MapCodec<IonicSlashOptions> codec() {
                    return IonicSlashOptions.MAP_CODEC;
                }

                public StreamCodec<? super RegistryFriendlyByteBuf, IonicSlashOptions> streamCodec() {
                    return IonicSlashOptions.STREAM_CODEC;
                }
            });

    public static final Supplier<SimpleParticleType> BLADE_PARTICLES = PARTICLE_TYPES.register("blade_particle", () -> new SimpleParticleType(false));


    public static void register(IEventBus eventBus)
    {
        PARTICLE_TYPES.register(eventBus);
    }
}