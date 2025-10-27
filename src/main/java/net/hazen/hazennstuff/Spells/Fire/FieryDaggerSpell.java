package net.hazen.hazennstuff.Spells.Fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;

import java.util.List;

import net.hazen.hazennstuff.Entity.Spells.Fire.FireDaggers.FieryDaggerMagicProjectile;
import net.hazen.hazennstuff.Spells.HnSSpellAnimations;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

@AutoSpellConfig
public class FieryDaggerSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "fiery_dagger");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));
    }

    public FieryDaggerSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.LEGENDARY)
                .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
                .setMaxLevel(5)
                .setCooldownSeconds(8.0F)
                .setAllowCrafting(false)
                .build();
        this.manaCostPerLevel = 2;
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 10;
    }

    public CastType getCastType() {
        return CastType.INSTANT;
    }

    public AnimationHolder getCastFinishAnimation() {
        return HnSSpellAnimations.FIERY_DAGGER_CAST;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (world.isClientSide) return;

        Vec3 look = entity.getLookAngle();
        float explosionRadius = spellLevel >= 6 ? 1.0F + spellLevel * 0.5F : 0f;

        if (spellLevel >= 6) {
            // LEVEL 6+: 3 daggers front + diagonals, with zone
            int[] angles = {0, -15, 15};
            for (int angle : angles) {
                FieryDaggerMagicProjectile dagger = new FieryDaggerMagicProjectile(world);
                dagger.setOwner(entity);
                dagger.setDamage(this.getDamage(spellLevel, entity));
                dagger.setExplosionRadius(explosionRadius); // zone active
                dagger.setPos(entity.position().add(0.0, entity.getEyeHeight() - dagger.getBbHeight() * 0.5, 0.0));

                Vec3 dir = look.yRot((float) Math.toRadians(angle));
                dagger.shoot(dir.x, dir.y, dir.z, 1.25F, 0.0F);

                world.addFreshEntity(dagger);
            }
        }
        else {
            // LEVELS 1–5: overhead arc of daggers above the player
            int count = 8; // number of daggers
            double arcAngle = Math.toRadians(120); // total curvature angle (e.g. 120°)
            double radius = 1.6; // distance from the player's center
            double height = 1.2; // how far above the player’s head
            float shootSpeed = 1.2F; // forward velocity
            float inaccuracy = 0.0F; // how straight they fly

            // Local orientation relative to where the player is facing
            Vec3 forward = entity.getLookAngle().normalize();
            Vec3 up = new Vec3(0, 1, 0);
            Vec3 right = forward.cross(up).normalize();
            up = right.cross(forward).normalize(); // ensure orthogonal (prevents drift)

            // Center of the arc — above the player’s head and slightly forward
            Vec3 arcCenter = entity.position()
                    .add(0, entity.getEyeHeight() + height, 0)
                    .add(forward.scale(0.5));

            for (int i = 0; i < count; i++) {
                double t = (double) i / (count - 1);
                double angle = -arcAngle / 2 + t * arcAngle; // spans from left to right

                // Arc
                Vec3 offset =
                        right.scale(Math.sin(angle) * radius)   // left-right spread
                                .add(up.scale(Math.cos(angle) * radius * 0.7)); // curve height

                Vec3 spawnPos = arcCenter.add(offset);

                FieryDaggerMagicProjectile dagger = new FieryDaggerMagicProjectile(world);
                dagger.setOwner(entity);
                dagger.setDamage(this.getDamage(spellLevel, entity));
                dagger.setExplosionRadius(0f);
                dagger.setPos(spawnPos);

                // Make the dagger face the player’s direction
                dagger.setYRot(entity.getYRot());
                dagger.setXRot(entity.getXRot());

                // FIRE FORWARD (this is what makes them actually move)
                dagger.shoot(forward.x, forward.y, forward.z, shootSpeed, inaccuracy);

                world.addFreshEntity(dagger);
            }
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setFireTicks(60);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.5F;
    }
}
