package net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FireblossomRapierRenderer extends GeoItemRenderer<FireblossomRapierItem> {
    public FireblossomRapierRenderer(FireblossomRapierModel fireblossomRapierModel) {
        super(new FireblossomRapierModel());
        this.addRenderLayer(new FireblossomRapierLayer(this));
    }
}
