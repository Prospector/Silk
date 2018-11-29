package prospector.silk.block;

import net.minecraft.block.Material;
import net.minecraft.block.SaplingBlock;
import net.minecraft.sound.BlockSoundGroup;
import prospector.silk.util.SilkBlockBuilder;
import prospector.silk.util.SilkSaplingGenerator;

public class SilkSaplingBlock extends SaplingBlock {
	public SilkSaplingBlock(SilkSaplingGenerator treeGenerator) {
		super(treeGenerator, SilkBlockBuilder.create(Material.PLANT).noCollision().acceptRandomTicks().breakInstantly().setSoundGroup(BlockSoundGroup.GRASS).build());
	}
}
