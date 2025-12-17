package net.hazen.hazennstuff.Item.Armor.Geckolib.BishopOfDeceitArmor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BishopOfDeceitArmorItem extends ImbuableChestplateArmorItem implements IDisableJacket {
    public BishopOfDeceitArmorItem(Type slot, Properties settings) {
        super(ArmorMaterialRegistry.SCHOOL, slot, settings, schoolAttributes(AttributeRegistry.HOLY_SPELL_POWER));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new BishopOfDeceitArmorModel());
    }
}