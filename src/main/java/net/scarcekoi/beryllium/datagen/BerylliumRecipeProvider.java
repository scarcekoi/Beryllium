package net.scarcekoi.beryllium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.scarcekoi.beryllium.item.BerylliumItems;

import java.util.List;
import java.util.function.Consumer;

public class BerylliumRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> TECHNETIUM_SMELTABLES = List.of(BerylliumItems.RAW_BERYLLIUM,
            BerylliumBlocks.BERYLLIUM_ORE, BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE);

    public BerylliumRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter,
                TECHNETIUM_SMELTABLES,
                RecipeCategory.MISC,
                BerylliumItems.BERYLLIUM_INGOT,
                0.7F,
                200,
                "technetium");
        offerBlasting(exporter, TECHNETIUM_SMELTABLES,
                RecipeCategory.MISC,
                BerylliumItems.BERYLLIUM_INGOT,
                0.7F,
                100,
                "technetium");

        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC,
                BerylliumItems.BERYLLIUM_INGOT,
                RecipeCategory.MISC,
                BerylliumBlocks.BERYLLIUM_BLOCK,
                convertBetween(BerylliumBlocks.BERYLLIUM_BLOCK, BerylliumItems.BERYLLIUM_INGOT),
                "technetium",
                convertBetween(BerylliumItems.BERYLLIUM_INGOT, BerylliumBlocks.BERYLLIUM_BLOCK),
                "technetium"
        );
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC,
                BerylliumItems.RAW_BERYLLIUM,
                RecipeCategory.MISC,
                BerylliumBlocks.RAW_BERYLLIUM_BLOCK,
                convertBetween(BerylliumBlocks.RAW_BERYLLIUM_BLOCK, BerylliumItems.RAW_BERYLLIUM),
                "technetium",
                convertBetween(BerylliumItems.RAW_BERYLLIUM, BerylliumBlocks.RAW_BERYLLIUM_BLOCK),
                "technetium"
        );

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BerylliumItems.BERYLLIUM_INGOT, 1)
                .pattern("##")
                .pattern("##")
                .input('#', BerylliumItems.BERYLLIUM_POWDER)
                .criterion(hasItem(BerylliumItems.BERYLLIUM_INGOT), conditionsFromItem(BerylliumItems.BERYLLIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(BerylliumItems.BERYLLIUM_POWDER)));
    }
}
