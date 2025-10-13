package net.hazen.hazennstuff.item.staves.WhiteLilyStaff;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.staves.wisewood_cane.WisewoodCaneItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class WhiteLilyStaffModel extends DefaultedItemGeoModel<WhiteLilyStaffItem> {
    public WhiteLilyStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(WhiteLilyStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/white_lily_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteLilyStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/white_lily_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteLilyStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
