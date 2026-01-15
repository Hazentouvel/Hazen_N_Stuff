package net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Crown;

import net.hazen.hazennstuff.Items.Extensions.HnSArmorMaterial;
import net.hazen.hazennstuff.Items.Extensions.HnSImbuableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FireblossomBattlemageCrownArmorItem extends HnSImbuableArmorItem {
    public FireblossomBattlemageCrownArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterial.FIREBLOSSOM_CROWN, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new FireblossomBattlemageCrownArmorRenderer(new FireblossomBattlemageCrownArmorModel());
    }
}