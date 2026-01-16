package net.hazen.hazennstuff.Spells.Schools.Fire;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.*;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Entity.Mobs.Summons.ReignOfTyros.Keeper.SummonKeeper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ReignOfTyrosSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "reign_of_tyros");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.summon_count", new Object[]{3}), Component.translatable("ui.irons_spellbooks.percent_damage", new Object[]{(int)((double)100.0F + this.getDamageBonus(spellLevel, caster) * (double)100.0F)}), Component.translatable("ui.irons_spellbooks.percent_health", new Object[]{(int)((double)100.0F + this.getHealthBonus(spellLevel, caster) * (double)100.0F)}));
    }

    public ReignOfTyrosSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.RARE)
                .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
                .setMaxLevel(5)
                .setCooldownSeconds((double)150.0F)
                .build();
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 1;
        this.spellPowerPerLevel = 2;
        this.castTime = 20;
        this.baseManaCost = 80;
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

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of((SoundEvent)SoundRegistry.SUMMONED_SWORDS_CHARGE.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of((SoundEvent)SoundRegistry.SUMMONED_SWORDS_CAST.get());
    }

    public double getHealthBonus(int spellLevel, LivingEntity caster) {
        return (double)(this.getSpellPower(spellLevel, caster) - 1.0F) * 0.1;
    }

    public double getDamageBonus(int spellLevel, LivingEntity caster) {
        return (double)(this.getSpellPower(spellLevel, caster) - 1.0F) * 0.05;
    }

    public int getRecastCount(int spellLevel, @Nullable LivingEntity entity) {
        return 2;
    }

    public void onRecastFinished(ServerPlayer serverPlayer, RecastInstance recastInstance, RecastResult recastResult, ICastDataSerializable castDataSerializable) {
        if (SummonManager.recastFinishedHelper(serverPlayer, recastInstance, recastResult, castDataSerializable)) {
            super.onRecastFinished(serverPlayer, recastInstance, recastResult, castDataSerializable);
        }

    }

    public ICastDataSerializable getEmptyCastData() {
        return new SummonedEntitiesCastData();
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        PlayerRecasts recasts = playerMagicData.getPlayerRecasts();

        if (!recasts.hasRecastForSpell(this)) {
            SummonedEntitiesCastData summonedEntitiesCastData = new SummonedEntitiesCastData();
            int summonTime = 12000;

            AttributeModifier healthModifier = new AttributeModifier(
                    IronsSpellbooks.id("spell_power_health_bonus"),
                    this.getHealthBonus(spellLevel, entity),
                    Operation.ADD_MULTIPLIED_TOTAL
            );
            AttributeModifier damageModifier = new AttributeModifier(
                    IronsSpellbooks.id("spell_power_damage_bonus"),
                    this.getDamageBonus(spellLevel, entity),
                    Operation.ADD_MULTIPLIED_TOTAL
            );



            int summonCount = Math.min(spellLevel, 7);

            for (int i = 0; i < summonCount; i++) {
                SummonKeeper keeper = new SummonKeeper(world, entity);

                keeper.moveTo(entity.position()
                        .add(0.0F, 1.2, 0.0F)
                        .add(Utils.getRandomVec3(1.0F)));

                keeper.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(damageModifier);
                keeper.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(healthModifier);
                keeper.setHealth(keeper.getMaxHealth());

                SummonKeeper creature =
                        (SummonKeeper)(NeoForge.EVENT_BUS.post(
                                new SpellSummonEvent(entity, keeper, this.spellId, spellLevel))
                        ).getCreature();

                world.addFreshEntity(creature);
                SummonManager.initSummon(entity, creature, summonTime, summonedEntitiesCastData);
            }

            RecastInstance recastInstance = new RecastInstance(this.getSpellId(),
                    spellLevel, this.getRecastCount(spellLevel, entity),
                    summonTime,
                    castSource,
                    summonedEntitiesCastData
            );
            recasts.addRecast(recastInstance, playerMagicData);

        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }
}
