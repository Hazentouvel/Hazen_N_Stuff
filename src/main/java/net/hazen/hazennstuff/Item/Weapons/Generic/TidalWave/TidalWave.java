package net.hazen.hazennstuff.Item.Weapons.Generic.TidalWave;

import io.redspace.ironsspellbooks.api.events.ModifySpellLevelEvent;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.TooltipsUtils;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TidalWave extends ExtendedSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TidalWave() {
        super(
                HnSExtendedWeaponsTiers.TIDAL_WAVE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(HnSRarities.HYDRO_RARITY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.TIDAL_WAVE)
                        )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<TidalWave> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<TidalWave> event)
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
            private TidalWaveRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new TidalWaveRenderer();

                return this.renderer;
            }
        });
    }
}
