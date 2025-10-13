package net.hazen.hazennstuff.item.weapons.Meowmere;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.weapons.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.rarity.RadianceRarity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class MeowmereItem extends ExtendedSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public MeowmereItem() {
        super(
                HnSExtendedWeaponsTiers.MEOWMERE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(RadianceRarity.RADIANCE_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.MEOWMERE)
                        )
        );
    }

    @Override
    public Component getName(ItemStack stack) {
        String baseName = super.getName(stack).getString();

        MutableComponent rainbowName = Component.literal("");

        Minecraft mc = Minecraft.getInstance();
        long ticks = (mc.level != null) ? mc.level.getGameTime() : 0;

        for (int i = 0; i < baseName.length(); i++) {
            float hue = ((i * 40) + (ticks * 2.25f)) % 360 / 360f;

            int rgb = java.awt.Color.HSBtoRGB(hue, 1f, 1f);
            String hex = String.format("#%06X", (0xFFFFFF & rgb));

            TextColor color = TextColor.parseColor(hex).getOrThrow();

            rainbowName = rainbowName.append(
                    Component.literal(String.valueOf(baseName.charAt(i)))
                            .withStyle(style -> style.withColor(color))
            );
        }

        return rainbowName;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<MeowmereItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<MeowmereItem> event)
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
            private MeowmereRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new MeowmereRenderer();

                return this.renderer;
            }
        });
    }
}
