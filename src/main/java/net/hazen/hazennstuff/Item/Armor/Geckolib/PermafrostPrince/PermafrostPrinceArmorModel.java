package net.hazen.hazennstuff.Item.Armor.Geckolib.PermafrostPrince;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class PermafrostPrinceArmorModel extends DefaultedEntityGeoModel<PermafrostPrinceArmorItem> {
    public PermafrostPrinceArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(PermafrostPrinceArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/permafrost_prince_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PermafrostPrinceArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/permafrost_prince_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PermafrostPrinceArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
