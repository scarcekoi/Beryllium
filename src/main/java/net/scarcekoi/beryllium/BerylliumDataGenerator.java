package net.scarcekoi.beryllium;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.scarcekoi.beryllium.compat.BerylliumCreateCrushingRecipeGen;
import net.scarcekoi.beryllium.compat.BerylliumCreatePressingRecipeGen;
import net.scarcekoi.beryllium.datagen.*;
import net.scarcekoi.beryllium.world.BerylliumConfiguredFeatures;
import net.scarcekoi.beryllium.world.BerylliumPlacedFeatures;

public class BerylliumDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BerylliumBlockTagProvider::new);
		pack.addProvider(BerylliumItemTagProvider::new);
		pack.addProvider(BerylliumLootTableProvider::new);
		pack.addProvider(BerylliumModelProvider::new);
		pack.addProvider(BerylliumRecipeProvider::new);
		pack.addProvider(BerylliumWorldGenerator::new);

		pack.addProvider(BerylliumCreateCrushingRecipeGen::new);
		pack.addProvider(BerylliumCreatePressingRecipeGen::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, BerylliumConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, BerylliumPlacedFeatures::bootstrap);
	}
}
