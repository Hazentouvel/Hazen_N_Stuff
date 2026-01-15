package net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FireblossomBattlemageArmorItem extends HnSImbuableArmorItem {
    public FireblossomBattlemageArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.FIREBLOSSOM, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new FireblossomBattlemageArmorRenderer(new FireblossomBattlemageArmorModel());
    }
}