package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.PureTier;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckoLibFireblossomBattlemageArmorModel extends DefaultedEntityGeoModel<GeckoLibFireblossomBattlemageArmor> {
    public GeckoLibFireblossomBattlemageArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckoLibFireblossomBattlemageArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/fireblossom_battlemage_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckoLibFireblossomBattlemageArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/fireblossom_battlemage_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckoLibFireblossomBattlemageArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/fireblossom_battlemage_armor.animation.json");
    }
}

