package net.hazen.hazennstuff.Item.Armor.Geckolib.NamelessOneArmor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class NamelessOneArmorModel extends DefaultedEntityGeoModel<NamelessOneArmorItem> {
    public NamelessOneArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(NamelessOneArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/skeleton_robes.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NamelessOneArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/the_nameless_one.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NamelessOneArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
