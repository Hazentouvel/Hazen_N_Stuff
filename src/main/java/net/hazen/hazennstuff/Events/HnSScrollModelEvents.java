package net.hazen.hazennstuff.Events;

import net.hazen.hazennstuff.Spells.ScrollTextureRegistry;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ModelEvent;

public final class HnSScrollModelEvents {

    private HnSScrollModelEvents() {
    }

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(
                HnSScrollModelEvents::registerAdditionalModels
        );
    }

    private static void registerAdditionalModels(
            ModelEvent.RegisterAdditional event
    ) {
        ScrollTextureRegistry.register();

        for (ResourceLocation modelLocation :
                ScrollTextureRegistry.getRegisteredModels().values()) {

            event.register(ModelResourceLocation.standalone(modelLocation));
        }
    }

}