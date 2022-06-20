package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.utils.ArmorGUILoader;
import global.oskar.easyenchanting.utils.ToolGUILoader;
import global.oskar.easyenchanting.utils.Utils;
import global.oskar.easyenchanting.utils.WeaponGUILoader;
import org.bukkit.ChatColor;
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

        ItemStack clicked = e.getClickedInventory().getItem(e.getSlot());
        if (!Utils.itemExists(clicked)) return;
        if (!clicked.hasItemMeta() || !clicked.getItemMeta().hasDisplayName()) return;

        if (e.getView().getTitle().equalsIgnoreCase("Zaubertisch")) {
            e.setCancelled(true);
            switch (ChatColor.stripColor(clicked.getItemMeta().getDisplayName())) {
                case "Ruestung verzaubern" -> {
                    ArmorGUILoader.build(p);
                    break;
                }
                case "Waffen verzaubern" -> {
                    WeaponGUILoader.build(p);
                    break;
                }
                case "Werkzeuge verzaubern" -> {
                    ToolGUILoader.build(p);
                    break;
                }
            }

            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 3.0F);
        }
    }
}
