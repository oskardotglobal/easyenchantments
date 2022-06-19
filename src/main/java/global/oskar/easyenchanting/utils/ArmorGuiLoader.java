package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.logging.Level;

public class ArmorGuiLoader {
    static final FileConfiguration config = Main.plugin.getConfig();

    public static void BuildArmorInv(Player p) {
        try {
            Inventory gui = Bukkit.createInventory(null, 54, "Ruestung verzaubern");

            for (int i = 0; i <= 53; i++) gui.setItem(i, ItemCreator.ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "s"));

            gui.setItem(10, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Protection", "Cost: " + config.getConfigurationSection("protection").getInt("cost")));
            gui.setItem(11, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Fire Protection", "Cost: " + config.getConfigurationSection("fire_protection").getInt("cost")));
            gui.setItem(12, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Blast Protection", "Cost: " + config.getConfigurationSection("blast_protection").getInt("cost")));
            gui.setItem(13, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Projectile Protection", "Cost: " + config.getConfigurationSection("projectile_protection").getInt("cost")));
            gui.setItem(14, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Feather Falling", "Cost: " + config.getConfigurationSection("feather_falling").getInt("cost")));
            gui.setItem(15, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Respiration", "Cost: " + config.getConfigurationSection("respiration").getInt("cost")));
            gui.setItem(16, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Aqua Affinity", "Cost: " + config.getConfigurationSection("aqua_affinity").getInt("cost")));
            gui.setItem(19, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Depth Strider", "Cost: " + config.getConfigurationSection("depth_strider").getInt("cost")));
            gui.setItem(20, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Frost Walker", "Cost: " + config.getConfigurationSection("frost_walker").getInt("cost")));
            gui.setItem(21, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Thorns", "Cost: " + config.getConfigurationSection("thorns").getInt("cost")));
            gui.setItem(22, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Curse of Binding", "Cost: " + config.getConfigurationSection("binding_curse").getInt("cost")));
            gui.setItem(23, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Unbreaking", "Cost: " + config.getConfigurationSection("unbreaking").getInt("cost")));
            gui.setItem(24, ItemCreator.ItemLoreBuilder(Material.ENCHANTED_BOOK, 1, "Curse of Vanishing", "Cost: " + config.getConfigurationSection("vanishing_curse").getInt("cost")));
            gui.setItem(42, ItemCreator.ItemBuilder(Material.BARRIER, 1, "Schliessen"));
            gui.setItem(42, ItemCreator.ItemBuilder(Material.WRITTEN_BOOK, 1, "Hilfe"));
            gui.setItem(40, null);

            p.openInventory(gui);

        } catch (Exception ex) {
            Main.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
