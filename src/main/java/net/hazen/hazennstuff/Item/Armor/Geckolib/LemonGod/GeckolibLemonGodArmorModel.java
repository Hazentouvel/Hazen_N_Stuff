package net.hazen.hazennstuff.Item.Armor.Geckolib.LemonGod;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibLemonGodArmorModel extends DefaultedEntityGeoModel<GeckolibLemonGodArmorItem> {
    public GeckolibLemonGodArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibLemonGodArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/lemon_god_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibLemonGodArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/lemon_god_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibLemonGodArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
