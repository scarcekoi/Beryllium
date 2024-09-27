package net.scarcekoi.beryllium.compat;

import com.simibubi.create.foundation.data.recipe.PressingRecipeGen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.scarcekoi.beryllium.Beryllium;
import net.scarcekoi.beryllium.item.BerylliumItems;

public class BerylliumCreatePressingRecipeGen extends PressingRecipeGen {
    public BerylliumCreatePressingRecipeGen(FabricDataOutput output) {
        super(output);
    }

    GeneratedRecipe

            BERYLLIUM_SHEET = create(Beryllium.MOD_ID,() -> BerylliumItems.BERYLLIUM_INGOT, b -> b
            .output(BerylliumItems.BERYLLIUM_SHEET));
}
