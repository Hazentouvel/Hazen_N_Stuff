package net.hazen.hazennstuff.Item.Staves.Frieren;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FrierenStaffModel extends DefaultedItemGeoModel<FrierenStaffItem> {
    public FrierenStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FrierenStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/frieren_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrierenStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/frieren_staff.png");
    }
    @Override
    public ResourceLocation getAnimationResource(FrierenStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
