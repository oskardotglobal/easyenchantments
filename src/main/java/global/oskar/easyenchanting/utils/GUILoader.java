package global.oskar.easyenchanting.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUILoader {
    public static void build(Player p) {
            Inventory gui = Bukkit.createInventory(null, 27, "Zaubertisch");

            for (int i = 0; i <= 26; i++) gui.setItem(i, Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));

            gui.setItem(10, Utils.createItem(Material.EXPERIENCE_BOTTLE, 1, "Dein Level: " + p.getLevel()));
            gui.setItem(12, Utils.createItem(Material.GOLDEN_PICKAXE, 1, ChatColor.DARK_PURPLE + "Werkzeuge verzaubern"));
            gui.setItem(14, Utils.createItem(Material.GOLDEN_SWORD, 1, ChatColor.DARK_PURPLE + "Waffen verzaubern"));
            gui.setItem(16, Utils.createItem(Material.GOLDEN_CHESTPLATE, 1, ChatColor.DARK_PURPLE + "Ruestung verzaubern"));

            p.openInventory(gui);

    }
}
