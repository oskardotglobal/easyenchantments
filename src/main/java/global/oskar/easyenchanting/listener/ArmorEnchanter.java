package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.EnchantmentWrapper;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ArmorEnchanter implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onTryToEnchant(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        if (!ChatColor.stripColor(title).equals("Ruestung verzaubern")) return;

        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack enchant = inv.getItem(40);
        ItemStack clicked = e.getClickedInventory().getItem(e.getSlot());

        Main.log.warning(ChatColor.stripColor(clicked.getItemMeta().getDisplayName()));

        if (!Utils.itemExists(enchant)) return;
        if (!Utils.itemExists(clicked)) return;
        if (!ItemChecker.checkforArmor(enchant)) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Du kannst hier nur Ruestung verzaubern!", ChatColor.RED);
            return;
        }
        if (clicked.getType() != Material.ENCHANTED_BOOK) return;

        switch (ChatColor.stripColor(clicked.getItemMeta().getDisplayName())) {
            case "Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("protection", p);
                ench.enchant(enchant);
                break;
            }

            case "Fire Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("fire_protection", p);
                ench.enchant(enchant);
                break;
            }
            case "Blast Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("blast_protection", p);
                ench.enchant(enchant);
                break;
            }
            case "Projectile Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("projectile_protection", p);
                ench.enchant(enchant);
                break;
            }
            case "Feather Falling" -> {
                e.setCancelled(true);
                if (!ItemChecker.checkforBoots(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Schuhe mit Feather Falling verzaubern!", ChatColor.RED);
                    break;
                }
                EnchantmentWrapper ench = new EnchantmentWrapper("feather_falling", p);
                ench.enchant(enchant);
                break;
            }
            case "Respiration" -> {
                e.setCancelled(true);
                if (!ItemChecker.checkForHelmet(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Helm mit Respiration verzaubern!", ChatColor.RED);
                    break;
                }
                EnchantmentWrapper ench = new EnchantmentWrapper("respiration", p);
                ench.enchant(enchant);
                break;
            }
            case "Aqua Affinity" -> {
                e.setCancelled(true);
                if (!ItemChecker.checkForHelmet(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Helm mit Aqua Affinity verzaubern!", ChatColor.RED);
                    break;
                }
                EnchantmentWrapper ench = new EnchantmentWrapper("aqua_affinity", p);
                ench.enchant(enchant);
                break;
            }
            case "Curse of Vanishing" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                ench.enchant(enchant);
                break;
            }
            case "Unbreaking" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                ench.enchant(enchant);
                break;
            }
            case "Depth Strider" -> {
                e.setCancelled(true);
                if (!ItemChecker.checkforBoots(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Schuhe mit Depth Strider verzaubern!", ChatColor.RED);
                    break;
                }
                EnchantmentWrapper ench = new EnchantmentWrapper("depth_strider", p);
                ench.enchant(enchant);
                break;
            }
            case "Frost Walker" -> {
                e.setCancelled(true);
                if (!ItemChecker.checkforBoots(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Schuhe mit Frost Walker verzaubern!", ChatColor.RED);
                    break;
                }
                EnchantmentWrapper ench = new EnchantmentWrapper("frost_walker", p);
                ench.enchant(enchant);
                break;
            }
            case "Thorns" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("thorns", p);
                break;
            }
            case "Curse of Binding" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("binding_curse", p);
                ench.enchant(enchant);
                break;
            }
            default -> {
                e.setCancelled(true);
                Utils.closeInventory(p);
                Utils.sendMessage(p, "Du musst ein Item in das Menu legen!", ChatColor.RED);
                break;
            }
        }
    }
}
