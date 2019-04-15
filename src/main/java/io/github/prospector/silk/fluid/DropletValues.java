package io.github.prospector.silk.fluid;

import net.minecraft.text.StringTextComponent;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TranslatableTextComponent;

public class DropletValues {
	// Common Equivalents
	public static final int BLOCK = 324;
	public static final int INGOT = BLOCK / 9;
	public static final int NUGGET = INGOT / 9;
	public static final int QUARTER_NUGGET = 1;

	@Deprecated // Refer to DROPLET ^
	public static final int DROPLET = QUARTER_NUGGET;

	// Fluid Containers
	public static final int BUCKET = BLOCK;
	public static final int BOTTLE = BUCKET / 3;

	public static TextComponent formatFluidValue(int amount) {
		TextComponent text = new StringTextComponent("");
		int buckets = amount / 324;
		if (buckets != 0) text.append(new TranslatableTextComponent("silk.fluid.value.bucket", buckets));
		int remainder = amount % 324;
		if (remainder == 0) return text; else if (buckets != 0) text.append(", ");
		int ingots = remainder / 36;
		if (ingots != 0) text.append(new TranslatableTextComponent("silk.fluid.value.ingot", ingots));
		remainder = remainder % 36;
		if (remainder == 0) return text; else if (ingots != 0) text.append(", ");
		int nuggets = remainder / 4;
		int quarterNuggets = (remainder % 4) * 25;
		if (nuggets == 0 && quarterNuggets == 0) return text;
		if (quarterNuggets == 0) text.append(new TranslatableTextComponent("silk.fluid.value.nugget", nuggets));
		else text.append(new TranslatableTextComponent("silk.fluid.value.nugget_partial", nuggets, quarterNuggets));
		return text;
	}
}   
