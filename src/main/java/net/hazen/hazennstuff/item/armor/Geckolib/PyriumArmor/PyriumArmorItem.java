package net.hazen.hazennstuff.item.armor.Geckolib.PyriumArmor;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.HnSGeckolibArmorItem;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PyriumArmorItem extends HnSGeckolibArmorItem implements IDisableJacket, IDisableHat {
    public PyriumArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.PYRIUM_MATERIAL, type, settings
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new PyriumArmorModel());
    }
}
