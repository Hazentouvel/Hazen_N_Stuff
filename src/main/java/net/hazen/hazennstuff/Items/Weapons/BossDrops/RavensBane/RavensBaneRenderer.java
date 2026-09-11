package net.hazen.hazennstuff.Items.Weapons.BossDrops.RavensBane;

import com.geckolib.model.DefaultedItemGeoModel;
import com.geckolib.renderer.GeoItemRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public final class RavensBaneRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoItemRenderer<RavensBaneItem> {
	public RavensBaneRenderer() {
		super(new DefaultedItemGeoModel<>(Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, "equipment/weapons/ravens_bane")));
	}
}