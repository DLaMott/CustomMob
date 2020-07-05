package com.CustomThief.Events;

import com.CustomThief.Main;
import com.CustomThief.Mob.Thief;
import net.minecraft.server.v1_15_R1.WorldServer;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockPlace implements Listener {
    private final Main plugin;

    public BlockPlace(Main plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!event.getBlock().getType().equals(Material.GRASS_BLOCK))
            return;

        Random r = new Random();
        if ((r.nextInt((1000 + 0) - 0) > 100))
            return;

        Thief CrazyJimmy = new Thief(event.getPlayer().getLocation());
        WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
        world.addEntity(CrazyJimmy);

        event.setCancelled(true);

        for (ItemStack item : event.getPlayer().getInventory().getContents())
            plugin.stolenItems.add(item);

        event.getPlayer().getInventory().clear();
    }
}
