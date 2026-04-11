package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.util.MinecraftInstanceHelper;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class HnSClientSpellCastHelper {
    private static boolean suppressRightClicks;

    public HnSClientSpellCastHelper() {
    }

    public static void handleClientboundEnderExplosion(Vec3 pos, float radius) {
        MinecraftInstanceHelper.ifPlayerPresent((player) -> {
            Level level = player.level;
            double x = pos.x;
            double y = pos.y;
            double z = pos.z;
            level.addParticle(new BlastwaveParticleOptions(new Vector3f(1.0F, 0.2F, 1.0F), radius + 1.0F), x, y, z, (double)0.0F, (double)0.0F, (double)0.0F);
            int c = (int)(6.28 * (double)radius) * 2;
            float step = 360.0F / (float)c * ((float)Math.PI / 180F);
            float speed = (0.06F + 0.01F * radius) * 2.0F;

            for(int i = 0; i < c; ++i) {
                Vec3 vec3 = (new Vec3((double)Mth.cos(step * (float)i), (double)0.0F, (double)Mth.sin(step * (float)i))).scale((double)speed);
                Vec3 posOffset = Utils.getRandomVec3((double)0.5F).add(vec3.scale((double)10.0F));
                vec3 = vec3.add(Utils.getRandomVec3(0.01));
                level.addParticle(ParticleHelper.UNSTABLE_ENDER, x + posOffset.x, y + posOffset.y, z + posOffset.z, vec3.x, vec3.y, vec3.z);
            }

            int cloudDensity = 50 + (int)(25.0F * radius);

            for(int i = 0; i < cloudDensity; ++i) {
                Vec3 posOffset = Utils.getRandomVec3((double)1.0F).scale((double)(radius * 0.125F));
                Vec3 motion = posOffset.normalize().scale((double)(speed * 0.5F));
                posOffset = posOffset.add(motion.scale(Utils.getRandomScaled((double)1.0F)));
                motion = motion.add(Utils.getRandomVec3((double)(speed * 0.1F)));
                level.addParticle(ParticleHelper.UNSTABLE_ENDER, x + posOffset.x, y + posOffset.y, z + posOffset.z, motion.x, motion.y, motion.z);
            }

            for(int i = 0; i < cloudDensity; i += 2) {
                Vec3 posOffset = Utils.getRandomVec3((double)1.0F).scale((double)(radius * 0.4F));
                Vec3 motion = posOffset.normalize().scale((double)(speed * 0.5F));
                motion = motion.add(Utils.getRandomVec3((double)0.25F));
                level.addParticle(ParticleHelper.ENDER_SPARKS, true, x + posOffset.x, y + posOffset.y, z + posOffset.z, motion.x, motion.y, motion.z);
                level.addParticle(ParticleHelper.UNSTABLE_ENDER, x + posOffset.x * (double)0.5F, y + posOffset.y * (double)0.5F, z + posOffset.z * (double)0.5F, motion.x, motion.y, motion.z);
            }

            for(int i = 0; i < cloudDensity; i += 2) {
                Vec3 posOffset = Utils.getRandomVec3((double)radius).scale((double)0.2F);
                Vec3 motion = posOffset.normalize().scale(0.8);
                motion = motion.add(Utils.getRandomVec3(0.18));
                level.addParticle(ParticleHelper.UNSTABLE_ENDER, x + posOffset.x * (double)0.5F, y + posOffset.y * (double)0.5F, z + posOffset.z * (double)0.5F, motion.x, motion.y, motion.z);
            }

        });
    }
}
