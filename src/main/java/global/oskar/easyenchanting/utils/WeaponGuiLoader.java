package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.logging.Level;

public class WeaponGuiLoader {
    static final FileConfiguration config = Main.plugin.getConfig();

    public static void BuildWeaponInv(Player p) {
        try {
            Inventory gui = Bukkit.createInventory(null, 54, "Waffen verzaubern");

            for (int i = 0; i <= 53; i++) gui.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "s"));
            
            gui.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Sharpness", "Cost: " + config.getConfigurationSection("sharpness").getInt("cost")));
            gui.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Smite", "Cost: " + config.getConfigurationSection("smite").getInt("cost")));
            gui.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Bane of Arthropods", "Cost: " + config.getConfigurationSection("bane_of_arthropods").getInt("cost")));
            gui.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Knockback", "Cost: " + config.getConfigurationSection("knockback").getInt("cost")));
            gui.setItem(14, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Fire Aspect", "Cost: " + config.getConfigurationSection("fire_aspect").getInt("cost")));
            gui.setItem(15, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Looting", "Cost: " + config.getConfigurationSection("looting").getInt("cost")));
            gui.setItem(16, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Sweeping Edge", "Cost: " + config.getConfigurationSection("sweeping").getInt("cost")));
            gui.setItem(19, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Curse of Vanishing", "Cost: " + config.getConfigurationSection("vanishing_curse").getInt("cost")));
            gui.setItem(20, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Unbreaking", "Cost: " + config.getConfigurationSection("unbreaking").getInt("cost")));
            gui.setItem(21, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Riptide", "Cost: " + config.getConfigurationSection("riptide").getInt("cost")));
            gui.setItem(22, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Impaling", "Cost: " + config.getConfigurationSection("impaling").getInt("cost")));
            gui.setItem(23, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Channeling", "Cost: " + config.getConfigurationSection("channeling").getInt("cost")));
            gui.setItem(24, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Flame", "Cost: " + config.getConfigurationSection("flame").getInt("cost")));
            gui.setItem(24, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Infinity", "Cost: " + config.getConfigurationSection("infinity").getInt("cost")));
            gui.setItem(28, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Loyalty", "Cost: " + config.getConfigurationSection("loyalty").getInt("cost")));
            gui.setItem(29, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Multishot", "Cost: " + config.getConfigurationSection("multishot").getInt("cost")));
            gui.setItem(30, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Piercing", "Cost: " + config.getConfigurationSection("piercing").getInt("cost")));
            gui.setItem(31, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Punch", "Cost: " + config.getConfigurationSection("punch").getInt("cost")));
            gui.setItem(32, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Quick Charge", "Cost: " + config.getConfigurationSection("quick_charge").getInt("cost")));
            gui.setItem(38, ItemCreator.ItemBuilder(Material.BARRIER, 1, "Schliessen"));
            gui.setItem(42, ItemCreator.ItemBuilder(Material.WRITTEN_BOOK, 1, "Hilfe"));
            gui.setItem(40, null);

            p.openInventory(gui);
        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
