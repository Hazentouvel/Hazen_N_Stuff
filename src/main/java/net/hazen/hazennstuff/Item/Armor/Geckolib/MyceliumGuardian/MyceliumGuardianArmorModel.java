package net.hazen.hazennstuff.Item.Armor.Geckolib.MyceliumGuardian;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MyceliumGuardianArmorModel extends DefaultedEntityGeoModel<MyceliumGuardianArmorItem> {
    public MyceliumGuardianArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(MyceliumGuardianArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/mycelium_guardian_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MyceliumGuardianArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/mycelium_guardian_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MyceliumGuardianArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

