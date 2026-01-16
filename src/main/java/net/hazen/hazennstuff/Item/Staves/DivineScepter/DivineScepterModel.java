package net.hazen.hazennstuff.Item.Staves.DivineScepter;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DivineScepterModel extends DefaultedItemGeoModel<DivineScepter> {
    public DivineScepterModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(DivineScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/divine_scepter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DivineScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/divine_scepter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DivineScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
