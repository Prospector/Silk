package io.github.prospector.silk.mixins;

import io.github.prospector.silk.fluid.DropletValues;
import io.github.prospector.silk.fluid.FluidInstance;
import io.github.prospector.silk.fluid.ItemWithFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BucketItem.class)
public class MixinBucketFluid implements ItemWithFluid {
	@Override
	public FluidInstance getFluid(ItemStack stack) {
		if (stack.getItem() == Items.WATER_BUCKET) {
			return new FluidInstance(Fluids.WATER, DropletValues.BUCKET);
		} else if (stack.getItem() == Items.LAVA_BUCKET) {
			return new FluidInstance(Fluids.LAVA, DropletValues.BUCKET);
		}
		return FluidInstance.EMPTY;
	}
}
