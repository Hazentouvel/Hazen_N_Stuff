package net.hazen.hazennstuff.Item.Armor.PureTier.Infestation;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.SchoolTier.CosmicScholar.GeckolibCosmicScholarArmorItem;
import net.hazen.hazennstuff.Item.Armor.SchoolTier.CosmicScholar.GeckolibCosmicScholarArmorModel;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GeckolibInfestationArmorRenderer extends TransmogArmorRenderer<GeckolibInfestationArmorItem> {

    public GeckolibInfestationArmorRenderer(GeckolibInfestationArmorModel infestationArmorModel) {
        super(new GeckolibInfestationArmorModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
        this.withCapeBone(new CapeBone("cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}