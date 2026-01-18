package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.EnderDragon;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EnderDragonArmorItem extends HnSImbuableArmorItem {
    public EnderDragonArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.ENDERMANCER, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new EnderDragonArmorRenderer(new EnderDragonArmorModel());
    }
}