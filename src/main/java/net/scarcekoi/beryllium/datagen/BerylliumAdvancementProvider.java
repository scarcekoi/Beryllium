package net.scarcekoi.beryllium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.scarcekoi.beryllium.item.BerylliumItems;

import java.util.function.Consumer;

public class BerylliumAdvancementProvider extends FabricAdvancementProvider {
    public BerylliumAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        BerylliumItems.RAW_BERYLLIUM, // The display icon
                        Text.literal("A Toxic Way"), // The title
                        Text.literal("That's one way to get chronic beryllium disease."), // The description
                        new Identifier("beryllium:textures/gui/advancements/backgrounds/beryllium.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_raw_beryllium", InventoryChangedCriterion.Conditions.items(BerylliumItems.RAW_BERYLLIUM))
                .build(consumer, "beryllium" + "/root");
        Advancement getBerylliumPowderAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        BerylliumItems.BERYLLIUM_POWDER,
                        Text.literal("Now It's a Powder"),
                        Text.literal("And you can inhale it."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_beryllium_powder", InventoryChangedCriterion.Conditions.items(BerylliumItems.BERYLLIUM_POWDER))
                .build(consumer, "beryllium" + "/got_beryllium_powder");
    }
}