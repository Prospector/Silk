package prospector.silk.util;

import net.minecraft.nbt.CompoundTag;

public interface TagSerializable<T> {

	public CompoundTag toTag(CompoundTag tag);

	public void fromTag(CompoundTag tag);
}
