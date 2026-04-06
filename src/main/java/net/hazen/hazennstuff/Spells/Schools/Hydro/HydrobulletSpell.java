package net.hazen.hazennstuff.Spells.Schools.Hydro;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.acetheeldritchking.aces_spell_utils.registries.ASSchoolRegistry;
import net.hazen.hazennstuff.Entity.Spells.Hydro.Hydrobullet.HydroBullet;
import net.hazen.hazennstuff.Spells.AbstractSpells.AbstractHydroSpell;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.List;

public class HydrobulletSpell extends AbstractHydroSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "hydrobullet");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));
    }

    public HydrobulletSpell() {
        this.defaultConfig = (
                new DefaultConfig())
                .setMinRarity(SpellRarity.UNCOMMON)
                .setSchoolResource(ASSchoolRegistry.HYDRO_RESOURCE)
                .setMaxLevel(10)
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
        HydroBullet hydrobullet = new HydroBullet(world, entity);
        hydrobullet.setPos(entity.position().add((double)0.0F, (double)entity.getEyeHeight() - hydrobullet.getBoundingBox().getYsize() * (double)0.5F, (double)0.0F));
        hydrobullet.shoot(entity.getLookAngle());
        hydrobullet.setDamage(this.getDamage(spellLevel, entity));
        world.addFreshEntity(hydrobullet);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.6F;
    }
}
