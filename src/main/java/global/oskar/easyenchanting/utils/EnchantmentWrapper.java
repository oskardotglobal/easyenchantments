package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EnchantmentWrapper {
    private final String name;
    private final Player p;
    private final int cost;
    private final int max;

    public EnchantmentWrapper(@NotNull String name, @NotNull Player p) {
        final FileConfiguration config = Main.plugin.getConfig();

        this.name = name;
        this.p = p;
        this.cost = config.getConfigurationSection(name).getInt("cost");
        this.max = config.getConfigurationSection(name).getInt("max");
    }

    public void enchant(ItemStack item) {
        if (item.getEnchantments().size() == 3) {
            p.closeInventory();
            Utils.sendMessage(p, "Dieses Item hat bereits 3 Enchantments!", ChatColor.RED);
        } else if (p.getLevel() >= cost) {
            Enchantment ench = org.bukkit.enchantments.EnchantmentWrapper.getByKey(NamespacedKey.minecraft(name));
            int level = item.getEnchantmentLevel(ench);

            if (level <= max) {
                p.setLevel(p.getLevel() - cost);
                item.addUnsafeEnchantment(ench, level + 1);
            } else {
                p.closeInventory();
                Utils.sendMessage(p, "Dieses Enchantment hat bereits das hoechste Level!", ChatColor.RED);
            }

        } else {
            p.closeInventory();
            Utils.sendMessage(p, "Dafuer hast du nicht genuegend Level!", ChatColor.RED);
        }
    }
}
