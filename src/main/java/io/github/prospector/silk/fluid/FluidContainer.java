package io.github.prospector.silk.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.Direction;

public interface FluidContainer {
	boolean canInsertFluid(Direction fromSide, Fluid fluid, int amount);

	boolean canExtractFluid(Direction fromSide, Fluid fluid, int amount);

	default boolean tryInsertFluid(Direction fromSide, Fluid fluid, int amount) {
		if (canInsertFluid(fromSide, fluid, amount)) {
			insertFluid(fromSide, fluid, amount);
			return true;
		}
		return false;
	}

	default boolean tryExtractFluid(Direction fromSide, Fluid fluid, int amount) {
		if (canExtractFluid(fromSide, fluid, amount)) {
			extractFluid(fromSide, fluid, amount);
			return true;
		}
		return false;
	}

	void insertFluid(Direction fromSide, Fluid fluid, int amount);

	void extractFluid(Direction fromSide, Fluid fluid, int amount);

	void setFluid(Direction fromSide, FluidInstance instance);

	FluidInstance[] getFluids(Direction fromSide);
}
