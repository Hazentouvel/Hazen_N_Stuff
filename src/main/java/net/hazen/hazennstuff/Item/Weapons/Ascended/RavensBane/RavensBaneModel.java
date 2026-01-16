package net.hazen.hazennstuff.Item.Weapons.Ascended.RavensBane;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class RavensBaneModel extends DefaultedItemGeoModel<RavensBaneItem> {
    public RavensBaneModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(RavensBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/ravens_bane.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RavensBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ravens_bane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RavensBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
