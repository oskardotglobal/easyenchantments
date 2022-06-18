package global.oskar.easyenchanting.utils;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
  public static ItemStack ItemBuilder(Material mat, Integer value, String name) {
    ItemStack item = new ItemStack(mat, value);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(name);
    item.setItemMeta(itemmeta);
    return item;
  }
  
  public static ItemStack ItemLoreBuilder(Material mat, Integer value, String name, String Lore) {
    ItemStack item = new ItemStack(mat, value);
    ItemMeta itemmeta = item.getItemMeta();
    ArrayList<String> itemlore = new ArrayList<>();
    itemlore.add(Lore);
    itemmeta.setLore(itemlore);
    itemmeta.setDisplayName(name);
    item.setItemMeta(itemmeta);
    return item;
  }
}
