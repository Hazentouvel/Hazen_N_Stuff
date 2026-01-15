package net.hazen.hazennstuff.Items.Equipment.Staves.DivineScepter;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DivineScepterRenderer extends GeoItemRenderer<DivineScepter> {
    public DivineScepterRenderer(DivineScepterModel divineScepterModel) {
        super(new DivineScepterModel());
        this.addRenderLayer(new DivineScepterLayer(this));
    }
}
