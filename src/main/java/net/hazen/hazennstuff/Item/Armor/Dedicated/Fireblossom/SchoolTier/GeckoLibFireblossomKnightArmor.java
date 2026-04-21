package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.SchoolTier;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSArmorMaterials;
import net.hazen.hazennstuff.HnSUtilities.Armor.ImbuableGeckolibHnSArmorItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GeckoLibFireblossomKnightArmor extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat {
    public GeckoLibFireblossomKnightArmor(Type type, Properties settings) {
        super(ArmorMaterialRegistry.NETHERITE_BATTLEMAGE, type, settings, schoolTierMulti(
                AttributeRegistry.FIRE_SPELL_POWER,
                AttributeRegistry.NATURE_SPELL_POWER
        ));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new GeckoLibFireblossomKnightArmorModel());
    }
}