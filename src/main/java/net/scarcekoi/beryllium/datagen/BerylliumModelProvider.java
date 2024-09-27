package net.scarcekoi.beryllium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.scarcekoi.beryllium.item.BerylliumItems;

public class BerylliumModelProvider extends FabricModelProvider {
    public BerylliumModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BerylliumBlocks.RAW_BERYLLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BerylliumBlocks.BERYLLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BerylliumBlocks.BERYLLIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BerylliumItems.RAW_BERYLLIUM, Models.GENERATED);
        itemModelGenerator.register(BerylliumItems.BERYLLIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(BerylliumItems.BERYLLIUM_POWDER, Models.GENERATED);
        itemModelGenerator.register(BerylliumItems.CRUSHED_RAW_BERYLLIUM, Models.GENERATED);
        itemModelGenerator.register(BerylliumItems.BERYLLIUM_SHEET, Models.GENERATED);
    }
}
