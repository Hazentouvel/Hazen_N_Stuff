package net.hazen.hazennstuff.item.staves.rod_of_discord;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class RodOfDiscordModel extends DefaultedItemGeoModel<RodOfDiscordItem> {
    public RodOfDiscordModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(RodOfDiscordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/rod_of_discord.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RodOfDiscordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/rod_of_discord/rod_of_discord.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RodOfDiscordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
