package net.hazen.hazennstuff.Item.Weapons.Terraprisma;

import io.redspace.ironsspellbooks.api.events.ModifySpellLevelEvent;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.TooltipsUtils;
import net.hazen.hazennstuff.Dispatcher.HnSDispatcher;
import net.hazen.hazennstuff.Item.Weapons.Excalibur.HazenStyle.HazensExcaliburItem;
import net.hazen.hazennstuff.Item.Weapons.Excalibur.HazenStyle.HazensExcaliburRenderer;
import net.hazen.hazennstuff.Item.Weapons.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.Rarity.FireRarity;
import net.hazen.hazennstuff.Rarity.RadianceRarity;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TerraprismaItem extends MagicSwordItem {
    public final HnSDispatcher dispatcher;

    public TerraprismaItem() {
        super(
                HnSExtendedWeaponsTiers.TERRAPRISMA,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(RadianceRarity.RADIANCE_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.TERRAPRISMA)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(HnSSpellRegistries.TERRAPRISMIC_BARRAGE, 5),
                        new SpellDataRegistryHolder(HnSSpellRegistries.CALL_FORTH_TERRAPRISMA, 5)
                )
        );
        this.dispatcher = new HnSDispatcher();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        var affinityData = AffinityData.getAffinityData(stack);
        if (!affinityData.affinityData().isEmpty()) {
            int i = TooltipsUtils.indexOfComponent(lines, "tooltip.hazennstuff.spellbook_spell_count");
            lines.addAll(i < 0 ? lines.size() : i + 1, affinityData.getDescriptionComponent());
        }

        lines.add(Component.translatable("item.hazennstuff.terraria.description")
                .withStyle(ChatFormatting.WHITE, ChatFormatting.ITALIC));
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        super.initializeSpellContainer(itemStack);
        itemStack.set(ComponentRegistry.AFFINITY_COMPONENT, new AffinityData(Map.of(
                HnSSpellRegistries.TERRAPRISMIC_BARRAGE.get().getSpellResource(), 1,
                HnSSpellRegistries.CALL_FORTH_TERRAPRISMA.get().getSpellResource(), 1
        )));
    }

    @EventBusSubscriber(value = Dist.CLIENT)
    public static class SpellEvents {

        @SubscribeEvent
        public static void onModifySpellLevel(ModifySpellLevelEvent event) {
            LivingEntity caster = event.getEntity();
            if (caster == null) return;

            var spell = event.getSpell();

            boolean isTerraprismaSpell =
                    spell == HnSSpellRegistries.TERRAPRISMIC_BARRAGE.get() ||
                            spell == HnSSpellRegistries.CALL_FORTH_TERRAPRISMA.get();

            if (!isTerraprismaSpell)
                return;

            ItemStack mainHand = caster.getMainHandItem();
            ItemStack offHand = caster.getOffhandItem();

            boolean usingTerraprisma =
                    mainHand.getItem() instanceof TerraprismaItem ||
                            offHand.getItem() instanceof TerraprismaItem;

            if (usingTerraprisma) {
                event.addLevels(1);
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player )
        {
            dispatcher.idle(player, stack);
        }
    }
}