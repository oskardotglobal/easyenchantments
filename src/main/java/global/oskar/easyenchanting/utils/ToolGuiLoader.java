package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ToolGuiLoader {
    static final FileConfiguration config = Main.plugin.getConfig();

    public static void BuildToolInv(Player p) {
        Inventory gui = Bukkit.createInventory(null, 54, "Werkzeuge verzaubern");
        
        for (int i = 0; i <= 53; i++) gui.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "s"));

        gui.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Efficiency", "Cost: " + config.getConfigurationSection("efficiency").getInt("cost")));
        gui.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Silk Touch", "Cost: " + config.getConfigurationSection("silk_touch").getInt("cost")));
        gui.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Curse of Vanishing", "Cost: " + config.getConfigurationSection("vanishing_curse").getInt("cost")));
        gui.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Unbreaking", "Cost: " + config.getConfigurationSection("unbreaking").getInt("cost")));
        gui.setItem(38, ItemCreator.ItemBuilder(Material.BARRIER, 1, "Schliessen"));
        gui.setItem(42, ItemCreator.ItemBuilder(Material.WRITTEN_BOOK, 1, "Hilfe"));
        gui.setItem(40, null);

        p.openInventory(gui);
    }
}
