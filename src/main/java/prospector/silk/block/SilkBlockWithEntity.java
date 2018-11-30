package prospector.silk.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.RenderTypeBlock;

public abstract class SilkBlockWithEntity extends BlockWithEntity {

	public SilkBlockWithEntity(Builder builder) {
		super(builder);
	}

	public RenderTypeBlock getRenderType(BlockState var1) {
		return RenderTypeBlock.MODEL;
	}
}
