package net.hazen.hazennstuff.Item.Curios.Wings.AngelWings;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.illusivesoulworks.caelus.api.CaelusApi;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazentouvelib.Items.Curios.Wings.WingCurioItem;
import net.hazen.hazentouvelib.Rarities.HLRarities;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import top.theillusivec4.curios.api.SlotContext;

import java.util.function.Consumer;

public class AngelWings extends WingCurioItem {
    private static final Holder<Attribute> FALL_FLY_ATTRIBUTE = CaelusApi.getInstance().getFallFlyingAttribute();
    private static final ResourceLocation ANGEL_WINGS = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "angel_wings_flight");


    public AngelWings() {
        super(new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(HLRarities.DEUS_RARITY.getValue())
        );
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private AngelWingsRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new AngelWingsRenderer();

                return this.renderer;
            }
        });
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attributes = LinkedHashMultimap.create();

        attributes.put(FALL_FLY_ATTRIBUTE, new AttributeModifier(ANGEL_WINGS, 1.0D, AttributeModifier.Operation.ADD_VALUE));

        return attributes;
    }
}
