package net.hazen.hazennstuff.Item.Armor.ReignOfTyros.GarmentsOfTheFirstFlamebearer;

import io.redspace.ironsspellbooks.api.events.ModifySpellLevelEvent;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.effect.ImmolateEffect;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.spells.fire.RaiseHellSpell;
import io.redspace.ironsspellbooks.util.MinecraftInstanceHelper;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Compat.ArsNoveauCompat;
import net.hazen.hazennstuff.Compat.MalumCompat;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSKeybindArmor;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSMessageArmorKey;
import net.hazen.hazennstuff.HnSUtilities.Armor.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSArmorMaterials;
import net.hazen.hazennstuff.HnSUtilities.HnSKeybinds;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Spells.AbstractSpells.TyrosSpells;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.List;

public class GarmentsOfTheFirstFlamebearerArmorItem extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat, HnSKeybindArmor {
    public GarmentsOfTheFirstFlamebearerArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.TYROS_MATERIAL, type, settings, paragonTier(
                AttributeRegistry.FIRE_SPELL_POWER
        ));
    }

    public List<ItemAttributeModifiers.Entry> createExtraAttributes() {
        var group = EquipmentSlotGroup.bySlot(getEquipmentSlot());
        ItemAttributeModifiers.Builder attributes = ItemAttributeModifiers.builder();
        MalumCompat.addArcaneResonance(attributes, group);
        ArsNoveauCompat.addMaxMana(attributes, group);
        ArsNoveauCompat.addManaRegen(attributes, group);
        return attributes.build().modifiers();
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

        tooltipComponents.add(Component.translatable("item.hazennstuff.tyros.description")
                .withStyle(Style.EMPTY.withColor(15881518).withItalic(true)));

        tooltipComponents.add(Component.translatable("item.hazennstuff.tyros_affinity.description")
                .withStyle(Style.EMPTY
                        .withColor(ChatFormatting.YELLOW)
                ));

        tooltipComponents.add(Component.translatable("tooltip.irons_spellbooks.passive_ability_no_cooldown",
                new Object[]{Component.literal(Utils.timeFromTicks((float)Utils.applyCooldownReduction(20, MinecraftInstanceHelper.getPlayer()), 1)).withStyle(ChatFormatting.AQUA)}).withStyle(ChatFormatting.DARK_PURPLE));
        tooltipComponents.add(Component.literal(" ").append(Component.translatable(this.getDescriptionId() + ".desc")).withStyle(ChatFormatting.LIGHT_PURPLE));
        tooltipComponents.add(Component.literal(" ").append(Component.translatable(this.getDescriptionId() + ".immolate.desc", new Object[]{Component.literal(Utils.stringTruncation(ImmolateEffect.damageFor(MinecraftInstanceHelper.getPlayer()), 1)).withStyle(ChatFormatting.RED)})).withStyle(ChatFormatting.LIGHT_PURPLE));
    }


    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new GarmentsOfTheFirstFlamebearerArmorModel());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }

        if (entity instanceof Player player) {
            if (level.isClientSide) {
                if (this.type == Type.CHESTPLATE && player.getItemBySlot(EquipmentSlot.CHEST) == stack && HnSKeybinds.ABILITY_1.consumeClick()) {
                    PacketDistributor.sendToServer(new HnSMessageArmorKey(EquipmentSlot.CHEST.ordinal(), player.getId(), 5), new CustomPacketPayload[0]);
                    this.onKeyPacket(player, stack, 5);
                }
                return;
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.MAGE_SET_BONUS)) {
            player.addEffect(new MobEffectInstance(HnSEffects.MAGE_SET_BONUS, 320, 0, false, false, false));
        }
        if (!player.hasEffect(HnSEffects.TYRANTS_GRACE_EFFECT)) {
            player.addEffect(new MobEffectInstance(HnSEffects.TYRANTS_GRACE_EFFECT, 320, 0, false, false, true));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(Type.HELMET.getSlot()).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem &&
                player.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem &&
                player.getItemBySlot(Type.LEGGINGS.getSlot()).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem &&
                player.getItemBySlot(Type.BOOTS.getSlot()).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem;
    }

    public void onKeyPacket(Player player, ItemStack itemStack, int Type) {
        if (player != null) {
            if (Type == 5 && isWearingFullSet(player) && !player.getCooldowns().isOnCooldown((Item) HnSItemRegistry.TYROS_CHESTPLATE.get())) {
                player.addEffect(new MobEffectInstance(HnSEffects.TYROS_SOUL_STATE, 1200, 0, true, true, true));
                player.getCooldowns().addCooldown((Item) HnSItemRegistry.TYROS_CHESTPLATE.get(), 2400);

                if (player.level() instanceof ServerLevel serverLevel) {
                    double x = player.getX();
                    double y = player.getY() + player.getEyeHeight() * 0.5D;
                    double z = player.getZ();

                    int count = 40;
                    double speed = 0.4;

                    for (int i = 0; i < count; i++) {
                        double angle = (2 * Math.PI * i) / count;

                        double dx = Math.cos(angle);
                        double dz = Math.sin(angle);

                        serverLevel.sendParticles(ParticleHelper.EMBERS, x, y, z, 1, dx * speed, 0.05, dz * speed, 0.0);
                    }

                    serverLevel.sendParticles(HnSParticleHelper.FIRE_IMPACT, x, y, z, 1, 0.0, 0.0, 0.0, 0.0);

                    try {
                        serverLevel.playSound(null, x, y, z, SoundRegistry.FIRE_CAST.get(), SoundSource.PLAYERS, 1.5F, 1.0F);
                    } catch (Exception ignored) {
                    }
                }
            }
        }
    }

    @EventBusSubscriber(value = Dist.CLIENT)
    public class SpellEvents {

        @SubscribeEvent
        public static void onModifySpellLevel(ModifySpellLevelEvent event) {
            LivingEntity caster = event.getEntity();
            if (caster == null) return;

            if (!(event.getSpell() instanceof TyrosSpells)) return;

            if (!(event.getSpell() instanceof RaiseHellSpell)) return;

            boolean fullSet =
                    caster.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem &&
                            caster.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem &&
                            caster.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem &&
                            caster.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem;

            if (fullSet) {
                event.addLevels(1);
            }
        }
    }

}
