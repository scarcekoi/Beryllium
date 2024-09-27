package net.scarcekoi.beryllium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.scarcekoi.beryllium.util.BerylliumTags;

import java.util.concurrent.CompletableFuture;

public class BerylliumBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BerylliumBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BerylliumTags.Blocks.TECHNETIUM_ORES)
                .add(BerylliumBlocks.BERYLLIUM_ORE)
                .add(BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE);

        getOrCreateTagBuilder(BerylliumTags.Blocks.TECHNETIUM_BLOCKS)
                .addTag(BerylliumTags.Blocks.TECHNETIUM_ORES)
                .add(BerylliumBlocks.RAW_BERYLLIUM_BLOCK)
                .add(BerylliumBlocks.BERYLLIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(BerylliumTags.Blocks.TECHNETIUM_BLOCKS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BerylliumTags.Blocks.TECHNETIUM_BLOCKS);
    }
}
