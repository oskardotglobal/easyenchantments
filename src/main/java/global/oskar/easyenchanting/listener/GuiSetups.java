package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class GuiSetups implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onClickInTable(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            String title = e.getView().getTitle();

            ItemStack clicked = e.getCurrentItem();
            if (clicked == null) return;

            if ((clicked.getType() == Material.BLACK_STAINED_GLASS_PANE || clicked.getType() == Material.ENCHANTED_BOOK || clicked.getType() == Material.BOOK || clicked.getType() == Material.BARRIER) &&
                    e.getSlot() != 40 && (
                    title.equalsIgnoreCase("Ruestung verzaubern") || title.equalsIgnoreCase("Waffen verzaubern") ||
                            title.equalsIgnoreCase("Werkzeuge verzaubern"))) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 3.0F, 3.0F);
            }
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onCloseTable(InventoryCloseEvent e) {
        try {
            Player p = (Player) e.getPlayer();
            String title = e.getView().getTitle();

            if (title.equalsIgnoreCase("Ruestung verzaubern") || title.equalsIgnoreCase("Waffen verzaubern") ||
                    title.equalsIgnoreCase("Werkzeuge verzaubern"))
                if (e.getInventory().getItem(40) != null) {
                    p.getInventory().addItem(new ItemStack(e.getInventory().getItem(40)));
                    p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
                } else {
                    p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
                }
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onTryToEnchantWithNoItem(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            String title = e.getView().getTitle();

            ItemStack clicked = e.getCurrentItem();
            if (clicked == null) return;


            if ((title.equalsIgnoreCase("Ruestung verzaubern") || title.equalsIgnoreCase("Waffen verzaubern") ||
                    title.equalsIgnoreCase("Werkzeuge verzaubern")) &&
                    clicked.getType().equals(Material.ENCHANTED_BOOK) &&
                    clicked.getType() != Material.BLACK_STAINED_GLASS_PANE &&
                    !ItemChecker.checkforEnchantable(clicked))
                if (e.getClickedInventory().getItem(40) != null) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                    p.closeInventory();
                    Utils.sendMessage(p, "Du musst ein Item in das Menue legen!", ChatColor.RED);
                }
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
