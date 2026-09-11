package net.hazen.hazennstuff.Items.Weapons.BossDrops.RavensBane;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.renderer.GeoItemRenderer;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.base.Suppliers;
import net.hazen.hazennstuff.Items.Utils.HnSToolTiers;
import net.minecraft.world.item.MaceItem;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RavensBaneItem extends MaceItem implements GeoItem {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public RavensBaneItem(Properties properties) {
        super(properties
                .sword(HnSToolTiers.ZENALITE,
                        6,
                        1.0f)
                .stacksTo(1)
        );
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
            private final Supplier<RavensBaneRenderer<?>> renderer =
                    Suppliers.memoize(RavensBaneRenderer::new);

            @Override
            public @Nullable GeoItemRenderer<RavensBaneItem> getGeoItemRenderer() {
                return this.renderer.get();
            }
        });
    }

}
