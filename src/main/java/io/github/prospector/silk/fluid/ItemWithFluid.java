package io.github.prospector.silk.fluid;

import net.minecraft.item.ItemStack;

/**
 * An item, like a bucket or bottle, that has a fluid in it.
 */
public interface ItemWithFluid {
	public FluidInstance getFluid(ItemStack stack);
}
