package global.oskar.easyenchanting.lib;

import de.themoep.inventorygui.GuiElement;
import de.themoep.inventorygui.InventoryGui;
import de.themoep.inventorygui.StaticGuiElement;
import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ArmorEnchanterGUI extends InventoryGui {
    public ArmorEnchanterGUI() {
        super(Main.plugin, null, "R\u00FCstung verzaubern", new String[]{
                "         ",
                " abcdefg ",
                " hijkl   ",
                "         ",
                "         ",
                "         "
        });

        this.setFiller(Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));

        this.addElement(createEnchantmentSelector('a', "Protection"));
        this.addElement(createEnchantmentSelector('b', "Projectile Protection"));
        this.addElement(createEnchantmentSelector('c', "Curse of Vanishing", "vanishing_curse"));
        this.addElement(createEnchantmentSelector('d', "Unbreaking"));
        this.addElement(createEnchantmentSelector('e', "Blast Protection"));
        this.addElement(createEnchantmentSelector('f', "Fire Protection"));
        this.addElement(createEnchantmentSelector('g', "Respiration"));
        this.addElement(createEnchantmentSelector('h', "Frost Walker"));
        this.addElement(createEnchantmentSelector('i', "Depth Strider"));
        this.addElement(createEnchantmentSelector('j', "Feather Falling"));
        this.addElement(createEnchantmentSelector('k', "Aqua Affinity"));
        this.addElement(createEnchantmentSelector('l', "Curse Of Binding", "binding_curse"));
    }

    private StaticGuiElement createEnchantmentSelector(@NotNull Character key, @NotNull String name) {
        String id = name.toLowerCase().replace(" ", "_");

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

        if (!ItemChecker.checkforArmor(enchant)) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Du kannst hier nur R\u00FCstung verzaubern!", ChatColor.RED);
            return false;
        }

        switch (id) {
            case "aqua_affinity" -> {
                if (!ItemChecker.checkForHelmet(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Helme mit Aqua Affinity verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                    ench.enchant(enchant);
                }
            }

            case "respiration" -> {
                if (!ItemChecker.checkForHelmet(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Helme mit Respiration verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                    ench.enchant(enchant);
                }
            }

            case "depth_strider" -> {
                if (!ItemChecker.checkforBoots(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Schuhe mit Depth Strider verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                    ench.enchant(enchant);
                }
            }

            case "feather_falling" -> {
                if (!ItemChecker.checkforBoots(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Schuhe mit Feather Falling verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                    ench.enchant(enchant);
                }
            }

            case "frost_walker" -> {
                if (!ItemChecker.checkforBoots(enchant)) {
                    Utils.closeInventory(p);
                    Utils.sendMessage(p, "Du kannst nur Schuhe mit Frost Walker verzaubern!", ChatColor.RED);
                } else {
                    EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                    ench.enchant(enchant);
                }
            }

            default -> {
                EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
                ench.enchant(enchant);
            }
        }
        return true;
    }
}
