package net.hazen.hazennstuff.item.util.spectral_pickaxe;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.weapons.HNSExtendedWeaponsTiers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class SpectralPickaxeItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SpectralPickaxeItem() {
        super(
                HNSExtendedWeaponsTiers.SPECTRAL_PICKAXE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(Rarity.EPIC)
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.DIVINE_GREATSWORD))
                        .component(DataComponents.TOOL, Tiers.NETHERITE.createToolProperties(BlockTags.MINEABLE_WITH_PICKAXE)),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.SPECTRAL_HAMMER_SPELL, 5))

        );
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return HNSExtendedWeaponsTiers.MITHRIL.getSpeed();
        }
        return 1.0F;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<SpectralPickaxeItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<SpectralPickaxeItem> event)
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
            private SpectralPickaxeRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new SpectralPickaxeRenderer();

                return this.renderer;
            }
        });
    }
}
