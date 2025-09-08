package net.hazen.hazennstuff.item.weapons.FrostburnDagger;

import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.weapons.HNSExtendedWeaponsTiers;
import net.hazen.hazennstuff.item.weapons.ice_pike.IcePikeRenderer;
import net.hazen.hazennstuff.rarity.CryogenicRarity;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Map;
import java.util.function.Consumer;

public class FrostburnDaggerItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public FrostburnDaggerItem() {
        super(
                HNSExtendedWeaponsTiers.ICE_PIKE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.ICE_PIKE)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.ICE_SPIKES_SPELL, 8)
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
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        super.initializeSpellContainer(itemStack);
        itemStack.set(ComponentRegistry.AFFINITY_COMPONENT, new AffinityData(Map.of(
                SpellRegistry.ICE_SPIKES_SPELL.get().getSpellResource(), 1
        )));
    }
}
