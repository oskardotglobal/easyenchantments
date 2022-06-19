package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ArmorGUILoader {
    static final FileConfiguration config = Main.plugin.getConfig();

    public static void build(Player p) {

            Inventory gui = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Ruestung verzaubern");

            for (int i = 0; i <= 53; i++) gui.setItem(i, Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));

            gui.setItem(10, Utils.createEnchantmentSelector("Protection"));
            gui.setItem(11, Utils.createEnchantmentSelector("Fire Protection"));
            gui.setItem(12, Utils.createEnchantmentSelector("Blast Protection"));
            gui.setItem(13, Utils.createEnchantmentSelector("Projectile Protection"));
            gui.setItem(14, Utils.createEnchantmentSelector("Feather Falling"));
            gui.setItem(15, Utils.createEnchantmentSelector("Respiration"));
            gui.setItem(16, Utils.createEnchantmentSelector("Aqua Affinity"));
            gui.setItem(19, Utils.createEnchantmentSelector("Depth Strider"));
            gui.setItem(20, Utils.createEnchantmentSelector("Frost Walker"));
            gui.setItem(21, Utils.createEnchantmentSelector("Thorns"));
            gui.setItem(22, Utils.createEnchantmentSelector("Curse of Binding", "binding_curse"));
            gui.setItem(23, Utils.createEnchantmentSelector("Unbreaking"));
            gui.setItem(24, Utils.createEnchantmentSelector("Curse of Vanishing", "vanishing_curse"));
            gui.setItem(38, Utils.createItem(Material.BARRIER, 1, "Schliessen"));
            gui.setItem(42, Utils.createItem(Material.WRITTEN_BOOK, 1, "Hilfe"));
            gui.setItem(40, null);

            p.openInventory(gui);


    }
}
