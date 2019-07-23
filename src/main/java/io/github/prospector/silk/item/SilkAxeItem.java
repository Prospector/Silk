package io.github.prospector.silk.item;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class SilkAxeItem extends AxeItem {
	public SilkAxeItem(ToolMaterial toolType, float v, float v1, Settings settings) {
		super(toolType, v, v1, settings);
	}

	public static void mapStrippedLog(Block log, Block strippedLog) {
		STRIPPED_BLOCKS.put(log, strippedLog);
	}
}
