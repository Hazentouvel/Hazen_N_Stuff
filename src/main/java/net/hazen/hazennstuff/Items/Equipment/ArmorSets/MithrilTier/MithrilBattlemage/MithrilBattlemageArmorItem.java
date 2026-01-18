package net.hazen.hazennstuff.Items.Equipment.ArmorSets.MithrilTier.MithrilBattlemage;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MithrilBattlemageArmorItem extends HnSImbuableArmorItem {
    public MithrilBattlemageArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.MITHRIL_BATTLEMAGE, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new MithrilBattlemageArmorModel());
    }
}