package net.hazen.hazennstuff.Spells.Schools.Shadow;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Club.Club;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Diamond.Diamond;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Heart.Heart;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Spade.Spade;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArcaneCardsSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "arcane_cards");
    private final DefaultConfig defaultConfig;

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

    public ArcaneCardsSpell() {
        this.defaultConfig = (
                new DefaultConfig())
                .setMinRarity(SpellRarity.UNCOMMON)
                .setSchoolResource(HnSSchoolRegistry.SHADOW_RESOURCE)
                .setMaxLevel(10)
                .setCooldownSeconds((double)2.5F)
                .build();
        this.manaCostPerLevel = 4;
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 15;
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

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.ARCANE_CARD_CAST.get());
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        final int maxLevel = 10;
        final int extraMax = 2;
        int extra = Math.round((float)(Math.max(1, Math.min(spellLevel, maxLevel)) - 1) * extraMax / (float)(maxLevel - 1));
        int cardCount = 3 + extra * 2;

        // Spread configuration
        float totalSpread = 30f;
        float step = cardCount > 1 ? totalSpread / (cardCount - 1) : 0f;
        float startAngle = -totalSpread / 2f;

        Vec3 look = entity.getLookAngle();

        for (int i = 0; i < cardCount; i++) {
            float angleOffset = startAngle + (step * i);
            Vec3 spreadLook = look.yRot(angleOffset * Mth.DEG_TO_RAD);

            int pick = Utils.random.nextInt(4);
            AbstractMagicProjectile card;
            switch (pick) {
                case 1:
                    card = new Club(world, entity);
                    break;
                case 2:
                    card = new Diamond(world, entity);
                    break;
                case 3:
                    card = new Heart(world, entity);
                    break;
                default:
                    card = new Spade(world, entity);
                    break;
            }

            // Set position, direction and damage
            card.setPos(entity.position().add(0.0, entity.getEyeHeight() - card.getBoundingBox().getYsize() * 0.5, 0.0));
            card.shoot(spreadLook);
            card.setDamage(this.getDamage(spellLevel, entity));
            world.addFreshEntity(card);
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker)
                .setIFrames(0)
                ;
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.5F;
    }
}
