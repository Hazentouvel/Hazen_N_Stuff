package net.hazen.hazennstuff.item.armor.Geckolib.FireblossomBattlemage;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibFireblossomBattlemageCrownedArmorModel extends DefaultedEntityGeoModel<GeckolibFireblossomBattlemageCrownedArmorItem> {
    public GeckolibFireblossomBattlemageCrownedArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibFireblossomBattlemageCrownedArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/fireblossom_battlemage_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibFireblossomBattlemageCrownedArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/fireblossom_battlemage_crowned_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibFireblossomBattlemageCrownedArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/fireblossom_battlemage_armor.animation.json");

    }
}
