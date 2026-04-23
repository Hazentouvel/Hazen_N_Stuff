package net.hazen.hazennstuff.HnSUtilities.Armor;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record HnSMessageArmorKey(int equipmentSlot, int playerId, int typ) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<HnSMessageArmorKey> TYPE = new CustomPacketPayload.Type(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armor_key"));
    public static final StreamCodec<RegistryFriendlyByteBuf, HnSMessageArmorKey> STREAM_CODEC = CustomPacketPayload.codec(HnSMessageArmorKey::write, HnSMessageArmorKey::new);

    public HnSMessageArmorKey(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public HnSMessageArmorKey(int equipmentSlot, int playerId, int typ) {
        this.equipmentSlot = equipmentSlot;
        this.playerId = playerId;
        this.typ = typ;
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.equipmentSlot());
        buf.writeInt(this.playerId());
        buf.writeInt(this.typ());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(HnSMessageArmorKey message, IPayloadContext context) {
        if (context.flow().isServerbound()) {
            context.enqueueWork(() -> {
                Player player = context.player();
                EquipmentSlot equipmentSlot1 = EquipmentSlot.values()[Mth.clamp(message.equipmentSlot, 0, EquipmentSlot.values().length - 1)];
                ItemStack stack = player.getItemBySlot(equipmentSlot1);
                Item patt0$temp = stack.getItem();
                if (patt0$temp instanceof HnSKeybindArmor armor) {
                    armor.onKeyPacket(player, stack, message.typ);
                }
            });
        }
    }

    public int equipmentSlot() {
        return this.equipmentSlot;
    }

    public int playerId() {
        return this.playerId;
    }

    public int typ() {
        return this.typ;
    }
}
