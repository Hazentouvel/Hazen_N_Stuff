package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.PyriumBattlemage;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PyriumBattlemageArmorItem extends HnSImbuableArmorItem {
    public PyriumBattlemageArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.PYRIUM_BATTLEMAGE, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new PyriumBattlemageArmorModel());
    }
}