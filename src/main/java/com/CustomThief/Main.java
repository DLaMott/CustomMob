package com.CustomThief;

import com.CustomThief.Events.BlockPlace;
import com.CustomThief.Events.EntityDamage;
import com.CustomThief.Events.EntityDeath;
import com.CustomThief.Mob.Config;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public class Main extends JavaPlugin {
    public List<ItemStack> stolenItems = new ArrayList<>();
    private Config config;

    @Override
    public void onEnable() {
        this.config = new Config(this);
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new EntityDamage(), this);
        pm.registerEvents(new EntityDeath(this), this);
        pm.registerEvents(new BlockPlace(this), this);

    }

    @Override
    public void onDisable() {

    }

}

