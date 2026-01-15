package net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Helmet;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FireblossomBattlemageHelmetArmorItem extends HnSImbuableArmorItem {
    public FireblossomBattlemageHelmetArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.FIREBLOSSOM_HELMET, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new FireblossomBattlemageHelmetArmorRenderer(new FireblossomBattlemageHelmetArmorModel());
    }
}