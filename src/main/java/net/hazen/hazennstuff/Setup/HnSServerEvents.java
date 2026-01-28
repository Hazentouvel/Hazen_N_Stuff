package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.config.IronConfigParameters;
import io.redspace.ironsspellbooks.api.config.ModifyDefaultConfigValuesEvent;
import io.redspace.ironsspellbooks.api.events.SpellPreCastEvent;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.spells.ender.BlackHoleSpell;
import net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.Dormant.IonicSplitterItem;
import net.hazen.hazennstuff.Registries.HnSDamageTypes;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;


@EventBusSubscriber
public class HnSServerEvents {

    @SubscribeEvent
    public static void onPlayerCastEvent(SpellPreCastEvent event)
    {
        var entity = event.getEntity();
        var spell = SpellRegistry.getSpell(event.getSpellId());

        // Hexed
        boolean hasHexedEffect = entity.hasEffect(HnSEffects.HEXED);
        if (entity instanceof ServerPlayer player && !player.level().isClientSide())
        {
            if (hasHexedEffect)
            {
                // Damage
                float damage = 1.0F;
                DamageSource damageSource = new DamageSource(
                        DamageSources.getHolderFromResource(entity,
                                HnSDamageTypes.CORRUPT_MAGIC
                        )
                );
                entity.hurt(damageSource, damage);

                player.level().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        HnSSounds.ELECTRIC_IMPACT, SoundSource.PLAYERS, 0.5f, 1f
                );
            }
        }




    }

    @SubscribeEvent
    public static void IonicSplitterAwakening(LivingDamageEvent.Pre event) {
        var sourceEntity = event.getSource().getEntity();
        if (sourceEntity instanceof ServerPlayer serverPlayer) {
            ItemStack mainhandItem = ((LivingEntity) serverPlayer).getMainHandItem();

            if (serverPlayer.hasEffect(HnSEffects.IONIC_AWAKENING)) {
                if (mainhandItem.getItem() instanceof IonicSplitterItem) {
                    serverPlayer.getInventory().setItem(serverPlayer.getInventory().selected, new ItemStack(HnSItemRegistry.IONIC_SPLITTER_T1.get()));
                    serverPlayer.level().playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), HnSSounds.ELECTRIC_CAST, SoundSource.NEUTRAL, 0.5F, 1.3F);
                    serverPlayer.displayClientMessage(Component.literal(ChatFormatting.BOLD + "Awaken")
                            .withStyle(s -> s.withColor(TextColor.fromRgb(5636095))), true);

                }

            }
        }
    }

    @SubscribeEvent
    public static void modifyBlackholeSchool (ModifyDefaultConfigValuesEvent event) {
        if(event.getSpell() instanceof BlackHoleSpell) {
            event.setDefaultValue(IronConfigParameters.SCHOOL, HnSSchoolRegistry.ASTRAL.get());
        }
    }


}