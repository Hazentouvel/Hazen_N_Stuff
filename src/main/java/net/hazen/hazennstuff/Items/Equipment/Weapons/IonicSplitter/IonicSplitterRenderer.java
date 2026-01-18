package net.hazen.hazennstuff.Items.Equipment.Weapons.IonicSplitter;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class IonicSplitterRenderer extends GeoItemRenderer<IonicSplitterItem> {
    public IonicSplitterRenderer(IonicSplitterModel ionicSplitterModel) {
        super(new IonicSplitterModel());
        this.addRenderLayer(new IonicSplitterLayer(this));
    }
}
