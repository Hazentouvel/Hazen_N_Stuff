package net.hazen.hazennstuff.Items.Weapons.Special.Skyscorcher;


public class SkyscorcherRenderer extends GeoItemRenderer<SkyscorcherItem> {
    public SkyscorcherRenderer() {
        super(new SkyscorcherModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
