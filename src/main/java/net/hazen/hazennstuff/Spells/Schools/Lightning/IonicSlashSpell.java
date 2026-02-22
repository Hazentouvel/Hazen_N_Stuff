package net.hazen.hazennstuff.Spells.Schools.Lightning;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.magic.SpellSelectionManager;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellAnimations;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import java.util.List;
import java.util.Optional;

import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.IonicSLash.IonicSlashOptions;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazennstuff.Spells.AbstractSpells.AbstractTaggedSpell;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class IonicSlashSpell extends AbstractTaggedSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "ionic_slash");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{this.getDamageText(spellLevel, caster)}));
    }

    public IonicSlashSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.RARE)
                .setSchoolResource(SchoolRegistry.LIGHTNING_RESOURCE)
                .setMaxLevel(5)
                .setCooldownSeconds((double)14.0F)
                .build();
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 2;
        this.castTime = 10;
        this.baseManaCost = 30;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of((SoundEvent)SoundRegistry.SHOCKWAVE_PREPARE.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of((SoundEvent) SoundRegistry.SHOCKWAVE_CAST.get());
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

    public int getEffectiveCastTime(int spellLevel, @Nullable LivingEntity entity) {
        return this.getCastTime(spellLevel);
    }

    public AnimationHolder getCastStartAnimation() {

        if (hasIonicSplitterDormant) {
            return SpellAnimations.THROW_SINGLE_ITEM;
        } else {
            return SpellAnimations.ONE_HANDED_HORIZONTAL_SWING_ANIMATION;
        }

    }

    private boolean hasIonicSplitterDormant;
    private boolean hasIonicSplitter;
    //private boolean hasLightningSpellbook;
    //private boolean hasLightningSheath;

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {

        boolean hasDormantMainhand = entity.getMainHandItem().is(HnSItemRegistry.IONIC_SPLITTER_DORMANT.get());
        boolean hasDormantOffhand = entity.getOffhandItem().is(HnSItemRegistry.IONIC_SPLITTER_DORMANT.get());
        hasIonicSplitterDormant = hasDormantMainhand || hasDormantOffhand;

        if (hasIonicSplitterDormant) {
            if (entity instanceof ServerPlayer serverPlayer && !serverPlayer.level().isClientSide()) {
                ItemStack t1Stack = new ItemStack(HnSItemRegistry.IONIC_SPLITTER_T1.get());
                if (hasDormantMainhand) {
                    serverPlayer.getInventory().setItem(serverPlayer.getInventory().selected, t1Stack);
                } else {
                    serverPlayer.setItemInHand(InteractionHand.OFF_HAND, t1Stack);
                }

                serverPlayer.level().playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), SoundEvents.TRIDENT_THUNDER, SoundSource.NEUTRAL, 0.5F, 1.3F);
                serverPlayer.displayClientMessage(Component.translatable("item.hazennstuff.ionic_splitter_ignition.description"), true);
            }
        } else {
            this.slash(level, spellLevel, entity, playerMagicData);
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }


    public void slash (Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {

        boolean hasIonicSplitter = hasTaggedItem(entity, HnSTags.IONIC_SPLITTER);
        hasIonicSplitter = hasTaggedItem(entity, HnSTags.IONIC_SPLITTER);

        float radius = 3.25F;
        float distance = 1.9F;
        Vec3 forward = entity.getForward();
        Vec3 hitLocation = entity.position().add((double)0.0F, (double)(entity.getBbHeight() * 0.3F), (double)0.0F).add(forward.scale((double)distance));
        List<Entity> entities = level.getEntities(entity, AABB.ofSize(hitLocation, (double)(radius * 2.0F), (double)radius, (double)(radius * 2.0F)));
        SpellDamageSource damageSource = this.getDamageSource(entity);

        for(Entity targetEntity : entities) {
            if (targetEntity instanceof LivingEntity targetLiving && targetEntity.isAlive() && entity.isPickable() && targetEntity.position().subtract(entity.getEyePosition()).dot(forward) >= (double)0.0F && entity.distanceToSqr(targetEntity) < (double)(radius * radius) && Utils.hasLineOfSight(level, entity.getEyePosition(), targetEntity.getBoundingBox().getCenter(), true)) {
                Vec3 offsetVector = targetEntity.getBoundingBox().getCenter().subtract(entity.getEyePosition());
                if (offsetVector.dot(forward) >= (double)0.0F && DamageSources.applyDamage(targetEntity, this.getDamage(spellLevel, entity), damageSource)) {
                    MagicManager.spawnParticles(level, ParticleHelper.ELECTRIC_SPARKS, targetEntity.getX(), targetEntity.getY() + (double)(targetEntity.getBbHeight() * 0.5F), targetEntity.getZ(), 30, (double)(targetEntity.getBbWidth() * 0.5F), (double)(targetEntity.getBbHeight() * 0.5F), (double)(targetEntity.getBbWidth() * 0.5F), 0.03, false);
                    EnchantmentHelper.doPostAttackEffects((ServerLevel)level, targetEntity, damageSource);

                    // If caster has Ionic Splitter, inflict ELECTROCUTED on the hit target
                    if (hasIonicSplitter && !level.isClientSide) {
                        targetLiving.addEffect(new MobEffectInstance(HnSEffects.ELECTROCUTED, 100, 1));
                    }
                }
            }
        }

        boolean mirrored = playerMagicData.getCastingEquipmentSlot().equals(SpellSelectionManager.OFFHAND);
        MagicManager.spawnParticles(level, new IonicSlashOptions((float)forward.x, (float)forward.y, (float)forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y + 0.3, hitLocation.z, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F, true);
    }

    public SpellDamageSource getDamageSource(Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) + this.getAdditionalDamage(entity);
    }

    private float getAdditionalDamage(LivingEntity entity) {
        if (entity == null) {
            return 0.0F;
        } else {
            float weaponDamage = Utils.getWeaponDamage(entity);

            //ItemStack weaponItem = entity.getWeaponItem();
//            if (!weaponItem.isEmpty() && weaponItem.has(DataComponents.ENCHANTMENTS)) {
//                weaponDamage += (float)Utils.getEnchantmentLevel(entity.level, Enchantments.FIRE_ASPECT, (ItemEnchantments)weaponItem.get(DataComponents.ENCHANTMENTS));
//            }

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

    public AnimationHolder getCastFinishAnimation() {
        return AnimationHolder.pass();
    }
}
