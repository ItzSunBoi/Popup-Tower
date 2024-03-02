package me.itzsunboi.popuptower;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public final class Popup_Tower extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TowerListener(this), this);
        getLogger().info("PopupTowerPlugin has been enabled!");
        registerCraftingRecipe();
    }

    @Override
    public void onDisable() {
        getLogger().info("PopupTowerPlugin has been disabled.");
    }
    private void registerCraftingRecipe() {
        // Create a custom NamespacedKey for your recipe
        NamespacedKey key = new NamespacedKey(this, "popupTower");

        // Create the recipe with a shaped pattern
        ShapedRecipe recipe = new ShapedRecipe(key, createCustomItem());


        // Define the crafting pattern
        recipe.shape("WRW", "SCS", "WRW");

        // Define the ingredients
        recipe.setIngredient('W', Material.WHITE_WOOL);
        recipe.setIngredient('R', Material.RED_DYE);
        recipe.setIngredient('S', Material.REDSTONE);
        recipe.setIngredient('C', Material.CHEST);

        // Register the recipe
        getServer().addRecipe(recipe);
    }
    private ItemStack createCustomItem() {
        ItemStack customItem = new ItemStack(Material.CHEST);
        ItemMeta itemMeta = customItem.getItemMeta();

        // Set display name and lore
        itemMeta.setDisplayName("§cPop-Up Tower");
        itemMeta.setLore(java.util.Arrays.asList("§7The Tower of the RED WOOL"));

        // Add custom tag
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(this, "CustomTag"), org.bukkit.persistence.PersistentDataType.BYTE, (byte) 1);

        // Add enchantment (optional)
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);

        // Add item flags (optional)
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Apply the modified meta to the item
        customItem.setItemMeta(itemMeta);

        return customItem;
    }
}

