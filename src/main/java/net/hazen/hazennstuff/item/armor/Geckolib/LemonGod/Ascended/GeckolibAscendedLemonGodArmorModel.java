package net.hazen.hazennstuff.item.armor.Geckolib.LemonGod.Ascended;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibAscendedLemonGodArmorModel extends DefaultedEntityGeoModel<GeckolibAscendedLemonGodArmorItem> {
    public GeckolibAscendedLemonGodArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibAscendedLemonGodArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/lemon_god_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibAscendedLemonGodArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/lemon_god_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibAscendedLemonGodArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
