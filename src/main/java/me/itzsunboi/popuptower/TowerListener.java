package me.itzsunboi.popuptower;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;

public class TowerListener implements Listener {
    private final Popup_Tower plugin;
    private final List<Layer> layers;

    public TowerListener(Popup_Tower plugin) {
        this.plugin = plugin;
        this.layers = createtower.createLayers();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        // Check if the player interacted with a chest item that matches the specific chest
        if (isSpecificChest(item)) {
            event.setCancelled(true); // Prevent chest from being placed
            generateTower(player);

            // Optional: Remove the chest item from the player's inventory
            int amount = item.getAmount();
            if (amount > 1) {
                item.setAmount(amount - 1);
            } else {
                player.getInventory().remove(item);
            }
        }
    }

    private boolean isSpecificChest(ItemStack item) {
        if (item != null && item.getType() == Material.CHEST && item.hasItemMeta()) {
            // Check for specific chest characteristics (customize as needed)
            // Example: Check for a custom tag or lore
            if (item.getItemMeta().hasDisplayName()) {
                String displayName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
                return displayName.equals("Pop-Up Tower");
            }
        }
        return false;
    }

    private void generateTower(Player player) {
        Block startBlock = player.getLocation().getBlock();
        BukkitScheduler scheduler = Bukkit.getScheduler();

        for (int i = 0; i < layers.size(); i++) {
            final int layerIndex = i;
            scheduler.runTaskLater(plugin, () -> spawnLayer(startBlock, layerIndex), i * (long) 2);
        }
    }

    private void spawnLayer(Block startBlock, int layerIndex) {
        for (Point point : layers.get(layerIndex).getPoints()) {
            int x = point.getX();
            int y = layerIndex;
            int z = point.getY();

            Block block = startBlock.getRelative(x, y, z);

            if (point.getX() == -1 && point.getY() == 0) {
                // Example: set ladder block facing east
                block.setType(Material.LADDER);

                // Adjust ladder orientation
                org.bukkit.block.data.type.Ladder ladder = (org.bukkit.block.data.type.Ladder) block.getBlockData();
                ladder.setFacing(BlockFace.EAST);  // Set the ladder facing east
                block.setBlockData(ladder);

                // Add additional logic for ladder orientation if needed
            } else {
                // Example: set red wool block
                block.setType(Material.RED_WOOL);
            }
        }
    }


    private void setLadderOrientation(Block block) {
        // Check if the block supports BlockData
        if (block.getBlockData() instanceof org.bukkit.block.data.type.Ladder) {
            org.bukkit.block.data.type.Ladder ladder = (org.bukkit.block.data.type.Ladder) block.getBlockData();

            // Set ladder facing east
            ladder.setFacing(org.bukkit.block.BlockFace.EAST);

            // Update the block with the new BlockData
            block.setBlockData(ladder);
        }
    }
}
