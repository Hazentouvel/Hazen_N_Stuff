package net.hazen.hazennstuff.Item.Armor.Geckolib.GiornoGiovanna;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GiornoGiovannaArmorModel extends DefaultedEntityGeoModel<GiornoGiovannaArmorItem> {
    public GiornoGiovannaArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GiornoGiovannaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/giorno_giovanna_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GiornoGiovannaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/giorno_giovanna_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GiornoGiovannaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
