package net.hazen.hazennstuff.Item.Armor.SchoolTier.CosmicScholar;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibCosmicScholarArmorModel extends DefaultedEntityGeoModel<GeckolibCosmicScholarArmorItem> {
    public GeckolibCosmicScholarArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibCosmicScholarArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/cosmic_scholar_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibCosmicScholarArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/cosmic_scholar_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibCosmicScholarArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

