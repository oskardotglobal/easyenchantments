package global.oskar.easyenchanting.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemChecker {
    public static boolean checkforEnchantable(ItemStack item) {
        return checkforTools(item) || checkforArmor(item) || checkforWeapon(item);
    }

    public static boolean checkforSword(ItemStack item) {
        return item.getType() == Material.WOODEN_SWORD || item.getType() == Material.STONE_SWORD ||
                item.getType() == Material.GOLDEN_SWORD || item.getType() == Material.IRON_SWORD ||
                item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.NETHERITE_SWORD;
    }

    public static boolean checkforWeapon(ItemStack item) {
        return checkforSword(item) || checkforAxe(item) || item.getType() == Material.TRIDENT;
    }

    public static boolean checkforAxe(ItemStack item) {
        return item.getType() == Material.WOODEN_AXE || item.getType() == Material.STONE_AXE ||
                item.getType() == Material.GOLDEN_AXE || item.getType() == Material.IRON_AXE ||
                item.getType() == Material.DIAMOND_AXE || item.getType() == Material.NETHERITE_AXE;
    }

    public static boolean checkforPickaxe(ItemStack item) {
        return item.getType() == Material.WOODEN_PICKAXE || item.getType() == Material.STONE_PICKAXE ||
                item.getType() == Material.GOLDEN_PICKAXE || item.getType() == Material.IRON_PICKAXE ||
                item.getType() == Material.DIAMOND_PICKAXE || item.getType() == Material.NETHERITE_HELMET;
    }

    public static boolean checkforHoe(ItemStack item) {
        return item.getType() == Material.WOODEN_HOE || item.getType() == Material.STONE_HOE ||
                item.getType() == Material.GOLDEN_HOE || item.getType() == Material.IRON_HOE ||
                item.getType() == Material.DIAMOND_HOE || item.getType() == Material.NETHERITE_HOE;
    }

    public static boolean checkforShovel(ItemStack item) {
        return item.getType() == Material.WOODEN_SHOVEL || item.getType() == Material.STONE_SHOVEL ||
                item.getType() == Material.GOLDEN_SHOVEL || item.getType() == Material.IRON_SHOVEL ||
                item.getType() == Material.DIAMOND_SHOVEL || item.getType() == Material.NETHERITE_SHOVEL;
    }

    public static boolean checkforTools(ItemStack item) {
        return checkforAxe(item) || checkforShovel(item) || checkforHoe(item) ||
                checkforPickaxe(item) || item.getType() == Material.SHEARS;
    }

    public static boolean checkForHelmet(ItemStack item) {
        return item.getType() == Material.LEATHER_HELMET || item.getType() == Material.CHAINMAIL_HELMET ||
                item.getType() == Material.GOLDEN_HELMET || item.getType() == Material.IRON_HELMET ||
                item.getType() == Material.DIAMOND_HELMET || item.getType() == Material.NETHERITE_HELMET;
    }

    public static boolean checkforChestplate(ItemStack item) {
        return item.getType() == Material.LEATHER_CHESTPLATE || item.getType() == Material.CHAINMAIL_CHESTPLATE ||
                item.getType() == Material.GOLDEN_CHESTPLATE || item.getType() == Material.IRON_CHESTPLATE ||
                item.getType() == Material.DIAMOND_CHESTPLATE || item.getType() == Material.NETHERITE_CHESTPLATE;
    }

    public static boolean checkforLeggings(ItemStack item) {
        return item.getType() == Material.LEATHER_LEGGINGS || item.getType() == Material.CHAINMAIL_LEGGINGS ||
                item.getType() == Material.GOLDEN_LEGGINGS || item.getType() == Material.IRON_LEGGINGS ||
                item.getType() == Material.DIAMOND_LEGGINGS || item.getType() == Material.NETHERITE_LEGGINGS;
    }

    public static boolean checkforBoots(ItemStack item) {
        return item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.CHAINMAIL_BOOTS ||
                item.getType() == Material.GOLDEN_BOOTS || item.getType() == Material.IRON_BOOTS ||
                item.getType() == Material.DIAMOND_BOOTS || item.getType() == Material.NETHERITE_BOOTS;
    }

    public static boolean checkforArmor(ItemStack item) {
        return checkForHelmet(item) || checkforChestplate(item) || checkforLeggings(item) || checkforBoots(item);
    }
}
