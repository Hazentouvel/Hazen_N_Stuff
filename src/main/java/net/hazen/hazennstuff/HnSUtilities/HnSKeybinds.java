package net.hazen.hazennstuff.HnSUtilities;

import com.mojang.blaze3d.platform.InputConstants;
import io.redspace.ironsspellbooks.player.ExtendedKeyMapping;
import net.hazen.hazennstuff.HazenNStuff;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID, value = Dist.CLIENT)
public final class HnSKeybinds {
    public static final String KEY_BIND_GENERAL_CATEGORY = "key.hazennstuff.group";

    public static final ExtendedKeyMapping ABILITY_1 = new ExtendedKeyMapping(getResourceName("ability_1"), KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, InputConstants.KEY_H, KEY_BIND_GENERAL_CATEGORY);
    public static final ExtendedKeyMapping ABILITY_2 = new ExtendedKeyMapping(getResourceName("ability_2"), KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, InputConstants.KEY_Y, KEY_BIND_GENERAL_CATEGORY);

    private static String getResourceName(String name) {
        return String.format("key.hazennstuff.%s", name);
    }

    @SubscribeEvent
    public static void onRegisterKeybinds(RegisterKeyMappingsEvent event) {
        event.register(ABILITY_1);
        event.register(ABILITY_2);
    }
}