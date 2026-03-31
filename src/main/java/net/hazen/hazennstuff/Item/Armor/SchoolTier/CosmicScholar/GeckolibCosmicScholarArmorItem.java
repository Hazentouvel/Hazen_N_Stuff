package net.hazen.hazennstuff.Item.Armor.SchoolTier.CosmicScholar;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.hazen.hazennstuff.Item.HnSUtilities.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import static io.redspace.ironsspellbooks.item.armor.ExtendedArmorItem.schoolAttributes;

public class GeckolibCosmicScholarArmorItem extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat {
    public GeckolibCosmicScholarArmorItem(Type type, Properties settings) {
        super(ArmorMaterialRegistry.SCHOOL, type, settings, schoolAttributes(
                HnSAttributeRegistry.COSMIC_SPELL_POWER
        ));
    }
    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new GeckolibCosmicScholarArmorModel());
    }
}