package net.hazen.hazennstuff.Item.Armor.Geckolib.Miner;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MinerArmorItem extends ImbuableChestplateArmorItem implements IDisableJacket {
    public MinerArmorItem(Type type, Properties settings) {
        // Add in your armor tier + additional attributes for your item
        super(ArmorMaterials.DIAMOND, type, settings,
                new AttributeContainer(Attributes.MINING_EFFICIENCY, 0.05, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(Attributes.SUBMERGED_MINING_SPEED, 0.05, AttributeModifier.Operation.ADD_VALUE)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new MinerArmorModel());
    }
}
