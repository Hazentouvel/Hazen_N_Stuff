package net.hazen.hazennstuff.Item.Weapons.Generic.TidalWave;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class TidalWaveModel extends DefaultedItemGeoModel<TidalWave> {
    public TidalWaveModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(TidalWave animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/tidal_wave.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TidalWave animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/tidal_wave.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TidalWave animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
