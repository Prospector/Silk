package io.github.prospector.silk.client.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GuiLighting;
import net.minecraft.item.ItemStack;

public class DrawingUtil {
	public static void drawItemStack(ItemStack stack, int x, int y) {
		GuiLighting.enableForItems();
		MinecraftClient.getInstance().getItemRenderer().renderGuiItem(stack, x, y);
	}
}
