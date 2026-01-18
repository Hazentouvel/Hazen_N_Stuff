package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Seraph;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SeraphArmorItem extends HnSImbuableArmorItem {
    public SeraphArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.HOLYMANCER, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new SeraphArmorRenderer(new SeraphArmorModel());
    }
}