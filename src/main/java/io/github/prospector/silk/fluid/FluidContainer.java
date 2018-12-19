package io.github.prospector.silk.fluid;

import io.github.prospector.silk.util.ContainerInteraction;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.Direction;

public interface FluidContainer {

	int getMaxCapacity();

	default int getCurrentFill(Direction fromSide) {
		int amount = 0;
		for (FluidInstance inst : getFluids(fromSide)) {
			amount += inst.amount;
		}
		return amount;
	}

	default int getCurrentSingleFluidFill(Direction fromSide, Fluid fluid) {
		int amount = 0;
		for (FluidInstance inst : getFluids(fromSide)) {
			if (inst.fluid == fluid) amount += inst.amount;
		}
		return amount;
	}

	boolean canInsertFluid(Direction fromSide, Fluid fluid, int amount);

	boolean canExtractFluid(Direction fromSide, Fluid fluid, int amount);

	/**
	 * Attempt to insert fluid on an all-or-nothing basis.
	 * @param fromSide the side from which to insert.
	 * @param fluid the type of fluid to insert.
	 * @param amount how much fluid to insert.
	 * @param interaction whether to SIMULATE or EXECUTE insertion.
	 * @return whether the insertion was/would be successful.
	 */
	default boolean tryInsertFluid(Direction fromSide, Fluid fluid, int amount, ContainerInteraction interaction) {
		if (canInsertFluid(fromSide, fluid, amount)) {
			if (interaction == ContainerInteraction.EXECUTE) insertFluid(fromSide, fluid, amount);
			return true;
		}
		return false;
	}

	/**
	 * Attempt to insert fluid, only filling partially if the container can't hold all the fluid.
	 * @param fromSide the side from which to insert.
	 * @param fluid the type of fluid to insert.
	 * @param maxAmount how much fluid to insert at maximum.
	 * @param interaction whether to SIMULATE or EXECUTE insertion.
	 * @return an integer amount of how much fluid was/would be moved.
	 */
	default int tryPartialInsertFluid(Direction fromSide, Fluid fluid, int maxAmount, ContainerInteraction interaction) {
		int remainingCapacity = getMaxCapacity() - getCurrentFill(fromSide);
		int amount = maxAmount <= remainingCapacity ? maxAmount : remainingCapacity;
		if (canInsertFluid(fromSide, fluid, amount)) {
			if (interaction == ContainerInteraction.EXECUTE) insertFluid(fromSide, fluid, amount);
			return amount;
		}
		return 0;
	}

	/**
	 * Attempt to extract fluid on an all-or-nothing basis.
	 * @param fromSide the side from which to extract.
	 * @param fluid the type of fluid to extract.
	 * @param amount how much fluid to extract.
	 * @param interaction whether to SIMULATE or EXECUTE extraction.
	 * @return whether the extraction was/would be successful.
	 */
	default boolean tryExtractFluid(Direction fromSide, Fluid fluid, int amount, ContainerInteraction interaction) {
		if (canExtractFluid(fromSide, fluid, amount)) {
			if (interaction == ContainerInteraction.EXECUTE) extractFluid(fromSide, fluid, amount);
			return true;
		}
		return false;
	}

	/**
	 * Attempt to extract fluid, only emptying partially if the container doesn't have enough fluid.
	 * @param fromSide the side from which to extract.
	 * @param fluid the type of fluid to extract.
	 * @param maxAmount how much fluid to extract at maximum.
	 * @param interaction whether to SIMULATE or EXECUTE extraction.
	 * @return an integer amount of how much fluid was/would be moved.
	 */
	default int tryPartialExtractFluid(Direction fromSide, Fluid fluid, int maxAmount, ContainerInteraction interaction) {
		int remainingFluid = getCurrentSingleFluidFill(fromSide, fluid);
		int amount = maxAmount <= remainingFluid ? maxAmount : remainingFluid;
		if (canExtractFluid(fromSide, fluid, amount)) {
			if (interaction == ContainerInteraction.EXECUTE) extractFluid(fromSide, fluid, amount);
			return amount;
		}
		return 0;
	}

	void insertFluid(Direction fromSide, Fluid fluid, int amount);

	void extractFluid(Direction fromSide, Fluid fluid, int amount);

	void setFluid(Direction fromSide, FluidInstance instance);

	FluidInstance[] getFluids(Direction fromSide);
}
