package global.oskar.easyenchanting.listener;

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

public class GuiSetups implements Listener {
    @EventHandler
    public void onClickInTable(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            String title = e.getView().getTitle();

            if ((e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.ENCHANTED_BOOK || e.getCurrentItem().getType() == Material.BOOK || e.getCurrentItem().getType() == Material.BARRIER) &&
                    e.getSlot() != 40 && (
                    title.equalsIgnoreCase("§5Rüstung verzaubern") || title.equalsIgnoreCase("§5Waffen verzaubern") ||
                            title.equalsIgnoreCase("§5Werkzeuge verzaubern"))) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 3.0F, 3.0F);
            }
        } catch (Exception ignored) {}
    }

    @EventHandler
    public void onCloseTable(InventoryCloseEvent e) {
        try {
            Player p = (Player) e.getPlayer();
            String title = e.getView().getTitle();

            if (title.equalsIgnoreCase("§5Rüstung verzaubern") || title.equalsIgnoreCase("§5Waffen verzaubern") ||
                    title.equalsIgnoreCase("§Werkzeuge verzaubern"))
                if (e.getInventory().getItem(40) != null) {
                    p.getInventory().addItem(new ItemStack(e.getInventory().getItem(40)));
                    p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
                } else {
                    p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
                }
        } catch (Exception ignored) {}
    }

    @EventHandler
    public void onTryToEnchantWithNoItem(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            String title = e.getView().getTitle();

            if ((title.equalsIgnoreCase("§5Rüstung verzaubern") || title.equalsIgnoreCase("§5Waffen verzaubern") ||
                    title.equalsIgnoreCase("§Werkzeuge verzaubern")) &&
                    e.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK) &&
                    e.getCurrentItem().getType() != Material.BLACK_STAINED_GLASS_PANE &&
                    !e.getCurrentItem().getType().equals(Boolean.valueOf(ItemChecker.checkforArmor(e.getCurrentItem()))) &&
                    !e.getCurrentItem().getType().equals(Boolean.valueOf(ItemChecker.checkforTools(e.getCurrentItem()))) &&
                    !e.getCurrentItem().getType().equals(Boolean.valueOf(ItemChecker.checkforWeapon(e.getCurrentItem()))))
                if (e.getClickedInventory().getItem(40) != null) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                    p.closeInventory();
                    Utils.sendMessage(p, "Du musst ein Item in das Menü legen!", ChatColor.RED);
                }
        } catch (Exception ignored) {}
    }
}
