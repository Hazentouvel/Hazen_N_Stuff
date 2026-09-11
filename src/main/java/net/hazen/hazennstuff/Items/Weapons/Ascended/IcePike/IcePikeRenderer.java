package net.hazen.hazennstuff.Items.Weapons.Ascended.IcePike;

import com.geckolib.model.DefaultedItemGeoModel;
import com.geckolib.renderer.GeoItemRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public final class IcePikeRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoItemRenderer<IcePikeItem> {
	public IcePikeRenderer() {
		super(new DefaultedItemGeoModel<>(Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, "equipment/weapons/ice_pike")));
	}
}