package net.hazen.hazennstuff.Item.Weapons.Generic.Muramasa;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MuramasaRenderer extends GeoItemRenderer<MuramasaItem> {
    public MuramasaRenderer() {
        super(new MuramasaModel());
    }
}
