package net.hazen.hazennstuff.Spells.Schools.Fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.Entity.Spells.Fire.FireDaggers.FieryDaggerMagicProjectile;
import net.hazen.hazennstuff.Animations.HnSSpellAnimations;
import net.hazen.hazennstuff.Spells.AbstractSpells.AbstractTaggedSpell;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.List;

public class FieryDaggerSpell extends AbstractTaggedSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "fiery_dagger");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));
    }

    public boolean allowLooting() {
        return false;
    }

    public FieryDaggerSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.LEGENDARY)
                .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
                .setMaxLevel(5)
                .setCooldownSeconds(16.0F)
                .setAllowCrafting(false)
                .build();
        this.manaCostPerLevel = 8;
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 24;
    }

    public CastType getCastType() {
            return CastType.INSTANT;
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        if (hasCinderous)
            return HnSSpellAnimations.FIERY_DAGGER_CAST;
        else
            return HnSSpellAnimations.FIERY_DAGGER_SUMMON;
    }


    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    private boolean hasCinderous;

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (world.isClientSide) return;

        Vec3 look = entity.getLookAngle();

        boolean hasCinderousEquipment = hasTaggedItem(entity, HnSTags.CINDEROUS_EQUIPMENT);
        hasCinderous = hasTaggedItem(entity, HnSTags.CINDEROUS_EQUIPMENT);


        if (hasCinderousEquipment) {
            // Fiery Zone with Cinderous Equipment
            float explosionRadius = 1.0F + spellLevel * 0.5F;
            int[] angles = {0, -15, 15};
            for (int angle : angles) {
                FieryDaggerMagicProjectile dagger = new FieryDaggerMagicProjectile(world);
                dagger.setOwner(entity);
                dagger.setDamage(this.getDamage(spellLevel, entity));
                dagger.setExplosionRadius(explosionRadius);
                dagger.setPos(entity.position().add(0.0, entity.getEyeHeight() - dagger.getBbHeight() * 0.5, 0.0));

                Vec3 dir = look.yRot((float) Math.toRadians(angle));
                dagger.shoot(dir.x, dir.y, dir.z, 1.25F, 0.0F);

                dagger.setNoGravity(false);
                world.addFreshEntity(dagger);
            }
        } else {
            // Generic Casting
            int count = 8;
            double arcAngle = Math.toRadians(120);
            double radius = 1.6;
            double height = 1.2;
            int baseDelay = 10;
            int delayBetween = 2;

            Vec3 forward = entity.getLookAngle().normalize();
            Vec3 up = new Vec3(0, 1, 0);
            Vec3 right = forward.cross(up).normalize();
            up = right.cross(forward).normalize();

            Vec3 arcCenter = entity.position()
                    .add(0, entity.getEyeHeight() + height, 0)
                    .add(forward.scale(0.5));

            for (int i = 0; i < count; i++) {
                double t = (double) i / (count - 1);
                double angle = -arcAngle / 2 + t * arcAngle;

                Vec3 offset = right.scale(Math.sin(angle) * radius)
                        .add(up.scale(Math.cos(angle) * radius * 0.7));

                Vec3 spawnPos = arcCenter.add(offset);

                FieryDaggerMagicProjectile dagger = new FieryDaggerMagicProjectile(world);
                dagger.setOwner(entity);
                dagger.setDamage(this.getDamage(spellLevel, entity));
                dagger.setExplosionRadius(0f);
                dagger.setPos(spawnPos);

//                // Make dagger visually face the caster's current direction
//                dagger.setYRot(entity.getYRot());
//                dagger.setXRot(entity.getXRot());
//                dagger.yRotO = entity.getYRot();
//                dagger.xRotO = entity.getXRot();

                dagger.launchDir = null;
                dagger.ownerTrack = spawnPos.subtract(entity.position());
                dagger.setDeltaMovement(0, 0, 0);
                dagger.delay = baseDelay + i * delayBetween;

                world.addFreshEntity(dagger);
            }
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


//    private boolean hasTaggedItem(LivingEntity entity, net.minecraft.tags.TagKey<net.minecraft.world.item.Item> tag) {
//        if (entity.getMainHandItem().is(tag) || entity.getOffhandItem().is(tag))
//            return true;
//
//        for (ItemStack armor : entity.getArmorSlots()) {
//            if (armor.is(tag))
//                return true;
//        }
//
//        boolean hasCurio = CuriosApi.getCuriosInventory(entity)
//                .map(curios -> !curios.findCurios(item -> item != null && item.is(tag)).isEmpty())
//                .orElse(false);
//
//        return hasCurio;
//    }

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setFireTicks(60);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.5F;
    }
}
