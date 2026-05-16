package net.hazen.hazennstuff.Item.Curios.Wings.FallenAngelWings;

import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Item.Curios.Wings.WingCurioItem;
import net.hazen.hazentouvelib.Rarities.HLRarities;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import top.theillusivec4.curios.api.SlotContext;

import java.util.function.Consumer;

public class FallenAngelWings extends WingCurioItem {

    public FallenAngelWings() {
        super(ItemPropertiesHelper
                .equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(HLRarities.DEUS_RARITY.getValue())
        );
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {

        LivingEntity entity = slotContext.entity();

        if (!(entity instanceof Player player))
            return;

        // Client-side: set a tag on the player so the animation predicate can use it
        if (player.level().isClientSide) {
            String anim = "idle_1";
            if (player.isFallFlying()) {
                double speed = player.getDeltaMovement().length();
                if (speed > 0.65 || player.getXRot() > 35.0f) {
                    anim = "dive";
                } else {
                    anim = "flight";
                }
            } else if (player.getAbilities().flying) {
                anim = "flight";
            } else {
                anim = "idle_2";
            }
            player.getPersistentData().putString("hazentouvelib:wing_anim", anim);
        }

        if (!player.level().isClientSide) {

            // Conditions copied from vanilla Elytra checks: not on ground, not already fall-flying, not in water, and moving downward
            boolean canStartFly = !player.onGround() && !player.isFallFlying() && !player.isInWater() && player.getDeltaMovement().y < 0.0D;

            if (canStartFly && canElytraFly(stack, player)) {
                // Start fall flying on the server — this will cause the client to enter gliding
                player.startFallFlying();
            }
        }
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private FallenAngelWingsRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new FallenAngelWingsRenderer();

                return this.renderer;
            }
        });
    }
}
