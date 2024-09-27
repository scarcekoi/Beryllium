package net.scarcekoi.beryllium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.scarcekoi.beryllium.item.BerylliumItems;

public class BerylliumLootTableProvider extends FabricBlockLootTableProvider {
    public BerylliumLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(BerylliumBlocks.RAW_BERYLLIUM_BLOCK);
        addDrop(BerylliumBlocks.BERYLLIUM_BLOCK);

        addDrop(BerylliumBlocks.BERYLLIUM_ORE, technetiumOreDrops(BerylliumBlocks.BERYLLIUM_ORE, BerylliumItems.RAW_BERYLLIUM));
        addDrop(BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE, technetiumOreDrops(BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE, BerylliumItems.RAW_BERYLLIUM));
    }

    public LootTable.Builder technetiumOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
