package net.hazen.hazennstuff.Spells.Schools.Shadow;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;

import java.util.List;

import net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowReaver.ShadowReaver;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ShadowReaverSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "shadow_reaver");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));
    }

    public ShadowReaverSpell() {
        this.defaultConfig = (
                new DefaultConfig())
                .setMinRarity(SpellRarity.EPIC)
                .setSchoolResource(HnSSchoolRegistry.SHADOW_RESOURCE)
                .setMaxLevel(6)
                .setCooldownSeconds((double)2.5F)
                .build();
        this.manaCostPerLevel = 2;
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 10;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public CastType getCastType() {
        return CastType.INSTANT;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        ShadowReaver shadowReaver = new ShadowReaver(world, entity);
        shadowReaver.setPos(entity.position().add((double)0.0F, (double)entity.getEyeHeight() - shadowReaver.getBoundingBox().getYsize() * (double)0.5F, (double)0.0F));
        shadowReaver.shoot(entity.getLookAngle());
        shadowReaver.setDamage(this.getDamage(spellLevel, entity));
        world.addFreshEntity(shadowReaver);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.5F;
    }
}
