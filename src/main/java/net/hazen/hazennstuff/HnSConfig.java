package net.hazen.hazennstuff;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class HnSConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    /*
    *** Curios
     */

    /*
    *** Sheaths
     */

    // Galvanized Sheath
    private static final ModConfigSpec.ConfigValue<Integer> GALVANIZED_SHEATH_COOLDOWN = BUILDER
            .comment("Defines the cooldown in seconds value for the Galvanized Sheath's ability")
            .comment("Default is [5]")
            .define("Galvanized Sheath CD", 8);

    // Scroll Sheath
    private static final ModConfigSpec.ConfigValue<Integer> SCROLL_SHEATH_COOLDOWN = BUILDER
            .comment("Defines the cooldown in seconds value for the Scroll Sheath's ability")
            .comment("Default is [5]")
            .define("Scroll Sheath CD", 5);


    static final ModConfigSpec SPEC = BUILDER.build();

    public static int galvanizedSheathCooldown;
    public static int galvanizedSheathLightningCooldown;
    public static int scrollSheathCooldown;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        galvanizedSheathCooldown = GALVANIZED_SHEATH_COOLDOWN.get();
        scrollSheathCooldown = SCROLL_SHEATH_COOLDOWN.get();
    }
}
