package net.hazen.hazennstuff.Entity.Mobs.HnSEntityUtils;

import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class AbstractSpellCastingEnderManAngerEvent extends LivingEvent implements ICancellableEvent {
    private final Player player;

    public AbstractSpellCastingEnderManAngerEvent(AbstractSpellCastingEnderman enderman, Player player) {
        super(enderman);
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public EnderMan getEntity() {
        return (EnderMan)super.getEntity();
    }
}
