package net.hazen.hazennstuff.Item.Staves.CoraliteCane;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSStaffTier;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class CoraliteCane extends StaffItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public CoraliteCane() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(HnSRarities.NATURE_RARITY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(HnSStaffTier.CORALITE_CANE)
                        )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<CoraliteCane> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<CoraliteCane> event)
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
            private CoraliteCaneRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new CoraliteCaneRenderer();

                return this.renderer;
            }
        });
    }
}
