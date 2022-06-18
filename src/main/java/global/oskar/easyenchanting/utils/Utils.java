package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Utils {
    private static final FileConfiguration config = Main.plugin.getConfig();

    public static void sendMessage(Player p, String msg, ChatColor color) {
        p.sendMessage(config.getConfigurationSection("CONFIG").getString("prefix") + color + msg);
    }
}
