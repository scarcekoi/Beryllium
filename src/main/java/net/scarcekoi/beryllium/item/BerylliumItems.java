package net.scarcekoi.beryllium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.scarcekoi.beryllium.Beryllium;

public class BerylliumItems {
    public static final Item RAW_BERYLLIUM = registerItem("raw_beryllium", new Item(new FabricItemSettings()
            .fireproof()));
    public static final Item BERYLLIUM_INGOT = registerItem("beryllium_ingot", new Item(new FabricItemSettings()
            .fireproof()));
    public static final Item BERYLLIUM_POWDER = registerItem("beryllium_powder", new Item(new FabricItemSettings()
            .fireproof()));
    public static final Item CRUSHED_RAW_BERYLLIUM = registerItem("crushed_raw_beryllium", new Item(new FabricItemSettings()
            .fireproof()));
    public static final Item BERYLLIUM_SHEET = registerItem("beryllium_sheet", new Item(new FabricItemSettings()
            .fireproof()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Beryllium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Beryllium.LOGGER.info("Regeristing mod items for " + Beryllium.MOD_ID);
    }
}
