package io.github.prospector.silk.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.RenderTypeBlock;

public abstract class SilkBlockWithEntity extends BlockWithEntity {

	public SilkBlockWithEntity(Settings settings) {
		super(settings);
	}

	@Override
	public RenderTypeBlock getRenderType(BlockState state) {
		return RenderTypeBlock.MODEL;
	}
}
