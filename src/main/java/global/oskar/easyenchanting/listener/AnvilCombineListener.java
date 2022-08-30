package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.utils.ItemChecker;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

public class AnvilCombineListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onAnvilCombine(InventoryClickEvent e) {
        if (!(e.getInventory() instanceof AnvilInventory)) return;
        if (e.getSlotType() != InventoryType.SlotType.RESULT) return;

        ItemStack item2 = e.getInventory().getItem(1);
        if (item2 == null) return;

        ItemStack item = e.getInventory().getItem(0);
        assert item != null;

        if ((ItemChecker.checkforEnchantable(item2) || item2.getType().equals(Material.ENCHANTED_BOOK)) && item.getEnchantments().size() == 3) { e.setCancelled(true); return; }
        if ((item2.getEnchantments().size() + item.getEnchantments().size()) > 3) e.setCancelled(true);
    }
}
