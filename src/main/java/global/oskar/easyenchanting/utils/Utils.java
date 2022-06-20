package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;

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
    }

    private static final FileConfiguration config = Main.plugin.getConfig();

    public static void sendMessage(Player p, String msg, ChatColor color) {
        p.sendMessage(config.getConfigurationSection("CONFIG").getString("prefix") + color + msg);
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
                Swift Sneak, Soul Speed, Fortune und Mending koennen nur
                """);

        contents.addPage("""
                in Kisten gefunden werden. Villager verkaufen keine verzauberten Buecher. Protection geht nur bis Level 2. Sharpness geht nur bis Level 4, Smite, Impaling und Bane of Arthropods bis Level 6. Impaling kann auf einem Schwert und auf einer Axt genutzt werden. Power geht nur bis Level 3. Riptide geht bis Level 5. Alles kostet viel mehr XP.
                """);

        contents.addPage("" +
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Zaubertisch-Hilfe"
                + ChatColor.RESET +
                """
                
                Im Zaubertisch-Menue gibt es 3 Kategorien:
                1. Werkzeuge
                2. Waffen
                3. Ruestung
                
                Um ein Item zu verzaubern, musst du die Kategorie waehlen und das Item anklicken. Wenn das Item
                """);

        contents.addPage("""
                nicht in die Kategorie passt, du versuchst, ein Item mit einer unpassenden Verzauberung zu versehen oder ein Item bereits 3 Verzauberungen hat, dann schliesst sich das Menu.
                """);

        book.setItemMeta(contents);

        p.openBook(book);
    }

    public static ItemStack createItem(Material mat, Integer value, String name) {
        ItemStack item = new ItemStack(mat, value);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(name);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack createLoreItem(Material mat, Integer value, String name, String Lore) {
        ItemStack item = new ItemStack(mat, value);
        ItemMeta itemmeta = item.getItemMeta();
        ArrayList<String> itemlore = new ArrayList<>();
        itemlore.add(Lore);
        itemmeta.setLore(itemlore);
        itemmeta.setDisplayName(name);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack createEnchantmentSelector(@NotNull String name, @NotNull String id) {
        return createLoreItem(Material.ENCHANTED_BOOK, 1, ChatColor.AQUA + name, ChatColor.YELLOW + "Cost: " + ChatColor.DARK_GREEN + config.getConfigurationSection(id).getInt("cost"));
    }

    public static ItemStack createEnchantmentSelector(@NotNull String name) {
        String id = name.toLowerCase().replace(" ", "_");
        return createLoreItem(Material.ENCHANTED_BOOK, 1, ChatColor.AQUA + name, ChatColor.YELLOW + "Cost: " + ChatColor.DARK_GREEN + config.getConfigurationSection(id).getInt("cost"));
    }

    public static boolean isCustomInventory(String inventoryTitle) {
        inventoryTitle = ChatColor.stripColor(inventoryTitle);
        return inventoryTitle.equals("Ruestung verzaubern") || inventoryTitle.equals("Waffen verzaubern") ||
                inventoryTitle.equals("Werkzeuge verzaubern");
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

    private static class CloseInventoryRunnable implements Runnable {
        Player p;
        CloseInventoryRunnable(Player p) { this.p = p; }

        @Override
        public void run() {
            Utils.closeInventory(p);
        }
    }
}
