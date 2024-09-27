package net.scarcekoi.beryllium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.scarcekoi.beryllium.Beryllium;
import net.scarcekoi.beryllium.block.BerylliumBlocks;

public class BerylliumItemGroups {
    public static final ItemGroup BERYLLIUM = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Beryllium.MOD_ID, "beryllium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.beryllium"))
                    .icon(() -> new ItemStack(BerylliumItems.BERYLLIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(BerylliumItems.RAW_BERYLLIUM);
                        entries.add(BerylliumItems.BERYLLIUM_INGOT);
                        entries.add(BerylliumItems.BERYLLIUM_POWDER);
                        entries.add(BerylliumItems.CRUSHED_RAW_BERYLLIUM);
                        entries.add(BerylliumItems.BERYLLIUM_SHEET);

                        entries.add(BerylliumBlocks.RAW_BERYLLIUM_BLOCK);
                        entries.add(BerylliumBlocks.BERYLLIUM_BLOCK);

                        entries.add(BerylliumBlocks.BERYLLIUM_ORE);
                        entries.add(BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE);
                    }).build());

    public static void registerItemGroups() {
        Beryllium.LOGGER.info("Registering item groups for " + Beryllium.MOD_ID);
    }
}