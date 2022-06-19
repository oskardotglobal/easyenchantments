package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

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

        contents.addPage("""
                Zaubertisch-Hilfe
                
                Der Zaubertisch ist auf diesem Server nicht so, wie er
                normalerweise ist.
                
                Folgendes ist anders:
                Jedes Item kann maximal dreimal verzaubert werden.
                Swift Sneak, Soul Speed, Fortune und Mending koennen nur in Kisten gefunden werden.
                Villager verkaufen keine verzauberten Buecher.
                Protection geht nur bis Level 2.
                Sharpness geht nur bis Level 4, Smite, Impaling und Bane of Arthropods bis Level 6.
                Impaling kann auf einem Schwert und auf einer Axt genutzt werden.
                Power geht nur bis Level 3.
                Riptide geht bis Level 5.
                Alles kostet viel mehr XP.
                """);

        contents.addPage("""
                Zaubertisch-Hilfe
                
                Im Zaubertisch-Menue gibt es 3 Kategorien:
                1. Ruestung
                2. Waffen
                3. Werkzeuge
                
                Um ein Item zu verzaubern, musst du die Kategorie waehlen und das Item anklicken.
                Wenn das Item nicht in die Kategorie passt, du versuchst, ein Item mit einer unpassenden
                Verzauberung zu versehen oder ein Item bereits 3 Verzauberungen hat,
                dann schliesst sich das Menue.
                """);

        book.setItemMeta(contents);

        p.openBook(book);
    }
}
