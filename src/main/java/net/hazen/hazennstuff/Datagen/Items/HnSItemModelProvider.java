package net.hazen.hazennstuff.Datagen.Items;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class HnSItemModelProvider extends ItemModelProvider {
    public HnSItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(HazenNStuff.MOD_ID,"item/" + item.getId().getPath()));
    }
}