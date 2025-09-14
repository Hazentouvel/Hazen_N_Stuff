package net.hazen.hazennstuff.item.weapons.NightsEdge;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.weapons.HNSExtendedWeaponsTiers;
import net.hazen.hazennstuff.rarity.ShadowRarity;
import net.hazen.hazennstuff.registries.HnSSpellRegistries;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class NightsEdgeItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public NightsEdgeItem() {
        super(
                HNSExtendedWeaponsTiers.LIGHTS_BANE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.LIGHTS_BANE)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(HnSSpellRegistries.NIGHTS_EDGE_STRIKE, 6)
                )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<NightsEdgeItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<NightsEdgeItem> event)
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
            private NightsEdgeRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new NightsEdgeRenderer();

                return this.renderer;
            }
        });
    }
}
