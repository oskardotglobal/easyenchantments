package global.oskar.easyenchanting.listener;

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
        if (!title.equals(ChatColor.stripColor("Ruestung verzaubern"))) return;

        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack enchant = inv.getItem(40);

        if (!Utils.itemExists(enchant)) return;
        if (!Utils.itemExists(e.getCurrentItem())) return;
        if (!ItemChecker.checkforArmor(enchant)) return;
        if (e.getCurrentItem().getType() != Material.ENCHANTED_BOOK) return;

        switch (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())) {
            case "Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("protection", p);
                ench.enchant(enchant);
            }
            case "Fire Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("fire_protection", p);
                ench.enchant(enchant);
            }
            case "Blast Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("blast_protection", p);
                ench.enchant(enchant);
            }
            case "Projectile Protection" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("projectile_protection", p);
                ench.enchant(enchant);
            }
            case "Feather Falling" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("feather_falling", p);
                ench.enchant(enchant);
            }
            case "Swift Sneak" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("swift_sneak", p);
                ench.enchant(enchant);
            }
            case "Soul Speed" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("soul_speed", p);
                ench.enchant(enchant);
            }
            case "Respiration" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("respiration", p);
                ench.enchant(enchant);
            }
            case "Aqua Affinity" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("aqua_affinity", p);
                ench.enchant(enchant);
            }
            case "Curse of Vanishing" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                ench.enchant(enchant);
            }
            case "Unbreaking" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                ench.enchant(enchant);
            }
            case "Depth Strider" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("depth_strider", p);
                ench.enchant(enchant);
            }
            case "Frost Walker" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("frost_walker", p);
                ench.enchant(enchant);
            }
            case "Thorns" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("thorns", p);
                ench.enchant(enchant);
            }
            case "Curse of Binding" -> {
                e.setCancelled(true);
                EnchantmentWrapper ench = new EnchantmentWrapper("binding_curse", p);
                ench.enchant(enchant);
            }
            default -> {
                p.closeInventory();
                Utils.sendMessage(p, "Du kannst hier nur Ruestung verzaubern!", ChatColor.RED);
            }
        }
    }
}
