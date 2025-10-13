package net.hazen.hazennstuff.item.staves.WhiteLilyStaff;

import net.hazen.hazennstuff.item.staves.rod_of_discord.RodOfDiscordItem;
import net.hazen.hazennstuff.item.staves.rod_of_discord.RodOfDiscordModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WhiteLilyStaffRenderer extends GeoItemRenderer<WhiteLilyStaffItem> {
    public WhiteLilyStaffRenderer() {
        super(new WhiteLilyStaffModel());
    }
}
