package net.hazen.hazennstuff.entity.armor.Geckolib;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibCreakingSorcererArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibCryogenicRulerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibFireblossomBattlemageCrownedArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibFireblossomBattlemageCrownedArmorModel extends DefaultedEntityGeoModel<GeckolibFireblossomBattlemageCrownedArmorItem> {
    public GeckolibFireblossomBattlemageCrownedArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibFireblossomBattlemageCrownedArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/fireblossom_battlemage_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibFireblossomBattlemageCrownedArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/fireblossom_battlemage_crowned_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibFireblossomBattlemageCrownedArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/fireblossom_battlemage_armor_geckolib.animation.json");

    }
}
