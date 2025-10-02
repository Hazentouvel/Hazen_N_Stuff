package net.hazen.hazennstuff.item.util.PickaxeAxe.DivineGold;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.util.PickaxeAxe.PickaxeAxeRenderer;
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

public class PickaxeAxeDivineGoldItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PickaxeAxeDivineGoldItem() {
        super(
                HNSExtendedWeaponsTiers.PICKAXE_AXE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(Rarity.EPIC)
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.PICKAXE_AXE))
                        .component(DataComponents.TOOL, Tiers.NETHERITE.createToolProperties(BlockTags.MINEABLE_WITH_PICKAXE)),
                SpellDataRegistryHolder.of(
                )

        );
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_AXE);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return HNSExtendedWeaponsTiers.MITHRIL.getSpeed();
        }
        else if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
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

    private final AnimationController<PickaxeAxeDivineGoldItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<PickaxeAxeDivineGoldItem> event)
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
            private PickaxeAxeDivineGoldRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new PickaxeAxeDivineGoldRenderer();

                return this.renderer;
            }
        });
    }
}
