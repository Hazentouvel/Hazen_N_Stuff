package net.hazen.hazennstuff.Item.UpgradeOrbs.Concentrated.Fire;

import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.hazen.hazennstuff.Registries.HnSUpgradeOrbTypeRegistry;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class ConcentratedFireUpgradeOrb extends UpgradeOrbItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ConcentratedFireUpgradeOrb() {
        super(
                ItemPropertiesHelper
                        .material()
                        .rarity(HnSRarities.FIRE_RARITY.getValue())
                        .component(ComponentRegistry.UPGRADE_ORB_TYPE, HnSUpgradeOrbTypeRegistry.ENHANCED_FIRE)
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<ConcentratedFireUpgradeOrb> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<ConcentratedFireUpgradeOrb> event)
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
            private ConcentratedFireUpgradeOrbRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new ConcentratedFireUpgradeOrbRenderer();

                return this.renderer;
            }
        });
    }
}
