package net.hazen.hazennstuff.Items.Armor.Steel.Stalwart;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.base.Suppliers;
import net.hazen.hazennstuff.Items.Armor.Steel.SteelArmorRenderer;
import net.hazen.hazennstuff.Items.Utils.HnSArmorMaterials;
import net.hazen.hazentouvelib.Utils.AdditionalArmorAttributes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.fml.common.EventBusSubscriber;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import java.util.function.Supplier;

@EventBusSubscriber
public class StalwartArmor extends Item implements GeoItem {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public StalwartArmor(Properties properties, ArmorType type) {
        super(properties
                .rarity(Rarity.UNCOMMON)
                .attributes(
                        AdditionalArmorAttributes.createAttributes(
                                HnSArmorMaterials.STALWART_ARMOR_MATERIAL,
                                type,
                                HnSArmorMaterials.STALWART_ATTRIBUTES
                        )
                )
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
            // Defer creation of our renderer then cache it so that it doesn't get instantiated too early
            private final Supplier<SteelArmorRenderer<?>> renderer = Suppliers.memoize(SteelArmorRenderer::new);

            @Nullable
            @Override
            public GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                return this.renderer.get();
            }
        });
    }
}