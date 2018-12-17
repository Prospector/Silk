package io.github.prospector.silk.util;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.config.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

import java.util.Random;

public class SilkSaplingGenerator extends SaplingGenerator {
	public final AbstractTreeFeature<DefaultFeatureConfig> feature;

	public SilkSaplingGenerator(AbstractTreeFeature<DefaultFeatureConfig> feature) {
		this.feature = feature;
	}

	@Override
	protected AbstractTreeFeature<DefaultFeatureConfig> createTreeFeature(Random random) {
		return feature;
	}
}
