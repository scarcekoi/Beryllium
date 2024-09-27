package net.scarcekoi.beryllium.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.scarcekoi.beryllium.world.BerylliumPlacedFeatures;

public class BerylliumOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, BerylliumPlacedFeatures.BERYLLIUM_ORE_PLACED_KEY);
    }
}
