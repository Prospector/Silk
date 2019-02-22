package io.github.prospector.silk.util;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class VoxelShapeUtil {
	public static VoxelShape rotateHorizontal(int minX, int minY, int minZ, int maxX, int maxY, int maxZ, Rotation rot) {
		return Block.createCuboidShape(
			rot.getX(minX, minZ), rot.getX(maxX, maxZ), minY, maxY,
			rot.getZ(minX, minZ), rot.getZ(maxX, maxZ)
		);
	}

	public enum Axis {
		X, Y, Z;
	}

	public enum Rotation {
		NONE(1, 0, 0, 1),
		CLOCKWISE_90(0, 1, -1, 0),
		CLOCKWISE_180(-1, 0, 0, -1),
		COUNTERCLOCKWISE_90(0, -1, 1, 0);

		private final double xx, xz, zx, zz;

		Rotation(double xx, double xz, double zx, double zz) {
			this.xx = xx;
			this.xz = xz;
			this.zx = zx;
			this.zz = zz;
		}

		public final double getX(double x, double z) {
			return x * xx + z * xz;
		}

		public final double getZ(double x, double z) {
			return x * zx + z * zz;
		}
	}
}
