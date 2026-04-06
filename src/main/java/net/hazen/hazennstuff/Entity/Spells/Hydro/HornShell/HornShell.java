package net.hazen.hazennstuff.Entity.Spells.Hydro.HornShell;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import mod.azure.azurelib.core.utils.MathHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;

public class HornShell extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final List<Entity> victims;
    private int hitsPerTick;
    BlockPos lastHitBlock;

    public HornShell(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new ArrayList();
        this.setNoGravity(true);
        this.setPierceLevel(-1);
    }

    public HornShell(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.HORN_SHELL.get(), level);
        setOwner(shooter);
    }

    public void trailParticles() {
    }

    public void impactParticles(double x, double y, double z) {
    }


    public float getSpeed() {
        return 2F;
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if (!this.victims.contains(entity)) {
            DamageSources.applyDamage(entity, this.damage, ((AbstractSpell)HnSSpellRegistries.HORN_SHELL.get()).getDamageSource(this, this.getOwner()));
            this.victims.add(entity);
        }

        if (this.getPierceLevel() != 0) {
            if (this.hitsPerTick++ < 5) {
                HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, (x$0) -> this.canHitEntity(x$0));
                if (hitresult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact(this, hitresult)) {
                    this.onHit(hitresult);
                }
            }

            this.pierceOrDiscard();
        } else {
            this.discard();
        }

    }

    protected void onHit(HitResult result) {
        if (!this.level.isClientSide) {
            BlockPos blockPos = BlockPos.containing(result.getLocation());
            if (result.getType() == HitResult.Type.BLOCK && !blockPos.equals(this.lastHitBlock)) {
                this.lastHitBlock = blockPos;
            } else if (result.getType() == HitResult.Type.ENTITY) {
                this.level.playSound((Player)null, BlockPos.containing(this.position()), (SoundEvent) SoundRegistry.FORCE_IMPACT.get(), SoundSource.NEUTRAL, 2.0F, 0.65F);
            }
        }

        super.onHit(result);
    }

    protected boolean shouldPierceShields() {
        return true;
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
            return Optional.of(HnSSounds.TERRARIA_IMPACT);
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("idle");

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
}