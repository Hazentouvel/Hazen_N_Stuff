package net.hazen.hazennstuff.Item.Armor.Cosmetic.SchoolTier.MyceliumGuardian;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import net.hazen.hazennstuff.HnSUtilities.Armor.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSArmorMaterials;
import net.hazen.hazentouvelib.Registries.HLAttributeRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MyceliumGuardianArmorItem extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat {
    public MyceliumGuardianArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.PURE_ARMOR_TIER_MATERIAL, type, settings, schoolTierDual(
                HLAttributeRegistry.RADIANCE_SPELL_POWER,
                AttributeRegistry.NATURE_SPELL_POWER
        ));
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new MyceliumGuardianArmorModel());
    }
}