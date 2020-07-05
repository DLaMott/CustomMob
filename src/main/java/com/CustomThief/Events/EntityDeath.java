package com.CustomThief.Events;

import com.CustomThief.Main;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDeath implements Listener {
    private final Main plugin;
    private final ItemStack[] goldsack = {
            new ItemStack(Material.GOLDEN_HELMET, 2),
            new ItemStack(Material.GOLDEN_AXE, 2),
            new ItemStack(Material.GOLD_NUGGET, 16),
            new ItemStack(Material.GOLDEN_SWORD, 2),
            new ItemStack(Material.EXPERIENCE_BOTTLE, 4),
            new ItemStack(Material.GUARDIAN_SPAWN_EGG, 4),
            new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 5),
    };

    public EntityDeath(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDeathEvent event) {
        if (!(event.getEntity() instanceof Villager))
            return;
        if (event.getEntity().getCustomName() == null)
            return;
        if (!event.getEntity().getCustomName().contains("Thief"))
            return;

        Random r = new Random();
        event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                goldsack[r.nextInt(goldsack.length + 0) - 0]);

        for (ItemStack item : plugin.stolenItems) {
            if (item != null)
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), item);
        }
    }
}
