package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.FleshMass;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FleshMassArmorItem extends HnSImbuableArmorItem {
    public FleshMassArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.SANGUINEMANCER, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new FleshMassArmorModel());
    }
}