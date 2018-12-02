package prospector.silk.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import prospector.silk.util.Serializable;

public class FluidInstance implements Serializable {
	public static final String FLUID_KEY = "Fluid";
	public static final String AMOUNT_KEY = "Amount";

	protected Fluid fluid;
	protected int amount;

	public FluidInstance(Fluid fluid, int amount) {
		this.fluid = fluid;
		this.amount = amount;
	}

	public FluidInstance(Fluid fluid) {
		this(fluid, 0);
	}

	public FluidInstance() {
		this(Fluids.EMPTY);
	}

	public FluidInstance(CompoundTag tag) {
		this();
		deserialize(tag);
	}

	public Fluid getFluid() {
		return fluid;
	}

	public int getAmount() {
		return amount;
	}

	public FluidInstance setFluid(Fluid fluid) {
		this.fluid = fluid;
		return this;
	}

	public FluidInstance setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	public FluidInstance shrink(int amount) {
		this.amount -= amount;
		return this;
	}

	public FluidInstance grow(int amount) {
		this.amount += amount;
		return this;
	}

	public FluidInstance copy() {
		return new FluidInstance().setFluid(fluid).setAmount(amount);
	}

	@Override
	public CompoundTag serialize(CompoundTag tag) {
		tag.putString(FLUID_KEY, Registry.FLUIDS.getId(fluid).toString());
		tag.putInt(AMOUNT_KEY, amount);
		return tag;
	}

	@Override
	public void deserialize(CompoundTag tag) {
		fluid = Registry.FLUIDS.get(new Identifier(tag.getString(FLUID_KEY)));
		amount = tag.getInt(AMOUNT_KEY);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof FluidInstance && fluid == ((FluidInstance) obj).getFluid() && amount == ((FluidInstance) obj).getAmount();
	}
}
