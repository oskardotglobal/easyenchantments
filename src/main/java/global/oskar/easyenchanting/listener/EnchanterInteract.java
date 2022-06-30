package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.lib.MainMenuGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnchanterInteract implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent e) {

            Player p = e.getPlayer();
            if (e.getClickedBlock().getType().equals(Material.ENCHANTING_TABLE) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                e.setCancelled(true);
                new MainMenuGUI().show(p);
            }

    }
}
