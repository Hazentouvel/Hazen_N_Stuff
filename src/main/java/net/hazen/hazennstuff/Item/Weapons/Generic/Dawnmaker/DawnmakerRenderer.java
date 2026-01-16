package net.hazen.hazennstuff.Item.Weapons.Generic.Dawnmaker;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DawnmakerRenderer extends GeoItemRenderer<DawnmakerItem> {
    public DawnmakerRenderer() {
        super(new DawnmakerModel());
    }
}
