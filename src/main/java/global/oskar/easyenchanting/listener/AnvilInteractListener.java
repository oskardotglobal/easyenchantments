package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class AnvilInteractListener implements Listener {
    public void onAnvilInteract(PrepareAnvilEvent e) {
        Player p = (Player) e.getView().getPlayer();
        ItemStack item = e.getResult();

        if (item == null) return;

        if (item.getEnchantments().size() == 3) {
            Utils.closeInventory(p);
            Utils.sendMessage(p, "Dieses Item hat bereits 3 Enchantments!", ChatColor.RED);
        }
    }
}
