package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.logging.Level;

public class WeaponGuiLoader {
    static FileConfiguration config = Main.plugin.getConfig();

    public static void BuildWeaponInv(Player p) {
        try {
            Inventory weaponinv = Bukkit.createInventory(null, 54, "§5Waffen verzaubern");
            int i;
            for (i = 0; i <= 8; i++)
                weaponinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            for (i = 45; i <= 53; i++)
                weaponinv.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(9, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSharpness", "§7Cost: §e" + config.getConfigurationSection("sharpness").getInt("cost")));
            weaponinv.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSmite", "§7Cost: §e" + config.getConfigurationSection("smite").getInt("cost")));
            weaponinv.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bBane of Arthropods", "§7Cost: §e" + config.getConfigurationSection("bane_of_arthropods").getInt("cost")));
            weaponinv.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bKnockback", "§7Cost: §e" + config.getConfigurationSection("knockback").getInt("cost")));
            weaponinv.setItem(14, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bFire Aspect", "§7Cost: §e" + config.getConfigurationSection("fire_aspect").getInt("cost")));
            weaponinv.setItem(15, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bLooting", "§7Cost: §e" + config.getConfigurationSection("looting").getInt("cost")));
            weaponinv.setItem(16, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bSweeping Edge", "§7Cost: §e" + config.getConfigurationSection("sweeping").getInt("cost")));
            weaponinv.setItem(17, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(18, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(19, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bCurse of Vanishing", "§7Cost: §e" + config.getConfigurationSection("vanishing_curse").getInt("cost")));
            weaponinv.setItem(20, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bUnbreaking", "§7Cost: §e" + config.getConfigurationSection("unbreaking").getInt("cost")));
            weaponinv.setItem(21, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bRiptide", "§7Cost: §e" + config.getConfigurationSection("riptide").getInt("cost")));
            weaponinv.setItem(22, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bImpaling", "§7Cost: §e" + config.getConfigurationSection("impaling").getInt("cost")));
            weaponinv.setItem(23, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bChanneling", "§7Cost: §e" + config.getConfigurationSection("channeling").getInt("cost")));
            weaponinv.setItem(24, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bFlame", "§7Cost: §e" + config.getConfigurationSection("flame").getInt("cost")));
            weaponinv.setItem(24, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bInfinity", "§7Cost: §e" + config.getConfigurationSection("infinity").getInt("cost")));
            weaponinv.setItem(26, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(27, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(28, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bLoyalty", "§7Cost: §e" + config.getConfigurationSection("loyalty").getInt("cost")));
            weaponinv.setItem(29, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bMultishot", "§7Cost: §e" + config.getConfigurationSection("multishot").getInt("cost")));
            weaponinv.setItem(30, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bPiercing", "§7Cost: §e" + config.getConfigurationSection("piercing").getInt("cost")));
            weaponinv.setItem(31, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bPunch", "§7Cost: §e" + config.getConfigurationSection("punch").getInt("cost")));
            weaponinv.setItem(32, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "§bQuick Charge", "§7Cost: §e" + config.getConfigurationSection("quick_charge").getInt("cost")));
            weaponinv.setItem(33, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(34, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(35, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(36, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(37, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(38, ItemCreator.ItemBuilder(Material.BARRIER, 1, "§cSchließen"));
            weaponinv.setItem(39, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(41, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(42, ItemCreator.ItemBuilder(Material.WRITTEN_BOOK, 1, "§2Hilfe"));
            weaponinv.setItem(43, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            weaponinv.setItem(44, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§0s"));
            p.openInventory(weaponinv);
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
