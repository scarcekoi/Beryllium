package net.scarcekoi.beryllium.compat;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.recipe.CrushingRecipeGen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.scarcekoi.beryllium.Beryllium;
import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.scarcekoi.beryllium.item.BerylliumItems;

public class BerylliumCreateCrushingRecipeGen extends CrushingRecipeGen {
    public BerylliumCreateCrushingRecipeGen(FabricDataOutput output) {
        super(output);
    }

    GeneratedRecipe

            RAW_BERYLLIUM = create(Beryllium.MOD_ID,() -> BerylliumItems.RAW_BERYLLIUM, b -> b.duration(400)
            .output(BerylliumItems.CRUSHED_RAW_BERYLLIUM)
            .output(.75f, AllItems.EXP_NUGGET.get())),
            CRUSHED_RAW_BERYLLIUM = create(Beryllium.MOD_ID,() -> BerylliumItems.CRUSHED_RAW_BERYLLIUM, b -> b.duration(350)
            .output(BerylliumItems.BERYLLIUM_POWDER, 4)
            .output(.75f, AllItems.EXP_NUGGET.get())),
            BERYLLIUM_INGOT = create(Beryllium.MOD_ID,() -> BerylliumItems.BERYLLIUM_INGOT, b -> b.duration(400)
            .output(BerylliumItems.BERYLLIUM_POWDER, 4)
            .output(.125f, BerylliumItems.BERYLLIUM_POWDER)
            .output(.75f, AllItems.EXP_NUGGET.get())),
            RAW_BERYLLIUM_BLOCK = create(Beryllium.MOD_ID,() -> BerylliumBlocks.RAW_BERYLLIUM_BLOCK, b -> b.duration(400)
            .output(BerylliumItems.CRUSHED_RAW_BERYLLIUM, 9)
            .output(.75f, AllItems.EXP_NUGGET.get(), 9)),
            BERYLLIUM_ORE = create(Beryllium.MOD_ID,() -> BerylliumBlocks.BERYLLIUM_ORE, b -> b.duration(250)
            .output(BerylliumItems.CRUSHED_RAW_BERYLLIUM, 5)
            .output(.25f, BerylliumItems.CRUSHED_RAW_BERYLLIUM)
            .output(.75f, AllItems.EXP_NUGGET.get())
            .output(.125f, Blocks.COBBLESTONE)),
            DEEPSLATE_BERYLLIUM_ORE = create(Beryllium.MOD_ID,() -> BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE, b -> b.duration(250)
            .output(BerylliumItems.CRUSHED_RAW_BERYLLIUM, 7)
            .output(.25f, BerylliumItems.CRUSHED_RAW_BERYLLIUM)
            .output(.75f, AllItems.EXP_NUGGET.get())
            .output(.125f, Blocks.COBBLED_DEEPSLATE));
}
