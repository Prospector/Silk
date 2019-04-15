package io.github.prospector.silk.fluid;

import net.minecraft.text.StringTextComponent;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TranslatableTextComponent;

public class DropletValues {
	// Common Equivalents
	public static final int BLOCK = 3240;
	public static final int INGOT = BLOCK / 9;
	public static final int NUGGET = INGOT / 9;
	public static final int DROPLET = 1;

	@Deprecated // Refer to DROPLET ^
	public static final int DRIP = DROPLET;

	// Fluid Containers
	public static final int BUCKET = BLOCK;
	public static final int BOTTLE = BUCKET / 3;

	public static TextComponent formatFluidValue(int amount) {
		TextComponent text = new StringTextComponent("");
		int buckets = amount / BLOCK;
		if (buckets != 0) text.append(new TranslatableTextComponent("silk.fluid.value.bucket", buckets));
		int remainder = amount % BLOCK;
		if (remainder == 0) return text; else if (buckets != 0) text.append(", ");
		int ingots = remainder / INGOT;
		if (ingots != 0) text.append(new TranslatableTextComponent("silk.fluid.value.ingot", ingots));
		remainder = remainder % INGOT;
		if (remainder == 0) return text; else if (ingots != 0) text.append(", ");
		int nuggets = remainder / NUGGET;
		int droplets = remainder % NUGGET;
		int nuggetFrac = (int)((droplets / (float)NUGGET) * 1000);
		if (nuggets == 0 && droplets == 0) return text;
		if (droplets == 0) text.append(new TranslatableTextComponent("silk.fluid.value.nugget", nuggets));
		else text.append(new TranslatableTextComponent("silk.fluid.value.nugget_partial", nuggets, (nuggetFrac > 100)? droplets : "0"+droplets));
		return text;
	}
}   
