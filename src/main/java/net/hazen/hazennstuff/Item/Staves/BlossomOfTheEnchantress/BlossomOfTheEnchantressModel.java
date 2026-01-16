package net.hazen.hazennstuff.Item.Staves.BlossomOfTheEnchantress;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class BlossomOfTheEnchantressModel extends DefaultedItemGeoModel<BlossomOfTheEnchantress> {
    public BlossomOfTheEnchantressModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(BlossomOfTheEnchantress animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/blossom_of_the_enchantress.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlossomOfTheEnchantress animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/blossom_of_the_enchantress.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlossomOfTheEnchantress animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
