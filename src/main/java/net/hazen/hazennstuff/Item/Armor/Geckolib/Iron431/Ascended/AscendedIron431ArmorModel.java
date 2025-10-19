package net.hazen.hazennstuff.Item.Armor.Geckolib.Iron431.Ascended;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class AscendedIron431ArmorModel extends DefaultedEntityGeoModel<AscendedIron431ArmorItem> {
    public AscendedIron431ArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(AscendedIron431ArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/irons_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AscendedIron431ArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/irons_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AscendedIron431ArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
