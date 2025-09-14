package net.hazen.hazennstuff.item.staves.rod_of_discord;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.staves.HnSStaffTier;
import net.hazen.hazennstuff.item.staves.ImbuableStaffItem;
import net.hazen.hazennstuff.rarity.EnderRarity;
import net.hazen.hazennstuff.registries.HnSSpellRegistries;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class RodOfDiscordItem extends ImbuableStaffItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public RodOfDiscordItem() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSStaffTier.ROD_OF_DISCORD)),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(HnSSpellRegistries.CHAOTIC_TELEPORT, 6)
        ));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<RodOfDiscordItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<RodOfDiscordItem> event)
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
            private RodOfDiscordRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new RodOfDiscordRenderer();

                return this.renderer;
            }
        });
    }
}
