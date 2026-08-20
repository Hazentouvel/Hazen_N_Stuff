package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Screens.StarForgeMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HnSMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, HazenNStuff.MOD_ID);

    public static final Supplier<MenuType<StarForgeMenu>> STARFORGE =
            MENUS.register("starforge", () -> IMenuTypeExtension.create(StarForgeMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
