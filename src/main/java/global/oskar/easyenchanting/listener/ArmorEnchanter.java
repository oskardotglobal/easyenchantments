package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.lib.EnchantmentWrapper;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ArmorEnchanter implements Listener {
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler(ignoreCancelled = true)
    public void onTryToEnchant(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            Inventory inv = e.getClickedInventory();
            String title = e.getView().getTitle();
            ItemStack enchant = inv.getItem(40);

            if (!title.equals("§5Rüstung verzaubern")) return;
            if (enchant == null) return;
            if (!ItemChecker.checkforArmor(enchant)) return;

            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§bProtection": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("protection", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bFire Protection": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("fire_protection", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bBlast Protection": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("blast_protection", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bProjectile Protection": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("projectile_protection", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bFeather Falling": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("feather_falling", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bRespiration": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("respiration", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bAqua Affinity": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("aqua_affinity", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bCurse of Vanishing": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bUnbreaking": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bDepth Strider": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("depth_strider", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bFrost Walker": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("frost_walker", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bThorns": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("thorns", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bCurse of Binding": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("binding_curse", p);
                    ench.enchant(enchant);
                    break;
                }

                default: {
                    p.closeInventory();
                    Utils.sendMessage(p, "Du kannst hier nur Rüstung verzaubern!", ChatColor.RED);
                    break;
                }
            }
        } catch (Exception ignored) {}
    }
}
