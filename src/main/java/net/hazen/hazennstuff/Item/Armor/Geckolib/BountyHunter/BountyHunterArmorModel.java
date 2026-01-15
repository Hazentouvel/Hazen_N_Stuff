package net.hazen.hazennstuff.Item.Armor.Geckolib.BountyHunter;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BountyHunterArmorModel extends DefaultedEntityGeoModel<BountyHunterArmorItem> {
    public BountyHunterArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(BountyHunterArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/bounty_hunter_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BountyHunterArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/bounty_hunter_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BountyHunterArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
