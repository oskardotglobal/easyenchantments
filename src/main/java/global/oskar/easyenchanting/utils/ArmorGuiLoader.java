package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ArmorGuiLoader {
  static FileConfiguration config = Main.plugin.getConfig();
  
  public static void BuildArmorInv(Player p) {
    try {
      Inventory armorinv = Bukkit.createInventory(null, 54, "§5Rüstung verzaubern");
      int i;
      for (i = 0; i <= 8; i++)
        armorinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
      for (i = 27; i <= 35; i++)
        armorinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
      for (i = 45; i <= 53; i++)
        armorinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s")); 
      armorinv.setItem(9, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bProtection", "§7Cost: §e" + config.getConfigurationSection("protection").getInt("cost")));
      armorinv.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bFire Protection", "§7Cost: §e" + config.getConfigurationSection("fire_protection").getInt("cost")));
      armorinv.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bBlast Protection", "§7Cost: §e" + config.getConfigurationSection("blast_protection").getInt("cost")));
      armorinv.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bProjectile Protection", "§7Cost: §e" + config.getConfigurationSection("projectile_protection").getInt("cost")));
      armorinv.setItem(14, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bFeather Falling", "§7Cost: §e" + config.getConfigurationSection("feather_falling").getInt("cost")));
      armorinv.setItem(15, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bRespiration", "§7Cost: §e" + config.getConfigurationSection("respiration").getInt("cost")));
      armorinv.setItem(16, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bAqua Affinity", "§7Cost: §e" + config.getConfigurationSection("aqua_affinity").getInt("cost")));
      armorinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(18, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(19, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bDepth Strider", "§7Cost: §e" + config.getConfigurationSection("depth_strider").getInt("cost")));
      armorinv.setItem(20, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bFrost Walker", "§7Cost: §e" + config.getConfigurationSection("frost_walker").getInt("cost")));
      armorinv.setItem(21, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bThorns", "§7Cost: §e" + config.getConfigurationSection("thorns").getInt("cost")));
      armorinv.setItem(22, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bCurse of Binding", "§7Cost: §e" + config.getConfigurationSection("binding_curse").getInt("cost")));
      armorinv.setItem(23, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bUnbreaking", "§7Cost: §e" + config.getConfigurationSection("unbreaking").getInt("cost")));
      armorinv.setItem(24, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bCurse of Vanishing", "§7Cost: §e" + config.getConfigurationSection("vanishing_curse").getInt("cost")));
      armorinv.setItem(25, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(26, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(36, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(37, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(42, ItemCreator.ItemBuilder(Material.BARRIER, 1, "§cSchließen"));
      armorinv.setItem(39, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(41, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(42, ItemCreator.ItemBuilder(Material.WRITTEN_BOOK, 1, "§2Hilfe"));
      armorinv.setItem(43, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      armorinv.setItem(44, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
      p.openInventory(armorinv);

    } catch (Exception ignored) {}
  }
}
