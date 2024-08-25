package me.gregzee.chatcolorplus.inventory;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class ColorPickerMenu implements InventoryHolder {

	private Inventory colorPickerMenu;

	@Override
	public @NotNull Inventory getInventory() {
		return colorPickerMenu;
	}
}
