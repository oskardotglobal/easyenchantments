package global.oskar.easyenchanting.lib;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class EnchantmentWrapper {
    private final String id;
    private final Player p;
    private final int cost;
    private final int max;

    public EnchantmentWrapper(@NotNull String id, @NotNull Player p) {
        final FileConfiguration config = Main.plugin.getConfig();

        this.id = id;
        this.p = p;
        this.cost = config.getConfigurationSection(id).getInt("cost");
        this.max = config.getConfigurationSection(id).getInt("max");
    }

    public void enchant(ItemStack item) {
        Enchantment ench = Utils.getLinkedEnchantment(id);
        int level = item.getEnchantmentLevel(ench);

        if (item.getEnchantments().size() == 3 && !item.containsEnchantment(ench)) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Dieses Item hat bereits 3 Enchantments!", ChatColor.RED);
            return;
        }

        if (p.getLevel() < cost) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Dafuer hast du nicht genuegend Level!", ChatColor.RED);
            return;
        }

        for (Map.Entry<Enchantment, Integer> entry : item.getEnchantments().entrySet()) {
            if (entry.getKey().conflictsWith(ench) && !item.containsEnchantment(entry.getKey())) {
                Utils.closeInventory(p);
                Utils.sendMessage(p, "Diese Enchantments passen nicht zusammen!", ChatColor.RED);
                return;
            }
        }

        if (level < max) {
            p.setLevel(p.getLevel() - cost);
            item.addUnsafeEnchantment(ench, level + 1);
        } else {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Dieses Enchantment hat bereits das h\u00F6chste Level!", ChatColor.RED);
        }
    }
}
