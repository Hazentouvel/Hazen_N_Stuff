package net.hazen.hazennstuff.registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HnSParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, HazenNStuff.MOD_ID);

    // Mushroom Particle
    public static final Supplier<SimpleParticleType> MUSHROOM_PARTICLE = PARTICLE_TYPES.register("mushroom_particle",
            () -> new SimpleParticleType(false));


    public static void register(IEventBus eventBus)
    {
        PARTICLE_TYPES.register(eventBus);
    }
}