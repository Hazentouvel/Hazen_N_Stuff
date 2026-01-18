package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Blazeborne;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BlazeborneArmorItem extends HnSImbuableArmorItem {
    public BlazeborneArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.PYROMANCER, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new BlazeborneArmorRenderer(new BlazeborneArmorModel());
    }
}