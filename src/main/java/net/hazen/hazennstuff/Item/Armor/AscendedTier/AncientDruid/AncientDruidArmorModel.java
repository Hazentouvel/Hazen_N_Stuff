package net.hazen.hazennstuff.Item.Armor.AscendedTier.AncientDruid;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class AncientDruidArmorModel extends DefaultedEntityGeoModel<AncientDruidArmorItem> {
    public AncientDruidArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(AncientDruidArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/ancient_druid_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AncientDruidArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/ancient_druid_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AncientDruidArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
