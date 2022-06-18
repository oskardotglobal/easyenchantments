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
    Inventory toolinv = Bukkit.createInventory(null, 54, "§5Tool-enchanting");
    int i;
    for (i = 0; i <= 8; i++)
      toolinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
    for (i = 27; i <= 35; i++)
      toolinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
    for (i = 45; i <= 53; i++)
      toolinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
    toolinv.setItem(9, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bEfficiency", "§7Cost: §e" + config.getConfigurationSection("Efficiency").getInt("Cost_per_level")));
    toolinv.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSilk Touch", "§7Cost: §e" + config.getConfigurationSection("Silk_Touch").getInt("Cost_per_level")));
    toolinv.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bFortune", "§7Cost: §e" + config.getConfigurationSection("Fortune").getInt("Cost_per_level")));
    toolinv.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bMending", "§7Cost: §e" + config.getConfigurationSection("Mending").getInt("Cost_per_level")));
    toolinv.setItem(14, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bCurse of Vanishing", "§7Cost: §e" + config.getConfigurationSection("Curse_of_Vanishing").getInt("Cost_per_level")));
    toolinv.setItem(15, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bUnbreaking", "§7Cost: §e" + config.getConfigurationSection("Unbreaking").getInt("Cost_per_level")));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(18, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(26, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(36, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(37, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(38, ItemCreator.ItemBuilder(Material.BARRIER, 1, "§c?"));
    toolinv.setItem(39, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(41, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(42, ItemCreator.ItemBuilder(Material.BARRIER, 1, "§c?"));
    toolinv.setItem(43, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    toolinv.setItem(44, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    p.openInventory(toolinv);
  }
}
