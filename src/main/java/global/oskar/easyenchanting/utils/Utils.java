package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Utils {
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
}
