package net.hazen.hazennstuff.Items.Weapons.Special.Skyscorcher;

import com.geckolib.model.DefaultedItemGeoModel;
import com.geckolib.renderer.GeoItemRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public final class SkyscorcherRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoItemRenderer<SkyscorcherItem> {
	public SkyscorcherRenderer() {
		super(new DefaultedItemGeoModel<>(Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, "equipment/weapons/skyscorcher")));
		withRenderLayer(SkyscorcherLayer::new);
	}
}