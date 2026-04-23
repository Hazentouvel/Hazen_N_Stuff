package net.hazen.hazennstuff.Spells.Schools.Blood;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.DamageSources;
import net.hazen.hazennstuff.HnSUtilities.Animations.HnSSpellAnimations;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshChunk;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshPiece.FleshPiece;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSDamageTypes;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ViolentRegurgitationSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "violent_regurgitation");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        var li = new ArrayList<>(super.getUniqueInfo(spellLevel, caster));


        li.addFirst(Component.literal("\u2999 - Hazen 'n Stuff - \u2999")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.BOLD)
        );

        li.addAll(List.of(
                Component.translatable("ui.irons_spellbooks.damage",
                        new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}
                ),
                Component.translatable("attribute.modifier.plus.1",
                        Utils.stringTruncation(this.getHealthLoss(), 0),
                        Component.translatable("attribute.hazennstuff.health_loss")
                ),

                Component.translatable("attribute.hazennstuff.hunger_loss", getHungerLoss(spellLevel))
        ));

        return li;
    }

    public boolean allowLooting() {
        return false;
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.BLOOD_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(25)
            .build();

    public ViolentRegurgitationSpell() {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 1;
        this.spellPowerPerLevel = 1;
        this.castTime = 50;
        this.baseManaCost = 60;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return HnSSpellAnimations.VIOLENT_REGURGITATION_CHARGING;
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return HnSSpellAnimations.VIOLENT_REGURGITATION_CAST;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.VIOLENT_REGURGITATION_CHARGING.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.VIOLENT_REGURGITATION_CAST.get());
    }


    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vec3 origin = entity.getEyePosition();
        int hungerCost = Math.min(3, Math.max(8, spellLevel));

        if (!world.isClientSide) {
            float currentHealth = entity.getHealth();
            float healthCost = currentHealth * 0.4f;
            DamageSource damageSource = new DamageSource(DamageSources.getHolderFromResource(entity, HnSDamageTypes.CORRUPT_MAGIC));
            entity.hurt(damageSource, healthCost);

            if (entity instanceof net.minecraft.world.entity.player.Player player) {
                int currentFood = player.getFoodData().getFoodLevel();
                int newFood = Math.max(0, currentFood - hungerCost);
                player.getFoodData().setFoodLevel(newFood);
            }
        }

        FleshChunk fleshChunk = new FleshChunk(world, entity);

        fleshChunk.setDamage(getDamage(spellLevel, entity));
        fleshChunk.setSourceSpellLevel(spellLevel);

        fleshChunk.setPos(origin.add(entity.getForward()).subtract(0, fleshChunk.getBbHeight() / 2, 0));
        fleshChunk.shoot(entity.getLookAngle());

        if (!world.isClientSide) {
            world.addFreshEntity(fleshChunk);
        }

        int pieces = 4 + Utils.random.nextInt(8);
        double forwardOffset = 0.5D;
        double spawnRadius = 0.8D;
        double spread = 0.6D;

        for (int i = 0; i < pieces; i++) {
            FleshPiece piece = new FleshPiece(world, entity);
            piece.setDamage(getDamage(spellLevel, entity));

            Vec3 base = origin.add(entity.getForward().scale(forwardOffset));
            Vec3 rand = Utils.getRandomVec3(spawnRadius);
            Vec3 spawnPos = base.add(rand);
            piece.setPos(spawnPos);

            Vec3 dir = entity.getLookAngle().add(Utils.getRandomVec3(spread)).normalize();
            piece.shoot(dir);

            if (!world.isClientSide) {
                world.addFreshEntity(piece);
            }
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5.0F + 5.0F * this.getSpellPower(spellLevel, caster);
    }

    public float getHealthLoss() {
        return -40f;
    }

    public int getHungerLoss(int spellLevel) {
        return Math.min(8, Math.max(3, spellLevel));
    }
}
