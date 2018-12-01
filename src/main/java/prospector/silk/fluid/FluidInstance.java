package prospector.silk.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundTag;
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

	@Override
	public CompoundTag serialize(CompoundTag tag) {
		tag.putString(FLUID_KEY, Registry.FLUIDS.getId(fluid).toString());
		tag.putInt(AMOUNT_KEY, amount);
		return tag;
	}

	@Override
	public void deserialize(CompoundTag tag) {
		tag.putString(FLUID_KEY, Registry.FLUIDS.getId(fluid).toString());
		tag.putInt(AMOUNT_KEY, amount);
	}
}
