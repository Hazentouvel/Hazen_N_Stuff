package net.hazen.hazennstuff.Setup;

import com.mojang.datafixers.util.Either;
import io.redspace.ironsspellbooks.api.events.SpellPreCastEvent;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.damage.DamageSources;
import net.hazen.hazennstuff.Registries.HnSDamageTypes;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.Tooltips.LightningClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;

import java.util.List;


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
                        HnSSounds.BRIMSTONE_HELLBLAST_IMPACT, SoundSource.PLAYERS, 0.5f, 1f
                );
            }
        }

    }

    @SubscribeEvent
    public static void onGatherTooltipComponents(RenderTooltipEvent.GatherComponents event) {
        List<Either<FormattedText, TooltipComponent>> elements = event.getTooltipElements();
        String marker = "\u26A1"; // ⚡

        for (final int[] i = {0}; i[0] < elements.size(); i[0]++) {
            var element = elements.get(i[0]);

            // We only care about the "Left" side (the raw text/Components)
            element.left().ifPresent(text -> {
                String rawText = text.getString();

                if (rawText.contains(marker)) {
                    // 1. Extract the text between the symbols
                    int start = rawText.indexOf(marker);
                    int end = rawText.lastIndexOf(marker);

                    if (start != end) {
                        String prefix = rawText.substring(0, start);
                        String lightningPart = rawText.substring(start + 1, end);
                        String suffix = rawText.substring(end + 1);

                        // 2. Clear the current line
                        elements.remove(i[0]);

                        // 3. Reconstruct the line
                        if (!prefix.isEmpty()) {
                            elements.add(i[0], Either.left(Component.literal(prefix)));
                            i[0]++;
                        }

                        // Inject our custom Lightning Component
                        elements.add(i[0], Either.right(new LightningClientTooltipComponent.LightningTooltipData(Component.literal(lightningPart))));
                        i[0]++;

                        if (!suffix.isEmpty()) {
                            elements.add(i[0], Either.left(Component.literal(suffix)));
                        }
                    }
                }
            });
        }
    }


    /*
    *** Changing Spell Schools *****************************************************************************************
     */

//    @SubscribeEvent
//    public static void modifyBlackholeSchool (ModifyDefaultConfigValuesEvent event) {
//        if(event.getSpell() instanceof BlackHoleSpell) {
//            event.setDefaultValue(IronConfigParameters.SCHOOL, HnSSchoolRegistry.COSMIC.get());
//        }
//    }
}