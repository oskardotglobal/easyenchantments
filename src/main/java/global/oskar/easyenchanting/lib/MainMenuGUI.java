package global.oskar.easyenchanting.lib;

import de.themoep.inventorygui.DynamicGuiElement;
import de.themoep.inventorygui.GuiElement;
import de.themoep.inventorygui.InventoryGui;
import de.themoep.inventorygui.StaticGuiElement;
import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MainMenuGUI extends InventoryGui {

    public MainMenuGUI() {
        super(Main.plugin, null, "Zaubertisch - /enchantinghelp", new String[]{
                "         ",
                "  a b c  ",
                "    d    "
        });

        this.setFiller(Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));

        this.addElement(new DynamicGuiElement('d',
                viewer -> new StaticGuiElement('d',
                        new ItemStack(Material.EXPERIENCE_BOTTLE),
                        1,
                        click -> {
                            click.getGui().draw();
                            return true;
                        },
                        "Dein Level: " + ((Player)viewer).getLevel()
                )
        ));

        this.addElement(new StaticGuiElement('a', new ItemStack(Material.GOLDEN_PICKAXE), 1, this::openToolEnchanter, ChatColor.DARK_PURPLE + "Werkzeuge verzaubern"));
        this.addElement(new StaticGuiElement('b', new ItemStack(Material.GOLDEN_SWORD), 1, this::openWeaponEnchanter, ChatColor.DARK_PURPLE + "Waffen verzaubern"));
        this.addElement(new StaticGuiElement('c', new ItemStack(Material.GOLDEN_CHESTPLATE), 1, this::openArmorEnchanter, ChatColor.DARK_PURPLE + "R\u00FCstung verzaubern"));
    }

    private boolean openToolEnchanter(GuiElement.Click click) {
        InventoryClickEvent e = click.getEvent();

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        Utils.closeInventory(p);
        new ToolEnchanterGUI().show(p);
        return true;
    }

    private boolean openWeaponEnchanter(GuiElement.Click click) {
        InventoryClickEvent e = click.getEvent();
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        Utils.closeInventory(p);
        new WeaponEnchanterGUI().show(p);
        return true;
    }

    private boolean openArmorEnchanter(GuiElement.Click click) {
        InventoryClickEvent e = click.getEvent();
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        Utils.closeInventory(p);
        new ArmorEnchanterGUI().show(p);
        return true;
    }
}
