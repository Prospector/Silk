package prospector.silk.item;

import net.minecraft.block.Block;
import net.minecraft.item.$ilkExtendableAxeItem;
import net.minecraft.item.ToolMaterial;

public class SilkAxeItem extends $ilkExtendableAxeItem {
	public SilkAxeItem(ToolMaterial toolType, float v, float v1, Builder builder) {
		super(toolType, v, v1, builder);
	}

	public static void mapStrippedLog(Block log, Block strippedLog) {
		BLOCK_TRANSFORMATIONS_MAP.put(log, strippedLog);
	}
}
