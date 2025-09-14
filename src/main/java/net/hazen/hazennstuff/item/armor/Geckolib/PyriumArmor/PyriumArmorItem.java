package net.hazen.hazennstuff.item.armor.Geckolib.PyriumArmor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.compat.MalumCompat;
import net.hazen.hazennstuff.item.armor.Geckolib.Utau.UtauArmorModel;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.List;

public class PyriumArmorItem extends ImbuableChestplateArmorItem {
    public PyriumArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.PYRIUM_MATERIAL, type, settings
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new PyriumArmorModel());
    }
}
