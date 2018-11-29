package prospector.silk.block;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import prospector.silk.util.SilkBlockBuilder;

public class SilkLeavesBlock extends LeavesBlock {
	public Item sapling;

	public SilkLeavesBlock(Item sapling) {
		super(SilkBlockBuilder.create(Material.LEAVES).setStrength(0.2F).acceptRandomTicks().setSoundGroup(BlockSoundGroup.GRASS).build());
	}
}
