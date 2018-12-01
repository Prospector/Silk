package prospector.silk.util;

import net.minecraft.nbt.CompoundTag;

public interface Serializable {

	public CompoundTag serialize(CompoundTag tag);

	public void deserialize(CompoundTag tag);
}
