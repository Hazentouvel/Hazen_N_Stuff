package net.hazen.hazennstuff.Items.Equipment.ArmorSets.ThunderProwler;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ThunderProwlerArmorItem extends HnSImbuableArmorItem {
    public ThunderProwlerArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.ELECTROMANCER, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new ThunderProwlerArmorModel());
    }
}