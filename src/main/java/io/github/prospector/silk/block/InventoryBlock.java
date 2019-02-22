package io.github.prospector.silk.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public abstract class InventoryBlock extends SilkBlockWithEntity implements InventoryProvider {

	public InventoryBlock(Settings settings) {
		super(settings);
	}

	@Override
	public SidedInventory getInventory(BlockState state, IWorld world, BlockPos pos) {
		if (!(world.getBlockEntity(pos) instanceof Inventory)) return null;
		else return (SidedInventory) world.getBlockEntity(pos);
	}
}
