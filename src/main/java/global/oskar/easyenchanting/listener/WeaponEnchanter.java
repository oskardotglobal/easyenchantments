package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.lib.EnchantmentWrapper;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WeaponEnchanter implements Listener {
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void onTryToEnchant(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            Inventory inv = e.getClickedInventory();
            String title = e.getView().getTitle();
            ItemStack enchant = inv.getItem(40);

            if (!title.equals("§5Werkzeuge verzaubern")) return;
            if (enchant == null) return;
            if (!ItemChecker.checkforWeapon(enchant) || enchant.getType() != Material.BOW || enchant.getType() != Material.CROSSBOW) return;

            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§bSharpness": {
                    e.setCancelled(true);

                    if (ItemChecker.checkforWeapon(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Sharpness verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("sharpness", p);
                        ench.enchant(enchant);
                    }

                    break;
                }

                case "§bSmite": {
                    e.setCancelled(true);
                    if (ItemChecker.checkforWeapon(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Smite verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("smite", p);
                        ench.enchant(enchant);
                    }
                    break;
                }

                case "§bBane of Arthopods": {
                    e.setCancelled(true);

                    if (ItemChecker.checkforWeapon(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Bane of Arthopods verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("bane_of_arthopods", p);
                        ench.enchant(enchant);
                    }
                    break;
                }

                case "§bImpaling": {
                    e.setCancelled(true);

                    if (ItemChecker.checkforWeapon(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Impaling verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("impaling", p);
                        ench.enchant(enchant);
                    }

                    break;
                }

                case "§bKnockback": {
                    e.setCancelled(true);

                    if (ItemChecker.checkforSword(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur ein Schwert mit Knockback verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("knockback", p);
                        ench.enchant(enchant);
                    }

                    break;
                }

                case "§bFire Aspect": {
                    e.setCancelled(true);

                    if (!ItemChecker.checkforSword(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur ein Schwert mit Fire Aspect verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("fire_aspect", p);
                        ench.enchant(enchant);
                    }

                    break;
                }

                case "§bLooting": {
                    e.setCancelled(true);

                    if (!ItemChecker.checkforSword(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur ein Schwert mit Looting verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("looting", p);
                        ench.enchant(enchant);
                    }

                    break;
                }

                case "§bSweeping Edge": {
                    e.setCancelled(true);

                    if (!ItemChecker.checkforSword(enchant)) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur ein Schwert mit Sweeping Edge verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("sweeping_edge", p);
                        ench.enchant(enchant);
                    }

                    break;
                }

                case "§bRiptide": {
                    e.setCancelled(true);

                    if (enchant.getType() != Material.TRIDENT) {
                        p.closeInventory();
                        Utils.sendMessage(p, "Du kannst nur einen Trident mit Riptide verzaubern!", ChatColor.RED);
                    } else {
                        EnchantmentWrapper ench = new EnchantmentWrapper("riptide", p);
                        ench.enchant(enchant);
                    }

                    break;
                }

                case "§bUnbreaking": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bCurse of Vanishing": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                    ench.enchant(enchant);
                    break;
                }

                default: {
                    p.closeInventory();
                    Utils.sendMessage(p, "Du kannst hier nur Waffen verzaubern!", ChatColor.RED);
                    break;
                }
            }
        } catch (Exception ignored) {}
    }
}
