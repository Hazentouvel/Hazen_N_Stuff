package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.CreakingSorcerer;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CreakingSorcererArmorItem extends HnSImbuableArmorItem {
    public CreakingSorcererArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.BOTAMANCER, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new CreakingSorcererArmorRenderer(new CreakingSorcererArmorModel());
    }
}