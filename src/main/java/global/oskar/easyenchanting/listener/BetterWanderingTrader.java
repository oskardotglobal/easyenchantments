package global.oskar.easyenchanting.listener;

import com.google.common.collect.Lists;
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

    private MerchantRecipe createRecipe(Material material, Integer price) {
        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(material), 1000, 1000, false);

        List<ItemStack> ingredients = new ArrayList<>();
        ingredients.add(new ItemStack(Material.EMERALD, price));
        recipe.setIngredients(ingredients);

        recipe.setVillagerExperience(1);

        return recipe;
    }

    private final List<MerchantRecipe> wanderingTraderRecipes = new ArrayList<>();

    public BetterWanderingTrader() {
        wanderingTraderRecipes.add(createRecipe(Material.ACACIA_SAPLING, 2));
        wanderingTraderRecipes.add(createRecipe(Material.DARK_OAK_SAPLING, 2));
        wanderingTraderRecipes.add(createRecipe(Material.JUNGLE_SAPLING, 2));
        wanderingTraderRecipes.add(createRecipe(Material.BAMBOO, 2));
        wanderingTraderRecipes.add(createRecipe(Material.MANGROVE_PROPAGULE, 2));
        wanderingTraderRecipes.add(createRecipe(Material.DIAMOND, 15));
        wanderingTraderRecipes.add(createRecipe(Material.DEEPSLATE, 1));
        wanderingTraderRecipes.add(createRecipe(Material.CALCITE, 1));
        wanderingTraderRecipes.add(createRecipe(Material.SPORE_BLOSSOM, 6));
        wanderingTraderRecipes.add(createRecipe(Material.TUFF, 1));
        wanderingTraderRecipes.add(createRecipe(Material.NETHERRACK, 1));
        wanderingTraderRecipes.add(createRecipe(Material.SPONGE, 8));
        wanderingTraderRecipes.add(createRecipe(Material.TALL_GRASS, 8));
        wanderingTraderRecipes.add(createRecipe(Material.FERN, 8));

    }

    @EventHandler
    public void onVillagerSpawn(EntitySpawnEvent e) {
        switch (e.getEntityType()) {
            case WANDERING_TRADER -> {
                WanderingTrader villager = (WanderingTrader) e.getEntity();
                List<MerchantRecipe> recipes = Lists.newArrayList(villager.getRecipes());

                Iterator<MerchantRecipe> recipeIterator;

                for (recipeIterator = recipes.iterator(); recipeIterator.hasNext(); ) {
                    MerchantRecipe recipe = recipeIterator.next();
                    recipes.remove(recipe);
                }

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
