package io.github.prospector.silk.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

/**
 * Functions like the vanila InventoryProvider class.
 * It is recommended to use this or another component system for accessing fluid containers.
 */
public interface FluidContainerProvider {
	FluidContainer getContainer(BlockState state, IWorld world, BlockPos pos);
}
