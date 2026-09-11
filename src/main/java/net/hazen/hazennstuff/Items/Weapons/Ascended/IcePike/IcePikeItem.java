package net.hazen.hazennstuff.Items.Weapons.Ascended.IcePike;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.renderer.GeoItemRenderer;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.base.Suppliers;
import net.hazen.hazennstuff.Items.Utils.HnSToolTiers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IcePikeItem extends MaceItem implements GeoItem {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public IcePikeItem(Properties properties) {
        super(properties
                .spear(HnSToolTiers.ZENALITE,
                        0.95f,
                        0.7f,
                        0.5f,
                        3.5f,
                        13f,
                        8.5f,
                        5.1f,
                        13.37f,
                        4.67f)
                .stacksTo(1)
        );
    }


    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide()) {
            attacker.level().playSound(
                    null,
                    target.getX(),
                    target.getY(),
                    target.getZ(),
                    SoundEvents.TRIDENT_THUNDER,
                    SoundSource.PLAYERS,
                    1.0f,
                    1.0f
            );
        }

        super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private final Supplier<IcePikeRenderer<?>> renderer =
                    Suppliers.memoize(IcePikeRenderer::new);

            @Override
            public @Nullable GeoItemRenderer<IcePikeItem> getGeoItemRenderer() {
                return this.renderer.get();
            }
        });
    }

}
