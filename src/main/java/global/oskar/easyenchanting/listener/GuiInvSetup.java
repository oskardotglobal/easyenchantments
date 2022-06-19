package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.ArmorGuiLoader;
import global.oskar.easyenchanting.utils.ToolGuiLoader;
import global.oskar.easyenchanting.utils.Utils;
import global.oskar.easyenchanting.utils.WeaponGuiLoader;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class GuiInvSetup implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onChooseOption(InventoryClickEvent e) {
        try {
            Player p = (Player)e.getWhoClicked();
            ArrayList<String> invs = new ArrayList<String>();

            invs.add("Ruestung verzaubern");
            invs.add("Werkzeuge verzaubern");
            invs.add("Waffen verzaubern");

            ItemStack clicked = e.getCurrentItem();
            if (clicked == null) return;

            if (invs.contains(e.getView().getTitle())) {
                if (clicked.getType() == Material.WRITTEN_BOOK) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Utils.openHelp(p);
                    return;
                }
                if (clicked.getType() == Material.BARRIER) {
                    e.setCancelled(true);
                    p.closeInventory();
                    return;
                }
            }

            if (e.getView().getTitle().equalsIgnoreCase("Zaubertisch")) {
                e.setCancelled(true);

                switch (clicked.getItemMeta().getDisplayName()) {
                    case "Ruestung verzaubern" -> {
                        ArmorGuiLoader.BuildArmorInv(p);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
                    }
                    case "Waffen verzaubern" -> {
                        WeaponGuiLoader.BuildWeaponInv(p);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
                    }
                    case "Werkzeuge verzaubern" -> {
                        ToolGuiLoader.BuildToolInv(p);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
                    }
                    default -> {
                        if (clicked.getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                            p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, Arrays.toString(ex.getStackTrace()) + ex.getMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onCloseGui(InventoryCloseEvent e) {
        try {
            Player p = (Player)e.getPlayer();
            if (e.getView().getTitle().equalsIgnoreCase("Zaubertisch"))
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 3.0F, 3.0F);
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
