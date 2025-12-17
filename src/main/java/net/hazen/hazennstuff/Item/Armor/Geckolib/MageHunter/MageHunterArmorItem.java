package net.hazen.hazennstuff.Item.Armor.Geckolib.MageHunter;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.Item.Armor.Geckolib.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.Item.Armor.HnSArmorMaterials;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MageHunterArmorItem extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat {
    public MageHunterArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.MAGEHUNTER_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, .125, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, -.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, -.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new MageHunterArmorModel());
    }
}