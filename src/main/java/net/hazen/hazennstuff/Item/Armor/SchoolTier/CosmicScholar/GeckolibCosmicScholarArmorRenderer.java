package net.hazen.hazennstuff.Item.Armor.SchoolTier.CosmicScholar;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GeckolibCosmicScholarArmorRenderer extends TransmogArmorRenderer<GeckolibCosmicScholarArmorItem> {

    public GeckolibCosmicScholarArmorRenderer(GeckolibCosmicScholarArmorModel bountyHunterArmorModel) {
        super(new GeckolibCosmicScholarArmorModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
        this.withCapeBone(new CapeBone("cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}