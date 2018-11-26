package prospector.silk.util;

import net.fabricmc.fabric.helpers.FabricBlockBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.MapColor;
import net.minecraft.world.loot.LootTables;

import java.util.function.Function;

public class SilkBlockBuilder {
	private final Block.Builder delegate;
	private final FabricBlockBuilder.Delegate castDelegate;

	protected SilkBlockBuilder(Material material) {
		this.delegate = Block.Builder.create(material);
		this.castDelegate = (FabricBlockBuilder.Delegate) this.delegate;
	}

	protected SilkBlockBuilder(Block base) {
		this.delegate = Block.Builder.copy(base);
		this.castDelegate = (FabricBlockBuilder.Delegate) this.delegate;
	}

	public static SilkBlockBuilder create(Material material) {
		return new SilkBlockBuilder(material);
	}

	public static SilkBlockBuilder copy(Block base) {
		return new SilkBlockBuilder(base);
	}

	public SilkBlockBuilder setMapColor(MapColor color) {
		this.castDelegate.fabric_setMapColor(color);
		return this;
	}

	public SilkBlockBuilder setMapColor(DyeColor color) {
		this.castDelegate.fabric_setMapColor(color.getMapColor());
		return this;
	}

	public SilkBlockBuilder noCollision() {
		this.castDelegate.fabric_setCollidable(false);
		return this;
	}

	public SilkBlockBuilder setSoundGroup(BlockSoundGroup group) {
		this.castDelegate.fabric_setSoundGroup(group);
		return this;
	}

	public SilkBlockBuilder acceptRandomTicks() {
		this.castDelegate.fabric_setRandomTicks(true);
		return this;
	}

	public SilkBlockBuilder setLuminance(int value) {
		this.castDelegate.fabric_setLuminance(value);
		return this;
	}

	public SilkBlockBuilder setHardness(float value) {
		this.castDelegate.fabric_setHardness(value);
		this.setBlastResistance(value);
		return this;
	}

	public SilkBlockBuilder setBlastResistance(float value) {
		this.castDelegate.fabric_setResistance(value);
		return this;
	}

	public SilkBlockBuilder breakInstantly() {
		return this.setStrength(0F);
	}

	public SilkBlockBuilder setStrength(float strength) {
		return this.setStrength(strength, strength);
	}

	public SilkBlockBuilder setStrength(float hardness, float resistance) {
		this.setHardness(hardness);
		this.setBlastResistance(resistance);
		return this;
	}

	public SilkBlockBuilder setDropTable(Identifier id) {
		this.castDelegate.fabric_setDropTable(id);
		return this;
	}

	public SilkBlockBuilder withoutDropTable() {
		this.setDropTable(LootTables.EMPTY);
		return this;
	}

	public SilkBlockBuilder copyDropTable(Block block) {
		this.setDropTable(block.getDropTableId());
		return this;
	}

	public SilkBlockBuilder setFrictionCoefficient(float value) {
		this.castDelegate.fabric_setFriction(value);
		return this;
	}

	public Block.Builder build() {
		return this.delegate;
	}

	public <T> T build(Function<Block.Builder, T> function) {
		return function.apply(this.delegate);
	}
}
