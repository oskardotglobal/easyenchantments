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
            Inventory gui = Bukkit.createInventory(null, 27, "Zaubertisch");

            for (int i = 0; i <= 26; i++) gui.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "s"));

            gui.setItem(10, ItemCreator.ItemBuilder(Material.EXPERIENCE_BOTTLE, 1, "Dein Level: " + p.getLevel()));
            gui.setItem(12, ItemCreator.ItemBuilder(Material.GOLDEN_PICKAXE, 1, "Werkzeuge verzaubern"));
            gui.setItem(14, ItemCreator.ItemBuilder(Material.GOLDEN_SWORD, 1, "Waffen verzaubern"));
            gui.setItem(16, ItemCreator.ItemBuilder(Material.GOLDEN_CHESTPLATE, 1, "Ruestung verzaubern"));

            p.openInventory(gui);
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
