package net.hazen.hazennstuff.Item.Armor.Geckolib.DreadsteelKnight;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DreadsteelArmorModel extends DefaultedEntityGeoModel<DreadsteelKnightArmorItem> {
    public DreadsteelArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(DreadsteelKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/dreadsteel_knight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DreadsteelKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/dreadsteel_knight_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DreadsteelKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
