package net.hazen.hazennstuff.Spells.Schools.Cosmic;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import net.hazen.hazennstuff.Entity.Spells.Cosmic.ShootingStar.ShootingStar;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.hazen.hazentouvelib.Registries.HLSchoolRegistry;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShootingStarSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "shooting_star");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        var li = new ArrayList<>(super.getUniqueInfo(spellLevel, caster));


        li.addFirst(Component.literal("\u2999 - Hazen 'n Stuff - \u2999")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.BOLD)
        );

        li.add(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));

        return li;
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(HLSchoolRegistry.COSMIC_RESOURCE)
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

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.STAR_CAST_1.get());
    }

    public CastType getCastType() {
        return CastType.INSTANT;
    }

    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

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

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setIFrames(0);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.4F;
    }
}
