package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ToolGUILoader {
    static final FileConfiguration config = Main.plugin.getConfig();

    public static void build(Player p) {
        Inventory gui = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Werkzeuge verzaubern");
        
        for (int i = 0; i <= 53; i++) gui.setItem(i, Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));

        gui.setItem(10, Utils.createEnchantmentSelector("Efficiency"));
        gui.setItem(11, Utils.createEnchantmentSelector("Silk Touch"));
        gui.setItem(12, Utils.createEnchantmentSelector("Curse of Vanishing", "vanishing_curse"));
        gui.setItem(13, Utils.createEnchantmentSelector("Unbreaking"));
        gui.setItem(38, Utils.createItem(Material.BARRIER, 1, "Schliessen"));
        gui.setItem(42, Utils.createItem(Material.WRITTEN_BOOK, 1, "Hilfe"));
        gui.setItem(40, null);

        p.openInventory(gui);
    }
}
