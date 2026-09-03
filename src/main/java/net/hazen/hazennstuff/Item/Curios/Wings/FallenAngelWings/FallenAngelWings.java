package net.hazen.hazennstuff.Item.Curios.Wings.FallenAngelWings;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.illusivesoulworks.caelus.api.CaelusApi;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazentouvelib.Items.Curios.Wings.WingCurioItem;
import net.hazen.hazentouvelib.Rarities.HLRarities;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import top.theillusivec4.curios.api.SlotContext;

import java.util.function.Consumer;

public class FallenAngelWings extends WingCurioItem {

    public FallenAngelWings() {
        super(new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(HLRarities.DEUS_RARITY.getValue())
        );
    }

    private static final Holder<Attribute> FALL_FLY_ATTRIBUTE = CaelusApi.getInstance().getFallFlyingAttribute();
    private static final ResourceLocation FALLEN_ANGEL_WINGS = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fallen_angel_wings_flight");

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
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attributes = LinkedHashMultimap.create();

        attributes.put(FALL_FLY_ATTRIBUTE, new AttributeModifier(FALLEN_ANGEL_WINGS, 1.0D, AttributeModifier.Operation.ADD_VALUE));

        return attributes;
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
