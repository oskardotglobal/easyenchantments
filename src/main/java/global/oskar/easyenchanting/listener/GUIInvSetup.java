package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.utils.ArmorGUILoader;
import global.oskar.easyenchanting.utils.ToolGUILoader;
import global.oskar.easyenchanting.utils.Utils;
import global.oskar.easyenchanting.utils.WeaponGUILoader;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class GUIInvSetup implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onChooseOption(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        ItemStack clicked = e.getCurrentItem();
        if (!Utils.itemExists(clicked)) return;
        if (!clicked.hasItemMeta() || !clicked.getItemMeta().hasDisplayName()) return;

        if (e.getView().getTitle().equalsIgnoreCase("Zaubertisch")) {
            if (clicked.getItemMeta().getDisplayName().contains("Ruestung verzaubern")) {
                ArmorGUILoader.build(p);
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
            } else if (clicked.getItemMeta().getDisplayName().contains("Waffen verzaubern")) {
                WeaponGUILoader.build(p);
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
            } else if (clicked.getItemMeta().getDisplayName().contains("Werkzeuge verzaubern")) {
                ToolGUILoader.build(p);
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
            } else if (clicked.getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 3.0F, 3.0F);
            }
        }
    }
}
