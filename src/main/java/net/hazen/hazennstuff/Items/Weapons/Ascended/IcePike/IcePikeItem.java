package net.hazen.hazennstuff.Items.Weapons.Ascended.IcePike;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.animation.RawAnimation;
import com.geckolib.animation.object.PlayState;
import com.geckolib.util.GeckoLibUtil;
import net.hazen.hazennstuff.HLUtils.Items.HnSExtendedWeaponsTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import java.util.function.Consumer;

public class IcePikeItem extends Item implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public IcePikeItem() {
        super(
                HnSExtendedWeaponsTiers.ICE_PIKE,
                Item.Properties
                        .equipment(1)
                        .fireResistant()
                        .rarity(Rarity.EPIC)
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.ICE_PIKE))
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<IcePikeItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<IcePikeItem> event)
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
            private IcePikeRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new IcePikeRenderer();

                return this.renderer;
            }
        });
    }
}
