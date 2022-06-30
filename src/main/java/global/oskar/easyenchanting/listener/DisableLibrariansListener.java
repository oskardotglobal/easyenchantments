package global.oskar.easyenchanting.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;

public class DisableLibrariansListener implements Listener {
    @EventHandler
    public void onCareerChange(VillagerCareerChangeEvent e) {
        if (e.getProfession() == Villager.Profession.LIBRARIAN) e.setCancelled(true);
    }

    @EventHandler
    public void onVillagerSpawn(EntitySpawnEvent e) {
        if (e.getEntity().getType() != EntityType.VILLAGER) return;
        Villager villager = (Villager) e.getEntity();
        if (villager.getProfession() != Villager.Profession.LIBRARIAN) return;
        e.setCancelled(true);
    }
}
