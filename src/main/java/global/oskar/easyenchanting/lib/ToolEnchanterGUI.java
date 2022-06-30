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
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ToolEnchanterGUI extends InventoryGui {
    public ToolEnchanterGUI() {
        super(Main.plugin, null, "Werkzeuge verzaubern", new String[]{
                "         ",
                " abcd    ",
                "         ",
                "         ",
                "         ",
                "         "
        });

        this.setFiller(Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));

        this.addElement(createEnchantmentSelector('a', "Efficiency"));
        this.addElement(createEnchantmentSelector('b', "Silk Touch"));
        this.addElement(createEnchantmentSelector('c', "Curse of Vanishing", "vanishing_curse"));
        this.addElement(createEnchantmentSelector('d', "Unbreaking"));
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

        if (!ItemChecker.checkforTools(enchant)) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Du kannst hier nur Werkzeuge verzaubern!", ChatColor.RED);
            return false;
        }

        EnchantmentWrapper ench = new EnchantmentWrapper(id, p);
        ench.enchant(enchant);
        return true;
    }
}
