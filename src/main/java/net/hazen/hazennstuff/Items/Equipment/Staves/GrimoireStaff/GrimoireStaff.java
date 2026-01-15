package net.hazen.hazennstuff.Items.Equipment.Staves.GrimoireStaff;

import com.gametechbc.spelllib.item.GeoStaffItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier.FireblossomRapierModel;
import net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier.FireblossomRapierRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Map;
import java.util.UUID;

public class GrimoireStaff extends GeoStaffItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GrimoireStaff() {
        super(ItemPropertiesHelper.equipment()
                        .stacksTo(1)
                        .rarity(Rarity.EPIC), 3, -3,
                Map.of(
                        AttributeRegistry.EVOCATION_SPELL_POWER.get(),
                        new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier",
                                .15, AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.CASTING_MOVESPEED.get(),
                        new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier",
                                .2, AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.CAST_TIME_REDUCTION.get(),
                        new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier",
                                .1, AttributeModifier.Operation.MULTIPLY_BASE)
                ));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockEntityWithoutLevelRenderer getRenderer() {
        return new GrimoireStaffRenderer(new GrimoireStaffModel());
    }
}