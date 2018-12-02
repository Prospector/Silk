package prospector.silk.util;

import net.minecraft.nbt.CompoundTag;

public interface Serializable<T> {

	public CompoundTag serialize(CompoundTag tag);

	public void deserialize(CompoundTag tag);
}
