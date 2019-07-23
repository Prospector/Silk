package io.github.prospector.silk.blockentity;

import io.github.prospector.silk.util.ItemUtils;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;

public abstract class InventoryBlockEntity extends BlockEntity implements Inventory {

	private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(getInvSize(), ItemStack.EMPTY);

	@Override
	public void fromTag(CompoundTag compoundTag) {
		ItemUtils.inventoryFromTag(this, "Inventory", compoundTag);
		super.fromTag(compoundTag);
	}

	@Override
	public CompoundTag toTag(CompoundTag compoundTag) {
		ItemUtils.inventoryToTag(this, "Inventory", compoundTag);
		return super.toTag(compoundTag);
	}

	public InventoryBlockEntity(BlockEntityType<?> blockEntityType) {
		super(blockEntityType);
	}

	@Override
	public boolean isInvEmpty() {
		return inventory.stream().anyMatch(ItemStack::isEmpty);
	}

	@Override
	public ItemStack getInvStack(int slot) {
		return inventory.get(slot);
	}

	@Override
	public ItemStack takeInvStack(int slot, int amount) {
		return Inventories.splitStack(this.inventory, slot, amount);
	}

	@Override
	public ItemStack removeInvStack(int slot) {
		return Inventories.removeStack(this.inventory, slot);
	}

	@Override
	public void setInvStack(int slot, ItemStack itemStack) {
		this.inventory.set(slot, itemStack);
		if (itemStack.getCount() > this.getInvMaxStackAmount()) {
			itemStack.setCount(this.getInvMaxStackAmount());
		}
	}

	@Override
	public int getInvMaxStackAmount() {
		return 64;
	}

	@Override
	public boolean canPlayerUseInv(PlayerEntity playerEntity) {
		return true;
	}

	@Override
	public void onInvOpen(PlayerEntity playerEntity) {

	}

	@Override
	public void onInvClose(PlayerEntity playerEntity) {

	}

	@Override
	public boolean isValidInvStack(int i, ItemStack itemStack) {
		return true;
	}

	@Override
	public void clear() {
		inventory.clear();
	}
}
