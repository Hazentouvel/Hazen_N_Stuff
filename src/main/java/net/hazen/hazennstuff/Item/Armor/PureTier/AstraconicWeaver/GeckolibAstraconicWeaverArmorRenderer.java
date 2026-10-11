package net.hazen.hazennstuff.Item.Armor.PureTier.AstraconicWeaver;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.Infestation.GeckolibInfestationArmorItem;
import net.hazen.hazennstuff.Item.Armor.PureTier.Infestation.GeckolibInfestationArmorModel;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GeckolibAstraconicWeaverArmorRenderer extends GeoArmorRenderer<GeckolibAstraconicWeaverArmorItem> {

    public GeckolibAstraconicWeaverArmorRenderer(GeckolibAstraconicWeaverArmorModel astraconicWeaverArmorModel) {
        super(new GeckolibAstraconicWeaverArmorModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }


}