package global.oskar.easyenchanting.listener;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DisableLibrariansListener implements Listener {
    private final HashMap<Material, MerchantRecipe> replace = new HashMap<>();

    public DisableLibrariansListener() {
        replace.put(Material.DIAMOND_BOOTS, new MerchantRecipe(new ItemStack(Material.ACACIA_SAPLING, ThreadLocalRandom.current().nextInt(2,  5)), ThreadLocalRandom.current().nextInt(9,  21)));
        replace.put(Material.DIAMOND_HELMET, new MerchantRecipe(new ItemStack(Material.DARK_OAK_SAPLING, ThreadLocalRandom.current().nextInt(2,  5)), ThreadLocalRandom.current().nextInt(9,  21)));
        replace.put(Material.DIAMOND_CHESTPLATE, new MerchantRecipe(new ItemStack(Material.JUNGLE_SAPLING, ThreadLocalRandom.current().nextInt(2,  5)), ThreadLocalRandom.current().nextInt(9,  21)));
        replace.put(Material.DIAMOND_LEGGINGS, new MerchantRecipe(new ItemStack(Material.BAMBOO, ThreadLocalRandom.current().nextInt(2,  5)), ThreadLocalRandom.current().nextInt(9,  21)));
        replace.put(Material.DIAMOND_AXE, null);
        replace.put(Material.DIAMOND_PICKAXE, null);
        replace.put(Material.DIAMOND_SHOVEL, null);
        replace.put(Material.DIAMOND_SWORD, null);
        replace.put(Material.DIAMOND_HOE, null);
    }

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

    @EventHandler
    public void removeTrades(VillagerAcquireTradeEvent e) {
        Villager villager = (Villager) e.getEntity();
        List<MerchantRecipe> recipes = Lists.newArrayList(villager.getRecipes());

        Iterator<MerchantRecipe> recipeIterator;
        for (recipeIterator = recipes.iterator(); recipeIterator.hasNext(); ) {
            MerchantRecipe recipe = recipeIterator.next();

            if (replace.get(recipe.getResult().getType()) == null) {
                recipes.remove(e.getRecipe());
            } else {
                recipes.set(recipes.indexOf(recipe), replace.get((recipe.getResult().getType())));
            }
        }

        villager.setRecipes(recipes);
    }
}
