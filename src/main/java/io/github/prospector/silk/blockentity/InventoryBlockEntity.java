package io.github.prospector.silk.blockentity;

import io.github.prospector.silk.util.ItemUtils;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.TextComponent;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.InventoryUtil;

public abstract class InventoryBlockEntity extends BlockEntity implements Inventory {

	private DefaultedList<ItemStack> inventory = DefaultedList.create(getInvSize(), ItemStack.EMPTY);

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
		return InventoryUtil.splitStack(this.inventory, slot, amount);
	}

	@Override
	public ItemStack removeInvStack(int slot) {
		return InventoryUtil.removeStack(this.inventory, slot);
	}

	@Override
	public void setInvStack(int slot, ItemStack itemStack) {
		this.inventory.set(slot, itemStack);
		if (itemStack.getAmount() > this.getInvMaxStackAmount()) {
			itemStack.setAmount(this.getInvMaxStackAmount());
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
	public int getInvProperty(int i) {
		return 0;
	}

	@Override
	public void setInvProperty(int i, int i1) {

	}

	@Override
	public int getInvPropertyCount() {
		return 0;
	}

	@Override
	public void clearInv() {
		inventory.clear();
	}

	@Override
	public TextComponent getName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}
}
