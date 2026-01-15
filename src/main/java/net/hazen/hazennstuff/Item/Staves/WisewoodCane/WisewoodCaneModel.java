package net.hazen.hazennstuff.Item.Staves.WisewoodCane;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class WisewoodCaneModel extends DefaultedItemGeoModel<WisewoodCaneItem> {
    public WisewoodCaneModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(WisewoodCaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/wisewood_cane.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WisewoodCaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/wisewood_cane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WisewoodCaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
