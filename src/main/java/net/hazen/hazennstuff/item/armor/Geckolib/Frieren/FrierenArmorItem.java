package net.hazen.hazennstuff.item.armor.Geckolib.Frieren;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FrierenArmorItem extends ImbuableChestplateArmorItem {
    public FrierenArmorItem(Type type, Properties settings) {
        // Add in your armor tier + additional attributes for your item
        super(ArmorMaterialRegistry.NETHERITE_BATTLEMAGE, type, settings, withManaAndSpellPowerAttribute(125, 0.05));
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new FrierenArmorModel());
    }
}