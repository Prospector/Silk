package io.github.prospector.silk.category;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ItemCategories {
	protected static Map<String, List<ItemStack>> categories;

	public static void add(String category, ItemStack... stacks) {
		List<ItemStack> categoryStacks = categories.get(category);
		if (categoryStacks == null) {
			categoryStacks = new ArrayList<>();
		}
		categoryStacks.addAll(Arrays.asList(stacks));
	}

	public static void loadCategories() {

	}
}
