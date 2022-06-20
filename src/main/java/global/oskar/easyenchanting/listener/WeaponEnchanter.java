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

public class WeaponEnchanter implements Listener {
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler(ignoreCancelled = true)
    public void onTryToEnchant(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        if (!ChatColor.stripColor(title).equals("Waffen verzaubern")) return;

        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack enchant = inv.getItem(40);
        ItemStack clicked = e.getClickedInventory().getItem(e.getSlot());

        if (!Utils.itemExists(enchant)) return;
        if (!Utils.itemExists(clicked)) return;
        if (!ItemChecker.checkforWeapon(enchant) || enchant.getType() != Material.BOW || enchant.getType() != Material.CROSSBOW) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Du kannst hier nur Waffen verzaubern!", ChatColor.RED);
            return;
        }

        if (clicked.getType() != Material.ENCHANTED_BOOK) return;

        switch (ChatColor.stripColor(clicked.getItemMeta().getDisplayName())) {
            case "Sharpness" -> {
                e.setCancelled(true);

                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Sharpness verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("sharpness", p);
                    ench.enchant(enchant);
                }
                break;

            }
            case "Smite" -> {
                e.setCancelled(true);
                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Smite verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("smite", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Bane of Arthropods" -> {
                e.setCancelled(true);

                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Bane of Arthropods verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("bane_of_arthropods", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Impaling" -> {
                e.setCancelled(true);

                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Impaling verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("impaling", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Knockback" -> {
                e.setCancelled(true);

                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Knockback verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("knockback", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Fire Aspect" -> {
                e.setCancelled(true);

                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Fire Aspect verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("fire_aspect", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Looting" -> {
                e.setCancelled(true);

                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Looting verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("looting", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Sweeping Edge" -> {
                e.setCancelled(true);

                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Sweeping Edge verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("sweeping", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Riptide" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.TRIDENT) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Trident mit Riptide verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("riptide", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Channeling" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.TRIDENT) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Trident mit Channeling verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("channeling", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Flame" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Flame verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("flame", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Infinity" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Infinity verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("infinity", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Loyalty" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.TRIDENT) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Trident mit Loyalty verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("loyalty", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Multishot" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.CROSSBOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Crossbow mit Multishot verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("multishot", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Piercing" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.BOW || enchant.getType() != Material.CROSSBOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen oder einen Crossbow mit Piercing verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("piercing", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Power" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Power verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("power", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Punch" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Punch verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("punch", p);
                    ench.enchant(enchant);
                }
                break;
            }
            case "Quick Charge" -> {
                e.setCancelled(true);

                if (enchant.getType() != Material.CROSSBOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Crossbow mit Quick Charge verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("quick_charge", p);
                    ench.enchant(enchant);
                }
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
