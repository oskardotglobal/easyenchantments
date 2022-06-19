package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.ArmorGuiLoader;
import global.oskar.easyenchanting.utils.ToolGuiLoader;
import global.oskar.easyenchanting.utils.WeaponGuiLoader;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class GuiInvSetup implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onChooseOption(InventoryClickEvent e) {
        try {
            Player p = (Player)e.getWhoClicked();
            if (e.getView().getTitle().equalsIgnoreCase("§7Zaubertisch")) {
                e.setCancelled(true);

                ItemStack item = e.getCurrentItem();
                if (item == null) return;

                switch (item.getItemMeta().getDisplayName()) {
                    case "§5Rüstung verzaubern" -> {
                        ArmorGuiLoader.BuildArmorInv(p);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
                        break;
                    }
                    case "§5Waffen verzaubern" -> {
                        WeaponGuiLoader.BuildWeaponInv(p);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
                        break;
                    }
                    case "§5Werkzeuge verzaubern" -> {
                        ToolGuiLoader.BuildToolInv(p);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
                        break;
                    }
                    default -> {
                        if (item.getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                            p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
                        }
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onCloseGui(InventoryCloseEvent e) {
        try {
            Player p = (Player)e.getPlayer();
            if (e.getView().getTitle().equalsIgnoreCase("§7Zaubertisch"))
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 3.0F, 3.0F);
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
