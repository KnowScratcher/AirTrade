package com.ks.airtrade.constants;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class PriceManager {

    public static FileConfiguration price;

    public static void init(FileConfiguration config) {
        price = config;
    }
}
