package net.hazen.hazennstuff.Item.Staves.GrimoireStaff;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class GrimoireStaffModel extends DefaultedItemGeoModel<GrimoireStaff> {
    public GrimoireStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(GrimoireStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/grimoire_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GrimoireStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/grimoire_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GrimoireStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
