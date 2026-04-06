package net.hazen.hazennstuff.Item.Armor.PureTier.Glassweaver;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GlassweaverArmorModel extends DefaultedEntityGeoModel<GlassweaverArmorItem> {
    public GlassweaverArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GlassweaverArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/glassweaver_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GlassweaverArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/glassweaver_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GlassweaverArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/glassweaver_armor.animation.json");
    }
}
