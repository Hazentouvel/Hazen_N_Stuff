package net.hazen.hazennstuff.entity.armor.Geckolib;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.AtlasArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibChargedScourgeArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.MaverickArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MaverickArmorModel extends DefaultedEntityGeoModel<MaverickArmorItem> {
    public MaverickArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(MaverickArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/maverick.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaverickArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/maverick.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaverickArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/maverick.animation.json");
    }
}
