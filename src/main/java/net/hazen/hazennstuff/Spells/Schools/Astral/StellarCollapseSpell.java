package net.hazen.hazennstuff.Spells.Schools.Astral;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Entity.Spells.Astral.ShootingStar.FallingStars.FallingStar;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StellarCollapseSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "stellar_collapse");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}), Component.translatable("ui.irons_spellbooks.radius", new Object[]{Utils.stringTruncation((double)this.getRadius(caster), 1)}));
    }

    public StellarCollapseSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.UNCOMMON)
                .setSchoolResource(HnSSchoolRegistry.ASTRAL_RESOURCE)
                .setMaxLevel(10)
                .setCooldownSeconds(16.0F)
                .build();
        this.manaCostPerLevel = 1;
        this.baseSpellPower = 8;
        this.spellPowerPerLevel = 1;
        this.castTime = 160;
        this.baseManaCost = 5;
    }

    public CastType getCastType() {
        return CastType.CONTINUOUS;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.STAR_CAST_2.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (!(playerMagicData.getAdditionalCastData() instanceof StarfallCastData)) {
            Vec3 targetArea = Utils.moveToRelativeGroundLevel(world, Utils.raycastForEntity(world, entity, 40.0F, true).getLocation(), 12);
            playerMagicData.setAdditionalCastData(new StarfallCastData(targetArea));
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public static void particleTrail(Level level, Vec3 a, Vec3 b, ParticleOptions particleType) {
        double d = a.distanceTo(b) * (double)4.0F;

        for(int i = 0; (double)i < d; ++i) {
            double p = (double)i / d;
            Vec3 vec = a.add(b.subtract(a).scale(p));
            MagicManager.spawnParticles(level, particleType, vec.x, vec.y, vec.z, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F, true);
        }

    }

    public void onServerCastTick(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        if (playerMagicData != null) {
            ICastData radius = playerMagicData.getAdditionalCastData();
            if (radius instanceof StarfallCastData) {
                StarfallCastData castData = (StarfallCastData)radius;
                float var16 = this.getRadius(entity);
                int tick = playerMagicData.getCastDurationRemaining() - 1;
                if (tick % 20 == 0) {
                    castData.updateTrackedEntities(level.getEntities(entity, AABB.ofSize(castData.center, (double)(var16 * 3.0F), (double)var16, (double)(var16 * 3.0F)), (e) -> e instanceof LivingEntity && !DamageSources.isFriendlyFireBetween(entity, e)));
                }

                if (tick % 4 == 0) {
                    for(int i = 0; i < 2; ++i) {
                        Vec3 center = castData.center;
                        Vec3 weightedArea = Vec3.ZERO;

                        for(Entity target : castData.trackedEntities) {
                            weightedArea = weightedArea.add(target.position().subtract(center).scale((double)(1.0F / (float)castData.trackedEntities.size())));
                        }

                        double spawnRadius = Mth.clampedLerp((double)var16, (double)var16 * (double)0.5F, weightedArea.length() / (double)var16);
                        Vec3 spawnTarget = Utils.moveToRelativeGroundLevel(level, center.add(weightedArea).add((new Vec3((double)0.0F, (double)0.0F, (double)entity.getRandom().nextFloat() * spawnRadius)).yRot((float)entity.getRandom().nextInt(360) * ((float)Math.PI / 180F))), 3).add((double)0.0F, (double)0.5F, (double)0.0F);
                        Vec3 trajectory = (new Vec3((double)0.15F, (double)-0.85F, (double)0.0F)).normalize();
                        Vec3 spawn = Utils.raycastForBlock(level, spawnTarget, spawnTarget.add(trajectory.scale((double)-12.0F)), Fluid.NONE).getLocation().add(trajectory);
                        this.shootComet(level, spellLevel, entity, spawn, trajectory);
                        MagicManager.spawnParticles(level, ParticleHelper.COMET_FOG, spawn.x, spawn.y, spawn.z, 1, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F, false);
                        MagicManager.spawnParticles(level, ParticleHelper.COMET_FOG, spawn.x, spawn.y, spawn.z, 1, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F, true);
                    }
                }

                return;
            }
        }

    }

    private float getDamage(int spellLevel, LivingEntity caster) {
        return this.getSpellPower(spellLevel, caster) * 0.5F;
    }

    private float getRadius(LivingEntity caster) {
        return 6.0F;
    }

    public void shootComet(Level world, int spellLevel, LivingEntity entity, Vec3 spawn, Vec3 trajectory) {
        FallingStar fallingStar = new FallingStar(world, entity);
        fallingStar.setPos(spawn.add((double)-1.0F, (double)0.0F, (double)0.0F));
        fallingStar.shoot(trajectory, 0.075F);
        fallingStar.setDamage(this.getDamage(spellLevel, entity));
        fallingStar.setExplosionRadius(2.0F);
        world.addFreshEntity(fallingStar);
        world.playSound(null, spawn.x, spawn.y, spawn.z, HnSSounds.STAR_CAST_1, SoundSource.PLAYERS, 3.0F, 0.7F + Utils.random.nextFloat() * 0.3F);
    }

    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.ANIMATION_CONTINUOUS_OVERHEAD;
    }

    public static class StarfallCastData implements ICastData {
        Vec3 center;
        final List<Entity> trackedEntities = new ArrayList();

        public StarfallCastData(Vec3 center) {
            this.center = center;
        }

        public void reset() {
            this.trackedEntities.clear();
        }

        public void updateTrackedEntities(List<Entity> entities) {
            this.trackedEntities.clear();
            this.trackedEntities.addAll(entities);
        }
    }
}
