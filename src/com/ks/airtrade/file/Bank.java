package com.ks.airtrade.file;

import com.ks.airtrade.constants.Theme;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Bank {
    private static File file;

    private static ConsoleCommandSender console;

    public static FileConfiguration bank;

    public static void setup() {
        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("AirTrade")).getDataFolder(),"bank.yml");
        console = Bukkit.getServer().getConsoleSender();

        if (!file.exists()) {
            console.sendMessage(Theme.mainTheme("Bank file not found, try creating one..."));
            file.getParentFile().mkdirs();
            try {
                if (file.createNewFile()) {
                    console.sendMessage(Theme.mainTheme("Bank file created successfully."));
                }
            }catch (IOException e) {
                console.sendMessage(Theme.errorTheme(e.toString()));
            }

        }
        bank = YamlConfiguration.loadConfiguration(file);
    }

    public static void save() {
        try {
            bank.save(file);
        }catch (IOException e) {
            console.sendMessage(Theme.errorTheme("Bank file cannot be saved!!! Please check the permissions"));
        }
    }

}
