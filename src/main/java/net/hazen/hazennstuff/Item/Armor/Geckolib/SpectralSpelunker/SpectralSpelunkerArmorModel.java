package net.hazen.hazennstuff.Item.Armor.Geckolib.SpectralSpelunker;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SpectralSpelunkerArmorModel extends DefaultedEntityGeoModel<SpectralSpelunkerArmorItem> {
    public SpectralSpelunkerArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(SpectralSpelunkerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/spectral_spelunker_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpectralSpelunkerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/spectral_spelunker_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpectralSpelunkerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
