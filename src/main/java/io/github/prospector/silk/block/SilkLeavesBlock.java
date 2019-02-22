package io.github.prospector.silk.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class SilkLeavesBlock extends LeavesBlock {
	public Item sapling;

	public SilkLeavesBlock(Item sapling) {
		super(FabricBlockSettings.of(Material.LEAVES).hardness(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).build());
	}
}
