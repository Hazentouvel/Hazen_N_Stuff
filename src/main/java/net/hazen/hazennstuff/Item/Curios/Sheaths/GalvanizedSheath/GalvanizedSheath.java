package net.hazen.hazennstuff.Item.Curios.Sheaths.GalvanizedSheath;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.aces_spell_utils.items.curios.SheathCurioItem;
import net.hazen.hazennstuff.Animations.HnSDispatcher;
import net.hazen.hazennstuff.Entity.Spells.Lightning.InstantLightningStrike.LightningStrike;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.HnSConfig;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.core.Direction;
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
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import top.theillusivec4.curios.api.SlotContext;

@EventBusSubscriber
public class GalvanizedSheath extends SheathCurioItem {
    public final HnSDispatcher dispatcher;
    public static int COOLDOWN = HnSConfig.galvanizedSheathCooldown * 20;

    public GalvanizedSheath() {
        super(new Properties().stacksTo(1).rarity(HnSRarities.LIGHTNING_RARITY.getValue()).fireResistant(), null);


        this.dispatcher = new HnSDispatcher();
    }


    @Override
    protected int getCooldownTicks() {
        return HnSConfig.galvanizedSheathCooldown * 20;
    }

    @SubscribeEvent
    public static void handleAbility(LivingIncomingDamageEvent event) {
        var sheath = ((GalvanizedSheath) HnSItemRegistry.GALVANIZED_SHEATH.get());
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof ServerPlayer player) {
            if (sheath.isEquippedBy(player) && sheath.tryProcCooldown(player)) {
                var victim = event.getEntity();

                if (victim instanceof LivingEntity livingVictim && victim != attacker) {
                    float baseDamage = event.getOriginalAmount();

                    if (livingVictim.hasEffect(HnSEffects.ELECTROCUTED)) {
                        event.setAmount(baseDamage * 1.5F);
                        HazenNStuff.LOGGER.debug("Damage: " + event.getAmount());
                    }

                    livingVictim.addEffect(new MobEffectInstance(HnSEffects.ELECTROCUTED, 100, 1));

                    spawnLightningLine(player.level(), player, livingVictim);
                }
            }
        }
    }

    private static void spawnLightningLine(Level level, LivingEntity attacker, LivingEntity victim) {
        if (level.isClientSide) return;

        Vec3 start = attacker.position().add(0, attacker.getBbHeight() * 0.5, 0);
        Vec3 end = victim.position().add(0, victim.getBbHeight() * 0.5, 0);
        Vec3 direction = end.subtract(start).normalize();

        // Extend lightning past the victim
        double extraDistance = 32.0;
        double totalDistance = start.distanceTo(end) + extraDistance;

        // How many lightning strikes to spawn
        int maxStrikes = 8;

        double stepDistance = totalDistance / maxStrikes;
        Vec3 step = direction.scale(stepDistance);

        int delayPerStrike = 1;

        for (int i = 0; i < maxStrikes; i++) {
            Vec3 pos = start.add(step.scale(i)).with(Direction.Axis.Y, start.y);

            LightningStrike strike = new LightningStrike(level);
            strike.setPos(pos.x, pos.y, pos.z);
            strike.setOwner(attacker);
            strike.setDamage(3.0f);
            strike.setWaitTime(i * delayPerStrike);

            level.addFreshEntity(strike);
        }
    }



    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.LIGHTNING_SPELL_POWER, new AttributeModifier(id, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(AttributeRegistry.LIGHTNING_MAGIC_RESIST, new AttributeModifier(id, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
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