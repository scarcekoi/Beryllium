package net.scarcekoi.beryllium;

import net.fabricmc.api.ModInitializer;

import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.scarcekoi.beryllium.item.BerylliumItemGroups;
import net.scarcekoi.beryllium.item.BerylliumItems;
import net.scarcekoi.beryllium.world.gen.BerylliumWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Beryllium implements ModInitializer {
		public static final String MOD_ID = "beryllium";
		public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BerylliumItemGroups.registerItemGroups();

		BerylliumItems.registerModItems();
		BerylliumBlocks.registerModBlocks();

		BerylliumWorldGeneration.generateModWorldGen();
	}
}