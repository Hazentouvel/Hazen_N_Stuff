package net.hazen.hazennstuff.entity.armor.Geckolib;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibEnderDragonArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibEnderDragonArmorModel extends DefaultedEntityGeoModel<GeckolibEnderDragonArmorItem> {
    public GeckolibEnderDragonArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibEnderDragonArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/ender_dragon_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibEnderDragonArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/ender_dragon_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibEnderDragonArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/ender_dragon_armor_geckolib.animation.json");
    }
}

