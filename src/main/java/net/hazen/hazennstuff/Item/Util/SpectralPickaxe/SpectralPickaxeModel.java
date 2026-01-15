package net.hazen.hazennstuff.Item.Util.SpectralPickaxe;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class SpectralPickaxeModel extends DefaultedItemGeoModel<SpectralPickaxeItem> {
    public SpectralPickaxeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(SpectralPickaxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/tools/spectral_pickaxe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpectralPickaxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/tools/spectral_pickaxe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpectralPickaxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
