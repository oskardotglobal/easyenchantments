package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ToolGuiLoader {
  static FileConfiguration config = Main.plugin.getConfig();
  
  public static void BuildToolInv(Player p) {
    Inventory toolinv = Bukkit.createInventory(null, 54, "§5Werkzeuge verzaubern");
    int i;
    for (i = 0; i <= 8; i++)
      toolinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
    for (i = 16; i <= 37; i++)
      toolinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
    for (i = 43; i <= 53; i++)
      toolinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
    toolinv.setItem(9, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bEfficiency", "§7Cost: §e" + config.getConfigurationSection("efficiency").getInt("cost")));
    toolinv.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSilk Touch", "§7Cost: §e" + config.getConfigurationSection("silk_touch").getInt("cost")));
    toolinv.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bCurse of Vanishing", "§7Cost: §e" + config.getConfigurationSection("vanishing_curse").getInt("cost")));
    toolinv.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bUnbreaking", "§7Cost: §e" + config.getConfigurationSection("unbreaking").getInt("cost")));
    toolinv.setItem(38, ItemCreator.ItemBuilder(Material.BARRIER, 1, "§cSchließen"));
    toolinv.setItem(39, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(41, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(42, ItemCreator.ItemBuilder(Material.WRITTEN_BOOK, 1, "§2Hilfe"));
    p.openInventory(toolinv);
  }
}
