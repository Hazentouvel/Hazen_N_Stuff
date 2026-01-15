package net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Crown;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FireblossomBattlemageCrownArmorModel extends GeoModel<FireblossomBattlemageCrownArmorItem> {
    public FireblossomBattlemageCrownArmorModel() {
    }

    public ResourceLocation getModelResource(FireblossomBattlemageCrownArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/fireblossom_battlemage_armor.geo.json");
    }

    public ResourceLocation getTextureResource(FireblossomBattlemageCrownArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/fireblossom_battlemage_crowned_armor.png");
    }

    public ResourceLocation getAnimationResource(FireblossomBattlemageCrownArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/blazeborne_armor.animation.json");
    }
}
