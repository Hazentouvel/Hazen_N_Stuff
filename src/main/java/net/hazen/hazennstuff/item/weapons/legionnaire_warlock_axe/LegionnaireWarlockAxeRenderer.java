package net.hazen.hazennstuff.item.weapons.legionnaire_warlock_axe;

import net.hazen.hazennstuff.item.weapons.Firebrand.FirebrandItem;
import net.hazen.hazennstuff.item.weapons.Firebrand.FirebrandModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class LegionnaireWarlockAxeRenderer extends GeoItemRenderer<LegionnaireWarlockAxeItem> {
    public LegionnaireWarlockAxeRenderer() {
        super(new LegionnaireWarlockAxeModel());
    }
}
