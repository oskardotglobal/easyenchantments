package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvCreator {
  static FileConfiguration config = Main.plugin.getConfig();
  
  public static void InvBuilder(Player p) {
    Inventory inv = Bukkit.createInventory(null, 54, "§5Enchanter");
    int i;
    for (i = 0; i <= 8; i++)
      inv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    for (i = 36; i <= 53; i++)
      inv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(9, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(10, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Protection", "§7Costs: §e" + config.getConfigurationSection("Protection").getInt("Cost_per_level")));
    inv.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Fire-Protection", "§7Costs: §e" + config.getConfigurationSection("Fire_protection").getInt("Cost_per_level")));
    inv.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Blast-Protection", "§7Costs: §e" + config.getConfigurationSection("Blast_protection").getInt("Cost_per_level")));
    inv.setItem(14, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Projectile-Protection", "§7Costs: §e" + config.getConfigurationSection("Projectile_Protection").getInt("Cost_per_level")));
    inv.setItem(15, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Durability", "§7Costs: §e" + config.getConfigurationSection("Durability").getInt("Cost_per_level")));
    inv.setItem(16, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(18, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(19, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(20, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(21, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Feather-Falling", "§7Costs: §e" + config.getConfigurationSection("Feather_falling").getInt("Cost_per_level")));
    inv.setItem(22, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Aqua-Infinity", "§7Costs: §e" + config.getConfigurationSection("Aqua_infinity").getInt("Cost_per_level")));
    inv.setItem(23, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§5Thorns", "§7Costs: §e" + config.getConfigurationSection("Thorns").getInt("Cost_per_level")));
    inv.setItem(24, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(25, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(26, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(27, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(28, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(29, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(30, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(32, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(33, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(34, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    inv.setItem(35, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
    p.openInventory(inv);
  }
}
