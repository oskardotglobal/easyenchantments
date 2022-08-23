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
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;



public class DisableLibrariansListener implements Listener {

    private MerchantRecipe getMissingItemMerchantRecipe(Material material, Integer price) {
        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(material, ThreadLocalRandom.current().nextInt(2,  5)), ThreadLocalRandom.current().nextInt(9,  21));
        recipe.setSpecialPrice(price);
        return recipe;
    }

    private final HashMap<Material, MerchantRecipe> replace = new HashMap<>();

    public DisableLibrariansListener() {
        replace.put(Material.DIAMOND_AXE, getMissingItemMerchantRecipe(Material.ACACIA_SAPLING, 2));
        replace.put(Material.DIAMOND_CHESTPLATE, getMissingItemMerchantRecipe(Material.DARK_OAK_SAPLING, 2));
        replace.put(Material.DIAMOND_LEGGINGS, getMissingItemMerchantRecipe(Material.JUNGLE_SAPLING, 2));
        replace.put(Material.DIAMOND_HELMET, getMissingItemMerchantRecipe(Material.BAMBOO, 2));
        replace.put(Material.DIAMOND_PICKAXE, getMissingItemMerchantRecipe(Material.MANGROVE_PROPAGULE, 2));
        replace.put(Material.DIAMOND_SHOVEL, getMissingItemMerchantRecipe(Material.DIAMOND, 15));
        replace.put(Material.DIAMOND_SWORD, getMissingItemMerchantRecipe(Material.DEEPSLATE, 1));
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
