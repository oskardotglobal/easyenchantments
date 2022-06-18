package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class WeaponGuiLoader {
  static FileConfiguration config = Main.plugin.getConfig();
  
  public static void BuildWeaponInv(Player p) {
    try {
      Inventory weaponinv = Bukkit.createInventory(null, 54, "§5Weapon-enchanting");
      int i;
      for (i = 0; i <= 8; i++)
        weaponinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
      for (i = 27; i <= 35; i++)
        weaponinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
      for (i = 45; i <= 53; i++)
        weaponinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
      weaponinv.setItem(9, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSharpness", "§7Cost: §e" + config.getConfigurationSection("Sharpness").getInt("Cost_per_level")));
      weaponinv.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSmite", "§7Cost: §e" + config.getConfigurationSection("Smite").getInt("Cost_per_level")));
      weaponinv.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bBane of Arthropods", "§7Cost: §e" + config.getConfigurationSection("Bane_of_Arthropods").getInt("Cost_per_level")));
      weaponinv.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bKnockback", "§7Cost: §e" + config.getConfigurationSection("Knockback").getInt("Cost_per_level")));
      weaponinv.setItem(14, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bFire Aspect", "§7Cost: §e" + config.getConfigurationSection("Fire_Aspect").getInt("Cost_per_level")));
      weaponinv.setItem(15, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bLooting", "§7Cost: §e" + config.getConfigurationSection("Looting").getInt("Cost_per_level")));
      weaponinv.setItem(16, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSweeping Edge", "§7Cost: §e" + config.getConfigurationSection("Sweeping_Edge").getInt("Cost_per_level")));
      weaponinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(18, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(19, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bMending", "§7Cost: §e" + config.getConfigurationSection("Mending").getInt("Cost_per_level")));
      weaponinv.setItem(20, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bCurse of Vanishing", "§7Cost: §e" + config.getConfigurationSection("Curse_of_Vanishing").getInt("Cost_per_level")));
      weaponinv.setItem(21, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bUnbreaking", "§7Cost: §e" + config.getConfigurationSection("Unbreaking").getInt("Cost_per_level")));
      weaponinv.setItem(22, ItemCreator.ItemBuilder(Material.BOOK, 1, "§cComing soon"));
      weaponinv.setItem(23, ItemCreator.ItemBuilder(Material.BOOK, 1, "§cComing soon"));
      weaponinv.setItem(24, ItemCreator.ItemBuilder(Material.BOOK, 1, "§cComing soon"));
      weaponinv.setItem(25, ItemCreator.ItemBuilder(Material.BOOK, 1, "§cComing soon"));
      weaponinv.setItem(26, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(36, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(37, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(38, ItemCreator.ItemBuilder(Material.BARRIER, 1, "§c?"));
      weaponinv.setItem(39, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(41, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(42, ItemCreator.ItemBuilder(Material.BARRIER, 1, "§c?"));
      weaponinv.setItem(43, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      weaponinv.setItem(44, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      p.openInventory(weaponinv);
    } catch (Exception exception) {}
  }
}
