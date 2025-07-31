package net.hazen.hazennstuff.item.armor.Geckolib.SynthesizerV;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibSynthesizerVArmorModel extends DefaultedEntityGeoModel<GeckolibSynthesizerVArmorItem> {
    public GeckolibSynthesizerVArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibSynthesizerVArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/teto_kasane_synthesizer_v_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibSynthesizerVArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/teto_kasane_synthesizer_v_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibSynthesizerVArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
