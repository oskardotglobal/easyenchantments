package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.EnchantmentWrapper;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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
        if (!ChatColor.stripColor(title).equals("Werkzeuge verzaubern")) return;

        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack enchant = inv.getItem(40);
        ItemStack clicked = e.getClickedInventory().getItem(e.getSlot());

        if (!Utils.itemExists(enchant)) return;
        if (!Utils.itemExists(clicked)) return;
        if (!ItemChecker.checkforTools(enchant)) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Du kannst hier nur Werkzeuge verzaubern!", ChatColor.RED);
            return;
        }
        if (clicked.getType() != Material.ENCHANTED_BOOK) return;

        Main.log.warning("Passed checks");

        switch (ChatColor.stripColor(clicked.getItemMeta().getDisplayName())) {
            case "Efficiency" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("efficiency", p);
                ench.enchant(enchant);
                break;
            }
            case "Silk Touch" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("silk_touch", p);
                ench.enchant(enchant);
                break;
            }
            case "Unbreaking" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                ench.enchant(enchant);
                break;
            }
            case "Curse of Vanishing" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                ench.enchant(enchant);
                break;
            }
            default -> {
                e.setCancelled(true);
                Utils.closeInventory(p);
                Utils.sendMessage(p, "Du musst ein Item in das Menü legen!", ChatColor.RED);
                break;
            }
        }

    }
}
