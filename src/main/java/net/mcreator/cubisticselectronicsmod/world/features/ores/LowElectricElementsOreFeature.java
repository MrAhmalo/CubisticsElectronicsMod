
package net.mcreator.cubisticselectronicsmod.world.features.ores;

import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import net.mcreator.cubisticselectronicsmod.init.CubisticselectronicsmodModBlocks;

import java.util.Set;
import java.util.Random;

public class LowElectricElementsOreFeature extends OreFeature {
	public static final LowElectricElementsOreFeature FEATURE = (LowElectricElementsOreFeature) new LowElectricElementsOreFeature()
			.setRegistryName("cubisticselectronicsmod:low_electric_elements_ore");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new OreConfiguration(LowElectricElementsOreFeatureRuleTest.INSTANCE,
					CubisticselectronicsmodModBlocks.LOW_ELECTRIC_ELEMENTS_ORE.defaultBlockState(), 7))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(1), VerticalAnchor.absolute(16)))).squared().count(11);
	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public LowElectricElementsOreFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		ResourceKey<Level> dimensionType = world.getLevel().dimension();
		boolean dimensionCriteria = false;
		if (dimensionType == Level.OVERWORLD)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return false;
		return super.place(context);
	}

	private static class LowElectricElementsOreFeatureRuleTest extends RuleTest {
		static final LowElectricElementsOreFeatureRuleTest INSTANCE = new LowElectricElementsOreFeatureRuleTest();
		static final com.mojang.serialization.Codec<LowElectricElementsOreFeatureRuleTest> codec = com.mojang.serialization.Codec
				.unit(() -> INSTANCE);
		static final RuleTestType<LowElectricElementsOreFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("cubisticselectronicsmod:low_electric_elements_ore_match"), () -> codec);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;
			if (blockAt.getBlock() == Blocks.STONE)
				blockCriteria = true;
			return blockCriteria;
		}

		protected RuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}
	}
}
