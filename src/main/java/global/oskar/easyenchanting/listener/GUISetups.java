package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.utils.ArmorGUILoader;
import global.oskar.easyenchanting.utils.ToolGUILoader;
import global.oskar.easyenchanting.utils.Utils;
import global.oskar.easyenchanting.utils.WeaponGUILoader;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class GUISetups implements Listener {
    private static final Set<Material> process = Set.of(
            Material.BLACK_STAINED_GLASS_PANE,
            Material.ENCHANTED_BOOK,
            Material.WRITTEN_BOOK,
            Material.BARRIER
    );

    @EventHandler(ignoreCancelled = true)
    public void onClickInTable(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        String title = e.getView().getTitle();

        if (!Utils.isCustomInventory(title)) return;

        ItemStack clicked = e.getCurrentItem();
        if (!Utils.itemExists(clicked)) return;
        if (!process.contains(clicked.getType())) return;
        if (e.getSlot() == 40) return;

        e.setCancelled(true);
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 3.0F, 3.0F);

        if (clicked.getType() == Material.WRITTEN_BOOK) {
            p.closeInventory();
            Utils.openHelp(p);
        } else if (clicked.getType() == Material.BARRIER) {
            p.closeInventory();
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onCloseTable(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        String title = e.getView().getTitle();

        if (title.equalsIgnoreCase("Zaubertisch")) {
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 3.0F, 3.0F);
            return;
        }

        if (Utils.isCustomInventory(title)) {
            ItemStack item = e.getInventory().getItem(40);
            if (Utils.itemExists(item)) p.getInventory().addItem(new ItemStack(item));
            p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onTryToEnchantWithNoItem(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        String title = e.getView().getTitle();

        ItemStack clicked = e.getCurrentItem();
        if (!Utils.itemExists(clicked)) return;
        if (!Utils.isCustomInventory(title)) return;
        if (clicked.getType() != Material.ENCHANTED_BOOK) return;

        ItemStack item = e.getInventory().getItem(40);
        if (!Utils.itemExists(item)) {
            e.setCancelled(true);
            p.closeInventory();
            Utils.sendMessage(p, "Du musst ein Item in das Menue legen!", ChatColor.RED);
        }
    }
}
