package io.github.prospector.silk.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.SaplingBlock;
import net.minecraft.sound.BlockSoundGroup;
import io.github.prospector.silk.util.SilkSaplingGenerator;

public class SilkSaplingBlock extends SaplingBlock {
	public SilkSaplingBlock(SilkSaplingGenerator treeGenerator) {
		super(treeGenerator, FabricBlockSettings.of(Material.PLANT).collidable(false).ticksRandomly().hardness(0).sounds(BlockSoundGroup.GRASS).build());
	}
}
