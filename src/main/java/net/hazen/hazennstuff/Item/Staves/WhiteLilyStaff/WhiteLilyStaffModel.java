package net.hazen.hazennstuff.Item.Staves.WhiteLilyStaff;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class WhiteLilyStaffModel extends DefaultedItemGeoModel<WhiteLilyStaff> {
    public WhiteLilyStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(WhiteLilyStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/white_lily_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteLilyStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/white_lily_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteLilyStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
