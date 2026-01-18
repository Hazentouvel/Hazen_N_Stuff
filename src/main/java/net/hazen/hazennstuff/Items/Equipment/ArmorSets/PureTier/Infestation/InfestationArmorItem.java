package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Infestation;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class InfestationArmorItem extends HnSImbuableArmorItem {
    public InfestationArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.ELDRITCHMANCER, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new InfestationArmorRenderer(new InfestationArmorModel());
    }
}