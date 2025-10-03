package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.particle.FogParticleOptions;
import net.hazen.hazennstuff.registries.particle.LeafParticle.LeafParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import org.joml.Vector3f;

public class HnSParticleHelper {

    public static final ParticleOptions LEAF_PARTICLE;


    public static final ParticleOptions ICE_CLOUD = new FogParticleOptions(new Vector3f(0.9f,1f, .91f), 1f);
    public static final ParticleOptions MUSHROOM_FOG = new FogParticleOptions(new Vector3f(0.036f, 0.27f, 0.72f), 0.7f);
    public static final ParticleOptions MUSHROOM_PARTICLE = HnSParticleRegistry.MUSHROOM_PARTICLE.get();


    static {
        LEAF_PARTICLE = new LeafParticleOptions(new Vector3f(1F, 1.0F, 1.0F));
    }
}