package net.hazen.hazennstuff.Items.Equipment.Weapons.TheDevourer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TheDevourerRenderer extends GeoItemRenderer<TheDevourerItem> {
    public TheDevourerRenderer(TheDevourerModel theDevourerModel) {
        super(new TheDevourerModel());
        this.addRenderLayer(new TheDevourerLayer(this));
    }
}
