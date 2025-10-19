package net.hazen.hazennstuff.Item.Armor.Geckolib.SacredRobes;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SacredRobesArmorModel extends DefaultedEntityGeoModel<SacredRobesArmorItem> {
    public SacredRobesArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(SacredRobesArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/sacred_robes_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SacredRobesArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/sacred_robes_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SacredRobesArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
