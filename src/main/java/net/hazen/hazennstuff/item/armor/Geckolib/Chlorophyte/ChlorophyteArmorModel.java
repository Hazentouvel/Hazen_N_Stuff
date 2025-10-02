package net.hazen.hazennstuff.item.armor.Geckolib.Chlorophyte;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.CreakingSorcerer.GeckolibCreakingSorcererArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ChlorophyteArmorModel extends DefaultedEntityGeoModel<ChlorophyteArmorItem> {
    public ChlorophyteArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ChlorophyteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/chlorophyte_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChlorophyteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/creaking_sorcerer_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChlorophyteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
