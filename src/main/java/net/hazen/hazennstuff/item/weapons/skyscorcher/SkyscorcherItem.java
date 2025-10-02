package net.hazen.hazennstuff.item.weapons.skyscorcher;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.item.weapons.HNSExtendedWeaponsTiers;
import net.hazen.hazennstuff.rarity.ElectricRarity;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class SkyscorcherItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SkyscorcherItem() {
        super(
                HNSExtendedWeaponsTiers.SKYSCORCHER,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.SKYSCORCHER))
                        .component(DataComponents.TOOL, MaceItem.createToolProperties()),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.ASCENSION_SPELL, 10))
        );
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player) {
            float fallDistance = player.fallDistance;

            boolean isSmash = fallDistance > 0.0F
                    && !player.onGround()
                    && !player.isInWater()
                    && !player.isInLava();

            if (isSmash) {
                // Calculate fall-based bonus damage (cap at 12)
                float bonusDamage = Math.min(12.0F, fallDistance * 1.2F);

                // Deal extra damage on top of base weapon damage
                target.hurt(target.damageSources().playerAttack(player), bonusDamage);

                // Apply directional knockback based on fall
                Vec3 direction = target.position().subtract(player.position()).normalize();
                double knockbackStrength = Math.min(1.5, fallDistance / 10.0);
                target.push(direction.x * knockbackStrength, 0.4 + (fallDistance / 15.0), direction.z * knockbackStrength);

                // Play smash sound
                player.level().playSound(null, target.blockPosition(), SoundEvents.TRIDENT_THUNDER.value(), SoundSource.PLAYERS, 1.0F, 1.0F);

                // Spawn impact particles
                Vec3 pos = target.getBoundingBox().getCenter();
                MagicManager.spawnParticles(player.level(), ParticleHelper.ELECTRIC_SPARKS, pos.x, pos.y, pos.z, 12, 0.08, 0.08, 0.08, 0.3, false);

                // Don’t consume durability on smash
                return true;
            }
        }

        // Normal hit behavior + durability
        return super.hurtEnemy(stack, target, attacker);
    }





    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<SkyscorcherItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<SkyscorcherItem> event)
    {
        event.getController().setAnimation(IDLE_ANIMATION);

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // Your renderer for items
    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private SkyscorcherRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new SkyscorcherRenderer();

                return this.renderer;
            }
        });
    }
}
