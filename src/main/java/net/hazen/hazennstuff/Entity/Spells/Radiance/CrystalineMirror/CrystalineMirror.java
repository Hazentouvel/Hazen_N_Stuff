package net.hazen.hazennstuff.Entity.Spells.Radiance.CrystalineMirror;

import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.mobs.AntiMagicSusceptible;
import io.redspace.ironsspellbooks.entity.spells.AbstractShieldEntity;
import io.redspace.ironsspellbooks.entity.spells.ShieldPart;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.PartEntity;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class CrystalineMirror extends AbstractShieldEntity implements GeoEntity, AntiMagicSusceptible {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    protected ShieldPart[] subEntities;
    protected final Vec3[] subPositions;
    protected final int LIFETIME;
    protected int width;
    protected int height;
    protected int age;

    public CrystalineMirror(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.width = 5;
        this.height = 5;
        this.subEntities = new ShieldPart[this.width * this.height];
        this.subPositions = new Vec3[this.width * this.height];
        this.setHealth(10.0F);
        this.LIFETIME = 400;
        this.createShield();
    }

    public CrystalineMirror(Level level, float health) {
        this((EntityType) HnSEntityRegistry.CRYSTALINE_MIRROR.get(), level);
        this.setHealth(health);
    }

    protected void createShield() {
        for(int x = 0; x < this.width; ++x) {
            for(int y = 0; y < this.height; ++y) {
                int i = x * this.height + y;
                this.subEntities[i] = new ShieldPart(this, "part" + (i + 1), 0.5F, 0.5F, true);
                this.subPositions[i] = new Vec3((double)(((float)x - (float)this.width / 2.0F) * 0.5F + 0.25F), (double)(((float)y - (float)this.height / 2.0F) * 0.5F), (double)0.0F);
            }
        }

    }

    public void setRotation(float x, float y) {
        this.setXRot(x);
        this.xRotO = x;
        this.setYRot(y);
        this.yRotO = y;
    }

    /**
     * Changed behaviour:
     * - Ignore magic damage entirely.
     * - If the damage source is a Projectile, reflect it instead of consuming/destroying it.
     * - Otherwise keep original physical damage handling.
     */
    public void takeDamage(DamageSource source, float amount, @Nullable Vec3 location) {
        if (this.isInvulnerableTo(source)) {
            return;
        }

        // If the direct entity is a projectile, reflect it instead of letting it be destroyed
        Entity direct = source.getDirectEntity();
        if (direct instanceof Projectile) {
            Projectile projectile = (Projectile) direct;
            if (!projectile.noPhysics) {
                // Reflect along the mirror's forward vector
                Vec3 forward = this.getForward();
                double speed = projectile.getDeltaMovement().length();
                // Set owner to the mirror (or keep existing owner logic if you have a caster owner to use)
                try {
                    projectile.setOwner(this);
                } catch (Exception ignored) {
                    // In case the projectile expects a LivingEntity owner, ignore failure and still shoot
                }
                projectile.shoot(forward.x, forward.y, forward.z, (float)speed, 0.0F);

                // Play particles/sound at impact location if provided
                if (!this.level.isClientSide && location != null) {
                    MagicManager.spawnParticles(this.level, ParticleTypes.ELECTRIC_SPARK, location.x, location.y, location.z, 30, 0.1, 0.1, 0.1, (double)0.5F, false);
                    this.level.playSound((Player)null, location.x, location.y, location.z, (SoundEvent)SoundRegistry.FORCE_IMPACT.get(), SoundSource.NEUTRAL, 0.8F, 1.0F);
                }
                return;
            }
        }

        // Fallback: physical damage reduces shield health like before
        this.setHealth(this.getHealth() - amount);
        if (!this.level.isClientSide && location != null) {
            MagicManager.spawnParticles(this.level, ParticleTypes.ELECTRIC_SPARK, location.x, location.y, location.z, 30, 0.1, 0.1, 0.1, (double)0.5F, false);
            this.level.playSound((Player)null, location.x, location.y, location.z, (SoundEvent)SoundRegistry.FORCE_IMPACT.get(), SoundSource.NEUTRAL, 0.8F, 1.0F);
        }
    }

    public void tick() {
        this.hurtThisTick = false;
        if (this.getHealth() <= 0.0F) {
            this.destroy();
        } else if (++this.age > this.LIFETIME) {
            if (!this.level.isClientSide) {
                this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, SoundSource.NEUTRAL, 1.0F, 1.4F);
            }

            this.discard();
        } else {
            for(int i = 0; i < this.subEntities.length; ++i) {
                ShieldPart subEntity = this.subEntities[i];
                Vec3 pos = this.subPositions[i].xRot(((float)Math.PI / 180F) * -this.getXRot()).yRot(((float)Math.PI / 180F) * -this.getYRot()).add(this.position());
                subEntity.setPos(pos);
                subEntity.xo = pos.x;
                subEntity.yo = pos.y;
                subEntity.zo = pos.z;
                subEntity.xOld = pos.x;
                subEntity.yOld = pos.y;
                subEntity.zOld = pos.z;
            }
        }

    }

    public PartEntity<?>[] getParts() {
        return this.subEntities;
    }

    protected void destroy() {
        if (!this.level.isClientSide) {
            this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.GLASS_BREAK, SoundSource.NEUTRAL, 2.0F, 0.65F);
        }

        super.destroy();
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.shooting_star.idle");

    private PlayState predicate(AnimationState event) {
        event.getController().setAnimation(idle);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    private float damage = 2.0f; // Default value

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
