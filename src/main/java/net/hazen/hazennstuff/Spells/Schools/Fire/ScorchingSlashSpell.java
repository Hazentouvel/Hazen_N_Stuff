package net.hazen.hazennstuff.Spells.Schools.Fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.magic.SpellSelectionManager;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import io.redspace.ironsspellbooks.particle.FlameStrikeParticleOptions;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Entity.Spells.Fire.ImmolatingObliterator.ScorchingSlash;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Spells.AbstractSpells.AbstractRavensBaneSpell;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ScorchingSlashSpell extends AbstractRavensBaneSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "scorching_slash");


    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", getDamageText(spellLevel, caster)));
    }

    public boolean allowLooting() {
        return false;
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(3)
            .setCooldownSeconds(15)
            .build();

    public ScorchingSlashSpell() {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 2;
        this.castTime = 10;
        this.baseManaCost = 30;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundRegistry.FLAMING_STRIKE_UPSWING.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.FLAMING_STRIKE_SWING.get());
    }

    public CastType getCastType() {
        return CastType.LONG;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public boolean canBeInterrupted(@Nullable Player player) {
        return false;
    }

    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.ONE_HANDED_HORIZONTAL_SWING_ANIMATION;
    }

    public AnimationHolder getCastFinishAnimation() {
        return AnimationHolder.pass();
    }

    public int getEffectiveCastTime(int spellLevel, @Nullable LivingEntity entity) {
        return this.getCastTime(spellLevel);
    }

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        float radius = 3.25F;
        float distance = 1.9F;
        Vec3 forward = entity.getForward();
        Vec3 hitLocation = entity.position().add((double)0.0F, (double)(entity.getBbHeight() * 0.3F), (double)0.0F).add(forward.scale((double)distance));
        List<Entity> entities = level.getEntities(entity, AABB.ofSize(hitLocation, (double)(radius * 2.0F), (double)radius, (double)(radius * 2.0F)));
        SpellDamageSource damageSource = this.getDamageSource(entity);
        for(Entity targetEntity : entities) {
            if (targetEntity instanceof LivingEntity && targetEntity.isAlive() && entity.isPickable() && targetEntity.position().subtract(entity.getEyePosition()).dot(forward) >= (double)0.0F && entity.distanceToSqr(targetEntity) < (double)(radius * radius) && Utils.hasLineOfSight(level, entity.getEyePosition(), targetEntity.getBoundingBox().getCenter(), true)) {
                Vec3 offsetVector = targetEntity.getBoundingBox().getCenter().subtract(entity.getEyePosition());
                if (offsetVector.dot(forward) >= (double)0.0F && DamageSources.applyDamage(targetEntity, this.getDamage(spellLevel, entity), damageSource)) {
                    MagicManager.spawnParticles(level, ParticleHelper.FIRE, targetEntity.getX(), targetEntity.getY() + (double)(targetEntity.getBbHeight() * 0.5F), targetEntity.getZ(), 30, (double)(targetEntity.getBbWidth() * 0.5F), (double)(targetEntity.getBbHeight() * 0.5F), (double)(targetEntity.getBbWidth() * 0.5F), 0.03, false);
                    EnchantmentHelper.doPostAttackEffects((ServerLevel)level, targetEntity, damageSource);
                }
            }
        }
        if (!level.isClientSide) {
            ScorchingSlash projectile = new ScorchingSlash(HnSEntityRegistry.SCORCHING_SLASH.get(), level);
            projectile.setOwner(entity);
            projectile.setPos(entity.getX(), entity.getEyeY() - 0.2, entity.getZ());
            projectile.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.6f, 0.05f);
            projectile.setDamage(this.getDamage(spellLevel, entity));
            level.addFreshEntity(projectile);
        }
        boolean mirrored = playerMagicData.getCastingEquipmentSlot().equals(SpellSelectionManager.OFFHAND);
        MagicManager.spawnParticles(level, new FlameStrikeParticleOptions((float)forward.x, (float)forward.y, (float)forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y + 0.3, hitLocation.z, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F, true);
        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private float getAdditionalDamage(LivingEntity entity) {
        if (entity == null) {
            return 0.0F;
        } else {
            float weaponDamage = Utils.getWeaponDamage(entity);
            ItemStack weaponItem = entity.getWeaponItem();
            if (!weaponItem.isEmpty() && weaponItem.has(DataComponents.ENCHANTMENTS)) {
                weaponDamage += (float)Utils.getEnchantmentLevel(entity.level(), Enchantments.FIRE_ASPECT, (ItemEnchantments)weaponItem.get(DataComponents.ENCHANTMENTS));
            }
            return weaponDamage;
        }
    }

    private String getDamageText(int spellLevel, LivingEntity entity) {
        if (entity != null) {
            float weaponDamage = Utils.getWeaponDamage(entity);
            String plus = "";
            if (weaponDamage > 0.0F) {
                plus = String.format(" (+%s)", Utils.stringTruncation((double)weaponDamage, 1));
            }
            String damage = Utils.stringTruncation((double)this.getDamage(spellLevel, entity), 1);
            return damage + plus;
        } else {
            float var10000 = this.getSpellPower(spellLevel, entity);
            return "" + var10000;
        }
    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5.0F + getSpellPower(spellLevel, caster) * 0.7F + this.getAdditionalDamage(caster);
    }

    public SpellDamageSource getDamageSource(Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setFireTicks(90);
    }
}
