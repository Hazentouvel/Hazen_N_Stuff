package net.hazen.hazennstuff.Item.Armor.AscendedTier.CoruscatedValor;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CoruscatedValorArmorModel extends DefaultedEntityGeoModel<CoruscatedValorArmorItem> {
    public CoruscatedValorArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(CoruscatedValorArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/coruscated_valor_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoruscatedValorArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/coruscated_valor_armor_alt.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoruscatedValorArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/coruscated_valor_armor.animation.json");
    }
}

