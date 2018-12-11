package io.github.prospector.silk.block;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.SaplingBlock;
import net.minecraft.sound.BlockSoundGroup;
import io.github.prospector.silk.util.SilkSaplingGenerator;

public class SilkSaplingBlock extends SaplingBlock {
	public SilkSaplingBlock(SilkSaplingGenerator treeGenerator) {
		super(treeGenerator, FabricBlockSettings.create(Material.PLANT).setCollidable(false).acceptRandomTicks().setHardness(0).setSoundGroup(BlockSoundGroup.GRASS).build());
	}
}
