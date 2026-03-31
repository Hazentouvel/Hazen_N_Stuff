package net.hazen.hazennstuff.Item.Armor.SchoolTier.NautilusKnight;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class NautilusKnightArmorModel extends DefaultedEntityGeoModel<NautilusKnightArmorItem> {
    public NautilusKnightArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(NautilusKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/nautilus_knight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NautilusKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/nautilus_knight_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NautilusKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

