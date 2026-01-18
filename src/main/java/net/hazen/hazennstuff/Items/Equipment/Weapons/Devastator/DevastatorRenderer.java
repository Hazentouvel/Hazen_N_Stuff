package net.hazen.hazennstuff.Items.Equipment.Weapons.Devastator;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DevastatorRenderer extends GeoItemRenderer<DevastatorItem> {
    public DevastatorRenderer(DevastatorModel devastatorModel) {
        super(new DevastatorModel());
        this.addRenderLayer(new DevastatorLayer(this));
    }
}
