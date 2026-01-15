package net.hazen.hazennstuff.Item.Curios.Sheaths.ScrollSheath;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.aces_spell_utils.items.curios.SheathCurioItem;
import net.hazen.hazennstuff.Animations.HnSDispatcher;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.HnSConfig;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.ItemRegistry.HnSItemRegistry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import top.theillusivec4.curios.api.SlotContext;

@EventBusSubscriber
public class ScrollSheath extends SheathCurioItem {
    public final HnSDispatcher dispatcher;
    public static int COOLDOWN = HnSConfig.scrollSheathCooldown * 20;

    public ScrollSheath() {
        super(new Properties()
                        .stacksTo(1)
                        .rarity(Rarity.EPIC)
                .fireResistant(),
                null);


        this.dispatcher = new HnSDispatcher();
    }


    @Override
    protected int getCooldownTicks() {
        return HnSConfig.scrollSheathCooldown * 20;
    }

    @SubscribeEvent
    public static void handleAbility(LivingIncomingDamageEvent event)
    {
        var sheath = ((ScrollSheath) HnSItemRegistry.SCROLL_SHEATH.get());
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof ServerPlayer player)
        {
            if (sheath.isEquippedBy(player))
            {
                if (sheath.tryProcCooldown(player))
                {
                    var victim = event.getEntity();

                    float getBaseDamage = event.getOriginalAmount();

                    if (victim instanceof LivingEntity livingVictim && victim != attacker)
                    {
                        if (livingVictim.hasEffect(HnSEffects.MANA_SICKNESS))
                        {
                            event.setAmount(getBaseDamage * 1.5F);
                            HazenNStuff.LOGGER.debug("Damage: " + event.getAmount());
                        }
                        livingVictim.addEffect(new MobEffectInstance(HnSEffects.MANA_SICKNESS, 300, 0));

                        var magicData = io.redspace.ironsspellbooks.api.magic.MagicData.getPlayerMagicData(player);
                        magicData.getPlayerCooldowns().clearCooldowns();

                        magicData.getPlayerCooldowns().syncToPlayer(player);

                        player.displayClientMessage(
                                net.minecraft.network.chat.Component.literal("§bAll spell cooldowns have been refreshed!"), true
                        );
                    }
                }
            }
        }
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.SPELL_POWER, new AttributeModifier(id, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(AttributeRegistry.SPELL_RESIST, new AttributeModifier(id, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(id, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return attr;
    }

    private static final int GLIDE_ANIMATION = 0;

    private void handleFlightState(Player player, ItemStack stack) {
        if (GLIDE_ANIMATION == 0) {
            dispatcher.flight(player, stack);
        }
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (!(entity instanceof Player player) || player.level().isClientSide) return;

        if (!player.level().isClientSide && player.isFallFlying()) {
            elytraFlightTick(stack, player, 0);
        }
        if (player.isFallFlying()) {
            handleFlightState(player, stack);
            player.fallDistance = 0.0f;
        } else {
            dispatcher.idle(player, stack);
        }
    }
}