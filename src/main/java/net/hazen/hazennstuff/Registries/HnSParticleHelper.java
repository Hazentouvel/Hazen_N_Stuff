package net.hazen.hazennstuff.Registries;

import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.particle.FogParticleOptions;
import io.redspace.ironsspellbooks.particle.SparkParticleOptions;
import net.hazen.hazennstuff.Registries.Particle.LeafParticle.LeafParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import org.joml.Vector3f;

public class HnSParticleHelper {

    public static final ParticleOptions LEAF_PARTICLE;


    public static final ParticleOptions ICE_CLOUD = new FogParticleOptions(new Vector3f(0.9f,1f, .91f), 1f);
    public static final ParticleOptions MUSHROOM_FOG = new FogParticleOptions(new Vector3f(0.036f, 0.27f, 0.72f), 0.7f);
    public static final ParticleOptions ICHOR_TRAIL = new SparkParticleOptions(new Vector3f(0.95F, 0.7F, 0.23F));
    public static final ParticleOptions NATURE_IMPACT = new BlastwaveParticleOptions(new Vector3f(0.95F, 0.7F, 0.23F), 1.0F);
    public static final ParticleOptions BLADE_PARTICLE = HnSParticleRegistry.BLADE_PARTICLES.get();
    public static final ParticleOptions MUSHROOM_PARTICLE = HnSParticleRegistry.MUSHROOM_PARTICLE.get();
    public static final ParticleOptions NIGHTS_EDGE_PARTICLE = HnSParticleRegistry.NIGHTS_EDGE_PARTICLE.get();
    public static final ParticleOptions ROD_OF_DISCORD_PARTICLE = HnSParticleRegistry.ROD_OF_DISCORD_PARTICLE.get();


    static {
        LEAF_PARTICLE = new LeafParticleOptions(new Vector3f(0.23f, 0.78f, 0.08f));
    }
}