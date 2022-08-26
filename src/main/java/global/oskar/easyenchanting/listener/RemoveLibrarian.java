package global.oskar.easyenchanting.listener;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerCareerChangeEvent;

public class RemoveLibrarian implements Listener {
    @EventHandler
    public void onCareerChange(VillagerCareerChangeEvent e) {
        if (e.getProfession() == Villager.Profession.LIBRARIAN) e.setCancelled(true);
    }
}
