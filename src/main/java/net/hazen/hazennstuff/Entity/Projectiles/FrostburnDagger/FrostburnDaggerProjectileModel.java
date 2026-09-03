package net.hazen.hazennstuff.Entity.Projectiles.FrostburnDagger;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FrostburnDaggerProjectileModel extends GeoModel<FrostburnDaggerProjectile> {

    @Override
    public ResourceLocation getModelResource(FrostburnDaggerProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/projectile/frostburn_dagger_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrostburnDaggerProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/frostburn_dagger.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FrostburnDaggerProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }


}