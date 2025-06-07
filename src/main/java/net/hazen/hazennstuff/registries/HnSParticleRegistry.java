package net.hazen.hazennstuff.registries;

import com.mojang.serialization.MapCodec;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.particle.*;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.particle.nights_edge_strike.NightsEdgeStrikeParticleOptions;
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

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    /*
    To Create Particle:
    - textures + json
    - particle class
    - register it here
    - add it to particle helper
    - register it in client setup
     */

    public static final Supplier<ParticleType<NightsEdgeStrikeParticleOptions>> NIGHTS_EDGE_STRIKE_PARTICLE = PARTICLE_TYPES.register("nights_edge_strike", () -> new ParticleType<>(true) {
        public MapCodec<NightsEdgeStrikeParticleOptions> codec() {
            return NightsEdgeStrikeParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, NightsEdgeStrikeParticleOptions> streamCodec() {
            return NightsEdgeStrikeParticleOptions.STREAM_CODEC;
        }
    });
}