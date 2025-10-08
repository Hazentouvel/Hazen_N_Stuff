package net.hazen.hazennstuff.item.curios.Sheaths.ScrollSheath;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.aces_spell_utils.items.curios.SheathCurioItem;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.HnSConfig;
import net.hazen.hazennstuff.item.dispatcher.HnSItemDispatcher;
import net.hazen.hazennstuff.rarity.ElectricRarity;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.hazen.hazennstuff.registries.HnSItems;
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
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import top.theillusivec4.curios.api.SlotContext;

@EventBusSubscriber
public class ScrollSheath extends SheathCurioItem {
    public final HnSItemDispatcher dispatcher;
    public static int COOLDOWN = HnSConfig.scrollSheathCooldown * 20;

    public ScrollSheath() {
        super(new Properties().stacksTo(1).rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue()).fireResistant(), null);


        this.dispatcher = new HnSItemDispatcher();
    }


    @Override
    protected int getCooldownTicks() {
        return HnSConfig.scrollSheathCooldown * 20;
    }

    @SubscribeEvent
    public static void handleAbility(LivingIncomingDamageEvent event)
    {
        var sheath = ((ScrollSheath) HnSItems.SCROLL_SHEATH.get());
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
                        if (livingVictim.hasEffect(HnSEffects.ELECTROCUTED) || livingVictim.getTicksFrozen() > 20)
                        {
                            event.setAmount(getBaseDamage * 1.5F);
                            HazenNStuff.LOGGER.debug("Damage: " + event.getAmount());
                        }

                        livingVictim.addEffect(new MobEffectInstance(HnSEffects.ELECTROCUTED, 100, 1));
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

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player )
        {
            dispatcher.idle(player, stack);
        }
    }
}