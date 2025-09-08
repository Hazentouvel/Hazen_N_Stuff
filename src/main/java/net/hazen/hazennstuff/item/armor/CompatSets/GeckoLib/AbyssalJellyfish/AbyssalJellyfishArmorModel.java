package net.hazen.hazennstuff.item.armor.CompatSets.GeckoLib.AbyssalJellyfish;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class AbyssalJellyfishArmorModel extends DefaultedEntityGeoModel<AbyssalJellyfishArmorItem> {
    public AbyssalJellyfishArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(AbyssalJellyfishArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/abyssal_jellyfish_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AbyssalJellyfishArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/abyssal_jellyfish_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AbyssalJellyfishArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
