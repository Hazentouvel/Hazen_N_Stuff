package net.hazen.hazennstuff.entity.armor.Geckolib;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibLegionnaireArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibProjectSekaiArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibRottenGirlArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibProjectSekaiArmorModel extends DefaultedEntityGeoModel<GeckolibProjectSekaiArmorItem> {
    public GeckolibProjectSekaiArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibProjectSekaiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/project_sekai_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibProjectSekaiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/project_sekai_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibProjectSekaiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
