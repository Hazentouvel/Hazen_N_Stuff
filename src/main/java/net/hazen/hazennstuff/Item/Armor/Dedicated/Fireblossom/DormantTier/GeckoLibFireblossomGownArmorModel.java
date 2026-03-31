package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.DormantTier;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckoLibFireblossomGownArmorModel extends DefaultedEntityGeoModel<GeckoLibFireblossomGownArmor> {
    public GeckoLibFireblossomGownArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckoLibFireblossomGownArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/fireblossom_gown_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckoLibFireblossomGownArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/fireblossom_gown_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckoLibFireblossomGownArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

