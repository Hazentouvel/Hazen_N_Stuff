package net.hazen.hazennstuff.Item.Staves.CoraliteCane;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class CoraliteCaneModel extends DefaultedItemGeoModel<CoraliteCane> {
    public CoraliteCaneModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(CoraliteCane animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/coralite_cane.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoraliteCane animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/coralite_cane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoraliteCane animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
