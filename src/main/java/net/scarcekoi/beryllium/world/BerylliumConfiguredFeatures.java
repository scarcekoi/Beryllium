package net.scarcekoi.beryllium.world;

import net.scarcekoi.beryllium.Beryllium;
import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.scarcekoi.beryllium.block.BerylliumBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class BerylliumConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BERYLLIUM_ORE_KEY = registerKey("beryllium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldBerylliumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, BerylliumBlocks.BERYLLIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, BerylliumBlocks.DEEPSLATE_BERYLLIUM_ORE.getDefaultState()));

        register(context, BERYLLIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBerylliumOres, 9));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Beryllium.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
