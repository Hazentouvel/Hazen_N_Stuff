package net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier;

import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Blazeborne.BlazeborneArmorItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FireblossomRapierRenderer extends GeoItemRenderer<FireblossomRapierItem> {
    public FireblossomRapierRenderer(FireblossomRapierModel fireblossomRapierModel) {
        super(new FireblossomRapierModel());
        this.addRenderLayer(new FireblossomRapierLayer(this));
    }
}
