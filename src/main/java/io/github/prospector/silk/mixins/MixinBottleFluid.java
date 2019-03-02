package io.github.prospector.silk.mixins;

import io.github.prospector.silk.fluid.DropletValues;
import io.github.prospector.silk.fluid.FluidInstance;
import io.github.prospector.silk.fluid.ItemWithFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtil;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PotionItem.class)
public class MixinBottleFluid implements ItemWithFluid {
	@Override
	public FluidInstance getFluid(ItemStack stack) {
		if (stack.getItem() instanceof PotionItem) {
			PotionItem potion = (PotionItem)stack.getItem();
			if (PotionUtil.getPotion(stack).equals(PotionUtil.getPotion(potion.getDefaultStack()))) {
				return new FluidInstance(Fluids.WATER, DropletValues.BUCKET);
			}
		}
		return FluidInstance.EMPTY;
	}
}
