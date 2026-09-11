package net.hazen.hazennstuff.Items.Armor.Steel.Stalwart;

import com.geckolib.model.DefaultedItemGeoModel;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public final class StalwartArmorRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoArmorRenderer<StalwartArmor, R> {
	public StalwartArmorRenderer() {
		super(new DefaultedItemGeoModel<>(Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armor/stalwart_armor")));
	}
}