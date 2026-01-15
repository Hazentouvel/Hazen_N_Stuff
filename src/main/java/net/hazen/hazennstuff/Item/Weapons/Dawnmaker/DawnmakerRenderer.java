package net.hazen.hazennstuff.Item.Weapons.Dawnmaker;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DawnmakerRenderer extends GeoItemRenderer<DawnmakerItem> {
    public DawnmakerRenderer() {
        super(new DawnmakerModel());
    }
}
