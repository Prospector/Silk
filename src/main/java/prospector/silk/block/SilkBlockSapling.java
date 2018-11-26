package prospector.silk.block;

import net.minecraft.block.BlockSapling;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import prospector.silk.util.SilkBlockBuilder;
import prospector.silk.util.SilkSaplingGenerator;

public class SilkBlockSapling extends BlockSapling {
	public SilkBlockSapling(SilkSaplingGenerator treeGenerator) {
		super(treeGenerator, SilkBlockBuilder.create(Material.PLANT).noCollision().acceptRandomTicks().breakInstantly().setSoundGroup(BlockSoundGroup.field_11535).build());
	}
}
