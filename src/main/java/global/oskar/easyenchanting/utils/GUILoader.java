package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.logging.Level;

public class GUILoader {
    public static void GuiBuilder(Player p) {
        try {
            Inventory gui = Bukkit.createInventory(null, 27, "§7Zaubertisch");
            int i;
            for (i = 0; i <= 8; i++)
                gui.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            for (i = 18; i <= 26; i++) {
                gui.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            }
            gui.setItem(9, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            gui.setItem(10, ItemCreator.ItemBuilder(Material.EXPERIENCE_BOTTLE, 1, "§7Dein Level: §a" + p.getLevel()));
            gui.setItem(11, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            gui.setItem(12, ItemCreator.ItemBuilder(Material.GOLDEN_PICKAXE, 1, "§5Werkzeuge verzaubern"));
            gui.setItem(13, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            gui.setItem(14, ItemCreator.ItemBuilder(Material.GOLDEN_SWORD, 1, "§5Waffen verzaubern"));
            gui.setItem(15, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            gui.setItem(16, ItemCreator.ItemBuilder(Material.GOLDEN_CHESTPLATE, 1, "§5Rüstung verzaubern"));
            gui.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            p.openInventory(gui);
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
