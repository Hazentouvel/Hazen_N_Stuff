package net.hazen.hazennstuff.Items.Equipment.Weapons.DragonSplitter;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DraconicSplitterRenderer extends GeoItemRenderer<DraconicSplitterItem> {
    public DraconicSplitterRenderer(DraconicSplitterModel draconicSplitterModel) {
        super(new DraconicSplitterModel());
        this.addRenderLayer(new DraconicSplitterLayer(this));
    }
}
