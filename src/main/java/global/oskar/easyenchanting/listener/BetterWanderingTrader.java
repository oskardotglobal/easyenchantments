package global.oskar.easyenchanting.listener;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.*;

public class BetterWanderingTrader implements Listener {

    private MerchantRecipe createRecipe(Material material, Integer price, Integer amount) {
        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(material, amount), 0, 1000, false);

        List<ItemStack> ingredients = new ArrayList<>();
        ingredients.add(new ItemStack(Material.EMERALD, price));
        recipe.setIngredients(ingredients);

        recipe.setVillagerExperience(1);

        return recipe;
    }

    private final List<MerchantRecipe> wanderingTraderRecipes = new ArrayList<>();

    public BetterWanderingTrader() {
        wanderingTraderRecipes.add(createRecipe(Material.ACACIA_SAPLING, 2, 3));
        wanderingTraderRecipes.add(createRecipe(Material.DARK_OAK_SAPLING, 2, 3));
        wanderingTraderRecipes.add(createRecipe(Material.JUNGLE_SAPLING, 2, 3));
        wanderingTraderRecipes.add(createRecipe(Material.BAMBOO, 2, 10));
        wanderingTraderRecipes.add(createRecipe(Material.MANGROVE_PROPAGULE, 2, 3));
        wanderingTraderRecipes.add(createRecipe(Material.DIAMOND, 15, 1));
        wanderingTraderRecipes.add(createRecipe(Material.DEEPSLATE, 1, 10));
        wanderingTraderRecipes.add(createRecipe(Material.CALCITE, 1, 10));
        wanderingTraderRecipes.add(createRecipe(Material.SPORE_BLOSSOM, 6, 1));
        wanderingTraderRecipes.add(createRecipe(Material.TUFF, 1, 10));
        wanderingTraderRecipes.add(createRecipe(Material.NETHERRACK, 1, 10));
        wanderingTraderRecipes.add(createRecipe(Material.SPONGE, 8, 1));
        wanderingTraderRecipes.add(createRecipe(Material.TALL_GRASS, 2, 3));
        wanderingTraderRecipes.add(createRecipe(Material.FERN, 2, 3));
        wanderingTraderRecipes.add(createRecipe(Material.BRAIN_CORAL_FAN, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.FIRE_CORAL_FAN, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.TUBE_CORAL_FAN, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.HORN_CORAL_FAN, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.BUBBLE_CORAL_FAN, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.BRAIN_CORAL, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.FIRE_CORAL, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.TUBE_CORAL, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.HORN_CORAL, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.BUBBLE_CORAL, 2, 1));
        wanderingTraderRecipes.add(createRecipe(Material.BRAIN_CORAL_BLOCK, 1, 1));
        wanderingTraderRecipes.add(createRecipe(Material.FIRE_CORAL_BLOCK, 1, 1));
        wanderingTraderRecipes.add(createRecipe(Material.TUBE_CORAL_BLOCK, 1, 1));
        wanderingTraderRecipes.add(createRecipe(Material.HORN_CORAL_BLOCK, 1, 1));
        wanderingTraderRecipes.add(createRecipe(Material.BUBBLE_CORAL_BLOCK, 1, 1));
    }

    @EventHandler
    public void onVillagerSpawn(EntitySpawnEvent e) {
        switch (e.getEntityType()) {
            case WANDERING_TRADER -> {
                WanderingTrader villager = (WanderingTrader) e.getEntity();
                villager.setRecipes(this.wanderingTraderRecipes);
            }

            case VILLAGER -> {
                Villager villager = (Villager) e.getEntity();
                if (villager.getProfession() != Villager.Profession.LIBRARIAN) return;
                e.setCancelled(true);
            }
        }
    }
}
