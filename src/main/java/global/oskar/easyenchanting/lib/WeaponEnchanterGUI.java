package global.oskar.easyenchanting.lib;

import de.themoep.inventorygui.*;
import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WeaponEnchanterGUI extends InventoryGui {

    public WeaponEnchanterGUI() {
        super(Main.plugin, null, "Waffen verzaubern", new String[]{
                "         ",
                " abcdefg ",
                " hjklmno ",
                " pqrst   ",
                "         ",
                "        z"
        });

        this.setFiller(Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));

        this.addElement(createEnchantmentSelector('a', "Sharpness"));
        this.addElement(createEnchantmentSelector('b', "Smite"));
        this.addElement(createEnchantmentSelector('c', "Bane Of Arthropods"));
        this.addElement(createEnchantmentSelector('d', "Knockback"));
        this.addElement(createEnchantmentSelector('e', "Fire Aspect"));
        this.addElement(createEnchantmentSelector('f', "Looting"));
        this.addElement(createEnchantmentSelector('g', "Sweeping Edge", "sweeping"));
        this.addElement(createEnchantmentSelector('h', "Riptide"));
        this.addElement(createEnchantmentSelector('j', "Impaling"));
        this.addElement(createEnchantmentSelector('k', "Channeling"));
        this.addElement(createEnchantmentSelector('l', "Flame"));
        this.addElement(createEnchantmentSelector('m', "Infinity"));
        this.addElement(createEnchantmentSelector('n', "Loyalty"));
        this.addElement(createEnchantmentSelector('o', "Multishot"));
        this.addElement(createEnchantmentSelector('p', "Piercing"));
        this.addElement(createEnchantmentSelector('q', "Punch"));
        this.addElement(createEnchantmentSelector('r', "Quick Charge"));
        this.addElement(createEnchantmentSelector('s', "Curse of Vanishing", "vanishing_curse"));
        this.addElement(createEnchantmentSelector('t', "Unbreaking"));

        this.addElement(new StaticGuiElement('z', new ItemStack(Material.WRITTEN_BOOK), click -> {
            Player p = (Player) click.getWhoClicked();
            Utils.closeInventory(p);
            Utils.openHelp(p);
            return true;
        }, ChatColor.DARK_PURPLE + "Hilfe"));
    }

    private StaticGuiElement createEnchantmentSelector(@NotNull Character key, @NotNull String name) {
        String id = name.toLowerCase().replace(" ", "_");

        return new StaticGuiElement(key,
                new ItemStack(Material.ENCHANTED_BOOK),
                1,
                click -> enchantItem(click, id),
                ChatColor.AQUA + name,
                ChatColor.YELLOW + "Cost: " + ChatColor.DARK_GREEN + Main.plugin.getConfig().getConfigurationSection(id).getInt("cost")
                );
    }

    private StaticGuiElement createEnchantmentSelector(@NotNull Character key, @NotNull String name, @NotNull String id) {
        return new StaticGuiElement(key,
                new ItemStack(Material.ENCHANTED_BOOK),
                1,
                click -> {
                    return enchantItem(click, id);
                },
                ChatColor.AQUA + name,
                ChatColor.YELLOW + "Cost: " + ChatColor.DARK_GREEN + Main.plugin.getConfig().getConfigurationSection(id).getInt("cost")
        );
    }

    private boolean enchantItem(GuiElement.Click click, String id) {
        InventoryClickEvent e = click.getEvent();
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        ItemStack enchant = p.getInventory().getItemInMainHand();

        if (!Utils.itemExists(enchant)) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Du musst ein Item in der Hand halten!", ChatColor.RED);
            return false;
        }

        if (!ItemChecker.checkforWeapon(enchant)
                && enchant.getType() != Material.BOW
                && enchant.getType() != Material.CROSSBOW
        ) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Du kannst hier nur Waffen verzaubern!", ChatColor.RED);
            return false;
        }

        switch (id) {
            case "sharpness" -> {
                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Sharpness verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                    ench.enchant(enchant);
                }
            }
            case "smite" -> {
                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Smite verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                    ench.enchant(enchant);
                }
            }
            case "bane_of_arthropods" -> {
                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Bane of Arthropods verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("bane_of_arthropods", p);
                    ench.enchant(enchant);
                }
            }
            case "impaling" -> {
                if (!ItemChecker.checkforWeapon(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Nahkampfwaffen mit Impaling verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("impaling", p);
                    ench.enchant(enchant);
                }
            }
            case "knockback" -> {
                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Knockback verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("knockback", p);
                    ench.enchant(enchant);
                }
            }
            case "fire_aspect" -> {
                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Fire Aspect verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("fire_aspect", p);
                    ench.enchant(enchant);
                }
            }
            case "looting" -> {
                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Looting verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("looting", p);
                    ench.enchant(enchant);
                }
            }
            case "sweeping" -> {
                if (!ItemChecker.checkforSword(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur ein Schwert mit Sweeping Edge verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("sweeping", p);
                    ench.enchant(enchant);
                }
            }
            case "riptide" -> {
                if (enchant.getType() != Material.TRIDENT) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Trident mit Riptide verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("riptide", p);
                    ench.enchant(enchant);
                }
            }
            case "channeling" -> {
                if (enchant.getType() != Material.TRIDENT) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Trident mit Channeling verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("channeling", p);
                    ench.enchant(enchant);
                }
            }
            case "flame" -> {
                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Flame verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("flame", p);
                    ench.enchant(enchant);
                }
            }
            case "infinity" -> {
                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Infinity verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("infinity", p);
                    ench.enchant(enchant);
                }
            }
            case "loyalty" -> {
                if (enchant.getType() != Material.TRIDENT) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Trident mit Loyalty verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("loyalty", p);
                    ench.enchant(enchant);
                }
            }
            case "multishot" -> {
                if (enchant.getType() != Material.CROSSBOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Crossbow mit Multishot verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("multishot", p);
                    ench.enchant(enchant);
                }
            }
            case "piercing" -> {
                if (enchant.getType() != Material.BOW || enchant.getType() != Material.CROSSBOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen oder einen Crossbow mit Piercing verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("piercing", p);
                    ench.enchant(enchant);
                }
            }
            case "power" -> {
                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Power verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("power", p);
                    ench.enchant(enchant);
                }
            }
            case "punch" -> {
                if (enchant.getType() != Material.BOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Bogen mit Punch verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("punch", p);
                    ench.enchant(enchant);
                }
            }
            case "quick_charge" -> {
                if (enchant.getType() != Material.CROSSBOW) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur einen Crossbow mit Quick Charge verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper("quick_charge", p);
                    ench.enchant(enchant);
                }
            }
            case "unbreaking" -> {
                EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                ench.enchant(enchant);
            }
            case "vanishing_curse" -> {
                EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                ench.enchant(enchant);
            }
        }

        return true;
    }
}
