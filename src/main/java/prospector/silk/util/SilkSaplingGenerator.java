package prospector.silk.util;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.config.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

import java.util.Random;

public class SilkSaplingGenerator extends SaplingGenerator {
	public final TreeFeature<DefaultFeatureConfig> feature;

	public SilkSaplingGenerator(TreeFeature<DefaultFeatureConfig> feature) {
		this.feature = feature;
	}

	@Override
	protected TreeFeature<DefaultFeatureConfig> getTreeFeature(Random random) {
		return feature;
	}
}
