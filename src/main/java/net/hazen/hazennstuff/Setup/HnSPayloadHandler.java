package net.hazen.hazennstuff.Setup;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@EventBusSubscriber

public class HnSPayloadHandler {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {

    }
}
