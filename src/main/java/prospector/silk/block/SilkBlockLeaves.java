package prospector.silk.block;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import prospector.silk.util.SilkBlockBuilder;

public class SilkBlockLeaves extends BlockLeaves {
	public Item sapling;

	public SilkBlockLeaves(Item sapling) {
		super(SilkBlockBuilder.create(Material.LEAVES).setStrength(0.2F).acceptRandomTicks().setSoundGroup(BlockSoundGroup.field_11535).build());
	}
}
