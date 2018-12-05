package prospector.silk.block;

import net.fabricmc.fabric.helpers.FabricBlockBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class SilkLeavesBlock extends LeavesBlock {
	public Item sapling;

	public SilkLeavesBlock(Item sapling) {
		super(FabricBlockBuilder.create(Material.LEAVES).setHardness(0.2F).acceptRandomTicks().setSoundGroup(BlockSoundGroup.GRASS).build());
	}
}
