package net.hazen.hazennstuff.Item.Staves.GlassweaverStaff;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class GlassweaverStaffModel extends DefaultedItemGeoModel<GlassweaverScepter> {
    public GlassweaverStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(GlassweaverScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/glassweaver_scepter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GlassweaverScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/glassweaver_scepter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GlassweaverScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
