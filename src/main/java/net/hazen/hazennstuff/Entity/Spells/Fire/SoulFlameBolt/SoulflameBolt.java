package net.hazen.hazennstuff.Entity.Spells.Fire.SoulFlameBolt;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import java.util.Optional;


import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class SoulflameBolt extends AbstractMagicProjectile {
    public SoulflameBolt(EntityType<? extends SoulflameBolt> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
    }

    public SoulflameBolt(Level levelIn, LivingEntity shooter) {
        this(HnSEntityRegistry.SOUL_FLAME_BOLT.get(), levelIn);
        this.setOwner(shooter);
    }

    public float getSpeed() {
        return 1.75F;
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.FIREWORK_ROCKET_BLAST));
    }

    protected void doImpactSound(Holder<SoundEvent> sound) {
        this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), sound, SoundSource.NEUTRAL, 2.0F, 1.2F + Utils.random.nextFloat() * 0.2F);
    }

    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        this.discard();
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity target = entityHitResult.getEntity();

        DamageSources.applyDamage(target, this.getDamage(), (HnSSpellRegistries.SOUL_FLAME_BOLT.get()).getDamageSource(this, this.getOwner()));
        this.pierceOrDiscard();
    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, ParticleTypes.LAVA, x, y, z, 5, 0.1, 0.1, 0.1, (double)0.25F, true);
    }

    public void trailParticles() {
        if (this.tickCount >= 2) {
            Vec3 vel = this.getDeltaMovement();
            if (!(vel.lengthSqr() < 1.0E-6)) {
                float radius = 0.25F;
                int steps = 4;
                Vec3 forward = vel.normalize();
                Vec3 worldUp = new Vec3((double)0.0F, (double)1.0F, (double)0.0F);
                Vec3 axis1 = forward.cross(worldUp);
                if (axis1.lengthSqr() < 1.0E-6) {
                    axis1 = forward.cross(new Vec3((double)1.0F, (double)0.0F, (double)0.0F));
                }

                axis1 = axis1.normalize();
                Vec3 axis2 = forward.cross(axis1);
                double x2 = this.getX();
                double y2 = this.getY();
                double z2 = this.getZ();
                double x1 = x2 - vel.x;
                double y1 = y2 - vel.y;
                double z1 = z2 - vel.z;

                for(int j = 0; j < steps; ++j) {
                    float t = (float)j / (float)steps;
                    double baseX = Mth.lerp((double)t, x1, x2);
                    double baseY = Mth.lerp((double)t, y1, y2);
                    double baseZ = Mth.lerp((double)t, z1, z2);
                    double radians = (double)((float)this.tickCount + t) / (double)7.5F * (double)((float)Math.PI * 2F);
                    double c = Math.cos(radians) * (double)radius;
                    double s = Math.sin(radians) * (double)radius;
                    double x = baseX + axis1.x * c + axis2.x * s;
                    double y = baseY + axis1.y * c + axis2.y * s;
                    double z = baseZ + axis1.z * c + axis2.z * s;
                    Vec3 jitter = Utils.getRandomVec3((double)0.05F);
                    this.level.addParticle(ParticleHelper.SOUL_FIRE, true, x, y, z, jitter.x, jitter.y, jitter.z);
                }

            }
        }
    }

}