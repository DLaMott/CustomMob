package com.CustomThief.Mob;

import com.CustomThief.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private final FileConfiguration config;

    public Config(Main plugin) {
        this.config = plugin.getConfig();
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }
}
