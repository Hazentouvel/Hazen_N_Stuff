package net.hazen.hazennstuff.Item.Armor.Geckolib.CreakingSorcerer;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibCreakingSorcererArmorModel extends DefaultedEntityGeoModel<GeckolibCreakingSorcererArmorItem> {
    public GeckolibCreakingSorcererArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibCreakingSorcererArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/creaking_sorcerer_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibCreakingSorcererArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/creaking_sorcerer_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibCreakingSorcererArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
