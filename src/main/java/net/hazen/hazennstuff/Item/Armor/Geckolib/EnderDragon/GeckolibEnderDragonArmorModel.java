package net.hazen.hazennstuff.Item.Armor.Geckolib.EnderDragon;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibEnderDragonArmorModel extends DefaultedEntityGeoModel<GeckolibEnderDragonArmorItem> {
    public GeckolibEnderDragonArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibEnderDragonArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/ender_dragon_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibEnderDragonArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/ender_dragon_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibEnderDragonArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

