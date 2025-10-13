package net.hazen.hazennstuff.item.weapons.BladeOfGrass;

import net.hazen.hazennstuff.item.weapons.Muramasa.MuramasaItem;
import net.hazen.hazennstuff.item.weapons.Muramasa.MuramasaModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BladeOfGrassRenderer extends GeoItemRenderer<BladeOfGrassItem> {
    public BladeOfGrassRenderer() {
        super(new BladeOfGrassModel());
    }
}
