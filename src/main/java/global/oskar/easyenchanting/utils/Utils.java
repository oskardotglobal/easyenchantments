package global.oskar.easyenchanting.utils;

import de.themoep.inventorygui.StaticGuiElement;
import global.oskar.easyenchanting.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public Utils() {
        linkedEnchantments.put("unbreaking", Enchantment.DURABILITY);
        linkedEnchantments.put("vanishing_curse", Enchantment.VANISHING_CURSE);
        linkedEnchantments.put("efficiency", Enchantment.DIG_SPEED);
        linkedEnchantments.put("silk_touch", Enchantment.SILK_TOUCH);
        linkedEnchantments.put("protection", Enchantment.PROTECTION_ENVIRONMENTAL);
        linkedEnchantments.put("fire_protection", Enchantment.PROTECTION_FIRE);
        linkedEnchantments.put("projectile_protection", Enchantment.PROTECTION_PROJECTILE);
        linkedEnchantments.put("blast_protection", Enchantment.PROTECTION_EXPLOSIONS);
        linkedEnchantments.put("feather_falling", Enchantment.PROTECTION_FALL);
        linkedEnchantments.put("aqua_affinity", Enchantment.WATER_WORKER);
        linkedEnchantments.put("thorns", Enchantment.THORNS);
        linkedEnchantments.put("respiration", Enchantment.OXYGEN);
        linkedEnchantments.put("depth_strider", Enchantment.DEPTH_STRIDER);
        linkedEnchantments.put("frost_walker", Enchantment.FROST_WALKER);
        linkedEnchantments.put("binding_curse", Enchantment.BINDING_CURSE);
        linkedEnchantments.put("sharpness", Enchantment.DAMAGE_ALL);
        linkedEnchantments.put("smite", Enchantment.DAMAGE_UNDEAD);
        linkedEnchantments.put("bane_of_arthropods", Enchantment.DAMAGE_ARTHROPODS);
        linkedEnchantments.put("knockback", Enchantment.KNOCKBACK);
        linkedEnchantments.put("looting", Enchantment.LOOT_BONUS_MOBS);
        linkedEnchantments.put("fire_aspect", Enchantment.FIRE_ASPECT);
        linkedEnchantments.put("sweeping", Enchantment.SWEEPING_EDGE);
        linkedEnchantments.put("impaling", Enchantment.IMPALING);
        linkedEnchantments.put("riptide", Enchantment.RIPTIDE);
        linkedEnchantments.put("channeling", Enchantment.CHANNELING);
        linkedEnchantments.put("flame", Enchantment.ARROW_FIRE);
        linkedEnchantments.put("infinity", Enchantment.ARROW_INFINITE);
        linkedEnchantments.put("loyalty", Enchantment.LOYALTY);
        linkedEnchantments.put("multishot", Enchantment.MULTISHOT);
        linkedEnchantments.put("piercing", Enchantment.PIERCING);
        linkedEnchantments.put("power", Enchantment.ARROW_DAMAGE);
        linkedEnchantments.put("punch", Enchantment.ARROW_KNOCKBACK);
        linkedEnchantments.put("quick_charge", Enchantment.QUICK_CHARGE);

        colorCodes.put("&0", ChatColor.BLACK);
        colorCodes.put("&1", ChatColor.DARK_BLUE);
        colorCodes.put("&2", ChatColor.DARK_GREEN);
        colorCodes.put("&3", ChatColor.DARK_AQUA);
        colorCodes.put("&4", ChatColor.DARK_RED);
        colorCodes.put("&5", ChatColor.DARK_PURPLE);
        colorCodes.put("&6", ChatColor.GOLD);
        colorCodes.put("&7", ChatColor.GRAY);
        colorCodes.put("&8", ChatColor.DARK_GRAY);
        colorCodes.put("&9", ChatColor.BLUE);
        colorCodes.put("&a", ChatColor.GREEN);
        colorCodes.put("&b", ChatColor.AQUA);
        colorCodes.put("&c", ChatColor.RED);
        colorCodes.put("&d", ChatColor.LIGHT_PURPLE);
        colorCodes.put("&e", ChatColor.YELLOW);
        colorCodes.put("&f", ChatColor.WHITE);
        colorCodes.put("&k", ChatColor.MAGIC);
        colorCodes.put("&l", ChatColor.BOLD);
        colorCodes.put("&m", ChatColor.STRIKETHROUGH);
        colorCodes.put("&n", ChatColor.UNDERLINE);
        colorCodes.put("&o", ChatColor.ITALIC);
        colorCodes.put("&r", ChatColor.RESET);
    }

    private static final FileConfiguration config = Main.plugin.getConfig();

    public static final HashMap<String, ChatColor> colorCodes = new HashMap<>();

    public static void sendMessage(Player p, String msg, ChatColor color) {
        String prefix = config.getConfigurationSection("CONFIG").getString("prefix");
        if (prefix == null) return;

        for (Map.Entry<String, ChatColor> entry : colorCodes.entrySet()) {
            msg = msg.replace(entry.getKey(), entry.getValue().toString());
            prefix = prefix.replace(entry.getKey(), entry.getValue().toString());
        }

        p.sendMessage(prefix + color + msg);
    }

    public static void sendMessage(CommandSender sender, String msg, ChatColor color) {
        String prefix = config.getConfigurationSection("CONFIG").getString("prefix");
        if (prefix == null) return;

        for (Map.Entry<String, ChatColor> entry : colorCodes.entrySet()) {
            msg = msg.replace(entry.getKey(), entry.getValue().toString());
            prefix = prefix.replace(entry.getKey(), entry.getValue().toString());
        }

        sender.sendMessage(prefix + color + msg);
    }

    public static void openHelp(Player p) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta contents = (BookMeta) book.getItemMeta();

        contents.setTitle("Zaubertisch-Hilfe");
        contents.setAuthor("PixelAgent007");

        contents.addPage("" +
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Zaubertisch-Hilfe"
                + ChatColor.RESET +
                """
                
                Der Zaubertisch ist auf diesem Server nicht so, wie er
                normalerweise ist.
                
                Folgendes ist anders:
                Jedes Item kann maximal dreimal verzaubert werden.
                Swift Sneak, Soul Speed, Fortune und Mending k\u00F6nnen nur
                """);

        contents.addPage("""
                in Kisten gefunden werden. Villager verkaufen keine verzauberten B\u00FCcher. Protection geht nur bis Level 2. Sharpness geht nur bis Level 4, Smite, Impaling und Bane of Arthropods bis Level 6. Impaling kann auf einem Schwert und auf einer Axt genutzt werden. Power geht nur bis Level 3. Riptide geht bis Level 5. Alles kostet viel mehr XP.
                """);

        contents.addPage(
                """
                
                Im Zaubertisch-Men\u00FC gibt es 3 Kategorien:
                1. Werkzeuge
                2. Waffen
                3. R\u00FCstung
                
                Um ein Item zu verzaubern, musst du die Kategorie w\u00E4hlen und das Item anklicken. Wenn das Item
                """);

        contents.addPage("""
                nicht in die Kategorie passt, du versuchst, ein Item mit einer unpassenden Verzauberung zu versehen oder ein Item bereits 3 Verzauberungen hat, dann schliesst sich das Men\u00FC.
                """);

        book.setItemMeta(contents);

        p.openBook(book);
    }

    public static ItemStack createItem(Material mat, Integer value, String name) {
        ItemStack item = new ItemStack(mat, value);
        ItemMeta itemmeta = item.getItemMeta();
        assert itemmeta != null;
        itemmeta.setDisplayName(name);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static boolean itemExists(ItemStack item) {
        return item != null && item.getType() != Material.AIR;
    }

    private static final HashMap<String, Enchantment> linkedEnchantments = new HashMap<>();

    public static Enchantment getLinkedEnchantment(String id) {
        return linkedEnchantments.get(id);
    }

    public static void closeInventory(@NotNull Player p) {
        BukkitScheduler scheduler = Main.plugin.getServer().getScheduler();
        scheduler.runTask(Main.plugin, new CloseInventoryRunnable(p));
    }

    private record CloseInventoryRunnable(Player p) implements Runnable {
        @Override
            public void run() {
                p.closeInventory();
            }
    }

    public static String isEnchantAllowed(ItemStack item) {
        if (item.getEnchantments().size() == 3) return "max";
        return null;
    }
}
