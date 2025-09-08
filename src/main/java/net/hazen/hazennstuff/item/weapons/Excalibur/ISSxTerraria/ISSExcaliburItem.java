package net.hazen.hazennstuff.item.weapons.Excalibur.ISSxTerraria;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.weapons.Excalibur.Terraria.ExcaliburRenderer;
import net.hazen.hazennstuff.item.weapons.HNSExtendedWeaponsTiers;
import net.hazen.hazennstuff.rarity.DivineRarity;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class ISSExcaliburItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ISSExcaliburItem() {
        super(
                HNSExtendedWeaponsTiers.DIVINE_GREATSWORD,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.DIVINE_GREATSWORD)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.DIVINE_SMITE_SPELL, 8)
                )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<ISSExcaliburItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<ISSExcaliburItem> event)
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
            private ISSExcaliburRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new ISSExcaliburRenderer();

                return this.renderer;
            }
        });
    }
}
