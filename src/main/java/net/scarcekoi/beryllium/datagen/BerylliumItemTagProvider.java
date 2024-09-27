package net.scarcekoi.beryllium.datagen;

import com.simibubi.create.AllTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.scarcekoi.beryllium.item.BerylliumItems;
import net.scarcekoi.beryllium.util.BerylliumTags;

import java.util.concurrent.CompletableFuture;

public class BerylliumItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public BerylliumItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BerylliumTags.Items.TECHNETIUM_ITEMS)
                .add(BerylliumItems.RAW_BERYLLIUM)
                .add(BerylliumItems.BERYLLIUM_INGOT)
                .add(BerylliumItems.BERYLLIUM_POWDER)
                .add(BerylliumItems.CRUSHED_RAW_BERYLLIUM)
                .add(BerylliumItems.BERYLLIUM_SHEET);
        getOrCreateTagBuilder(AllTags.AllItemTags.CRUSHED_RAW_MATERIALS.tag)
                .add(BerylliumItems.CRUSHED_RAW_BERYLLIUM);
    }
}