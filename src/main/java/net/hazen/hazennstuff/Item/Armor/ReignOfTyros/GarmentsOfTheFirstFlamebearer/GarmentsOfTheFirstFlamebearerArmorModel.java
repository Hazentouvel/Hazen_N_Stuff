package net.hazen.hazennstuff.Item.Armor.ReignOfTyros.GarmentsOfTheFirstFlamebearer;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GarmentsOfTheFirstFlamebearerArmorModel extends DefaultedEntityGeoModel<GarmentsOfTheFirstFlamebearerArmorItem> {
    public GarmentsOfTheFirstFlamebearerArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GarmentsOfTheFirstFlamebearerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/garments_of_the_first_flamebearer_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GarmentsOfTheFirstFlamebearerArmorItem animatable) {
        ResourceLocation normalTex = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/garments_of_the_first_flamebearer_armor.png");
        ResourceLocation brimstoneStateTex = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/garments_of_the_first_flamebearer_soul_armor.png");

        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasEffect(HnSEffects.TYROS_SOUL_STATE)) {
            return brimstoneStateTex;
        }
        return normalTex;
    }

    @Override
    public ResourceLocation getAnimationResource(GarmentsOfTheFirstFlamebearerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

