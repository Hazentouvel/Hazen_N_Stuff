package net.hazen.hazennstuff.Item.Armor.Geckolib.ProjectSekai;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ProjectSekaiArmorModel extends DefaultedEntityGeoModel<ProjectSekaiArmorItem> {
    public ProjectSekaiArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ProjectSekaiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/project_sekai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ProjectSekaiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/project_sekai_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ProjectSekaiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
