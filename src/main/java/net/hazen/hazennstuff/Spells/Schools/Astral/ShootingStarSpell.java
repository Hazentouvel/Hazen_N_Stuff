package net.hazen.hazennstuff.Spells.Schools.Astral;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import net.hazen.hazennstuff.Entity.Spells.Astral.ShootingStar.ShootingStar;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

public class ShootingStarSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "shooting_star");

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation(this.getDamage(spellLevel, caster), 2)}));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(HnSSchoolRegistry.RADIANCE_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(2)
            .build();

    public ShootingStarSpell() {
        this.manaCostPerLevel = 3;
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 40;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.STAR_CAST_1.get());
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        Utils.preCastTargetHelper(level, entity, playerMagicData, this, 32, 0.35F, false);
        return true;
    }

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {

        Vec3 targetPos = null;

        ICastData castData = playerMagicData.getAdditionalCastData();
        if (castData instanceof TargetEntityCastData targetData && level instanceof ServerLevel serverLevel) {
            targetPos = targetData.getTargetPosition(serverLevel);
        }
        if (targetPos == null) {
            HitResult raycast = Utils.raycastForEntity(level, entity, 45.0F, true);

            if (raycast.getType() == HitResult.Type.ENTITY) {
                targetPos = ((EntityHitResult) raycast).getEntity().position();
            } else {
                targetPos = Utils.moveToRelativeGroundLevel(level, raycast.getLocation(), 5);
            }
        }
        if (targetPos == null) return;
        for (int i = 0; i < 2; i++) {
            double offsetX = (entity.getRandom().nextDouble() - 0.5D) * 5.0D;
            double offsetZ = (entity.getRandom().nextDouble() - 0.5D) * 5.0D;

            Vec3 spawnPos = targetPos.add(offsetX, 8.0D, offsetZ);
            Vec3 trajectory = targetPos.subtract(spawnPos).normalize();

            ShootingStar star = new ShootingStar(level, entity);
            star.setPos(spawnPos);
            star.shoot(trajectory);
            star.setDamage(this.getDamage(spellLevel, entity));

            level.addFreshEntity(star);
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.5F;
    }
}
