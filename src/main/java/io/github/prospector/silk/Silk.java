package io.github.prospector.silk;

import io.github.prospector.silk.item.SilkAxeItem;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.block.Block;

public class Silk {

	public static void mapStrippedLog(Block log, Block strippedLog) {
		SilkAxeItem.mapStrippedLog(log, strippedLog);
	}
}
