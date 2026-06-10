package net.hazen.hazennstuff.Item.Armor.AscendedTier.DeadKing;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DeadKingArmorModel extends DefaultedEntityGeoModel<DeadKingArmorItem> {
    public DeadKingArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(DeadKingArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/dead_king_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DeadKingArmorItem animatable) {
        ResourceLocation normalTex = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/dead_king_armor.png");
        ResourceLocation ominousStateTex = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/ominous_dead_king_armor.png");
        ResourceLocation enragedStateTex = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/dead_king_enraged_armor.png");
        ResourceLocation ominousEnragedStateTex = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/ominous_dead_king_enraged_armor.png");

        LivingEntity player = Minecraft.getInstance().player;
        if (player != null && player.hasEffect(HnSEffects.AWAKENING)) {
            if (player.hasEffect(HnSEffects.DEAD_KING_SOUL_STATE)) {
                return ominousEnragedStateTex;
            }
            return enragedStateTex;
        }
        if (player != null && player.hasEffect(HnSEffects.DEAD_KING_SOUL_STATE)) {
            return ominousStateTex;
        }

        return normalTex;
    }

    @Override
    public ResourceLocation getAnimationResource(DeadKingArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/dead_king_armor.animation.json");
    }
}

