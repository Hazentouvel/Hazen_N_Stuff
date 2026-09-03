package net.hazen.hazennstuff.Item.Weapons.Special.FrostburnDagger;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.spells.SpellAnimations;
import io.redspace.ironsspellbooks.render.animation.AnimationHelper;
import net.hazen.hazennstuff.Entity.Projectiles.FrostburnDagger.FrostburnDaggerProjectile;
import net.hazen.hazennstuff.HnSUtilities.Item.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazentouvelib.Rarities.HLRarities;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class FrostburnDaggerItem extends ExtendedSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public FrostburnDaggerItem() {
        super(
                HnSExtendedWeaponsTiers.FROSTBURN_DAGGER,
                new Item
                        .Properties()
                        .stacksTo(1)
                        .fireResistant()
                        .rarity(HLRarities.ICE_RARITY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.FROSTBURN_DAGGER)
                        )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<FrostburnDaggerItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<FrostburnDaggerItem> event)
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
            private FrostburnDaggerRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new FrostburnDaggerRenderer();

                return this.renderer;
            }
        });
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) {
            SpellAnimations.ANIMATION_INSTANT_CAST
                    .getForPlayer()
                    .ifPresent(animation -> AnimationHelper.animatePlayerStart(player, animation));

            return InteractionResultHolder.sidedSuccess(player
                    .getItemInHand(hand), true);
        }
        ItemStack stack = player.getItemInHand(hand);
        Vec3 look = player.getLookAngle();

        FrostburnDaggerProjectile projectile = new FrostburnDaggerProjectile(level, player);

        projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
        projectile.shoot(  look.x, look.y, look.z, 1.5f, 0);
        level.addFreshEntity(projectile);

        level.playSound(null, player.getX(), player.getY(), player.getZ(), HnSSounds.VAMPIRE_KNIFE_THROW, SoundSource.PLAYERS, 1.0f, 1.0f);

        player.getCooldowns().addCooldown(this, 40);

        return InteractionResultHolder.sidedSuccess(stack, false);
    }


}
