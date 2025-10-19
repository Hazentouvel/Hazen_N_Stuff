package net.hazen.hazennstuff.Item.Weapons.WarFlamingLance;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class WarFlamingLanceModel extends DefaultedItemGeoModel<WarFlamingLanceItem> {
    public WarFlamingLanceModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(WarFlamingLanceItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/war_flaming_lance.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WarFlamingLanceItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/war_flaming_lance.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WarFlamingLanceItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
