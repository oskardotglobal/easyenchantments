package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.EnchantmentWrapper;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ToolEnchanter implements Listener {
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler(ignoreCancelled = true)
    public void onTryToEnchant(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        if (!title.equals(ChatColor.stripColor("Werkzeuge verzaubern"))) return;

        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack enchant = inv.getItem(40);

        if (!Utils.itemExists(enchant)) return;
        if (!Utils.itemExists(e.getCurrentItem())) return;
        if (!ItemChecker.checkforTools(enchant)) return;
        if (e.getCurrentItem().getType() != Material.ENCHANTED_BOOK) return;

        switch (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())) {
            case "Efficiency" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("efficiency", p);
                ench.enchant(enchant);
            }
            case "Silk Touch" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("silk_touch", p);
                ench.enchant(enchant);
            }
            case "Unbreaking" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                ench.enchant(enchant);
            }
            case "Curse of Vanishing" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                ench.enchant(enchant);
            }
            default -> {
                p.closeInventory();
                Utils.sendMessage(p, "Du kannst hier nur Werkzeuge verzaubern!", ChatColor.RED);
            }
        }

    }
}
