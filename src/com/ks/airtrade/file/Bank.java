package com.ks.airtrade.file;

import com.ks.airtrade.constants.Theme;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Bank {

    private static File file;

    public static FileConfiguration bank;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("AirTrade").getDataFolder(),"bank.yml");

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        if (!file.exists()) {
            console.sendMessage(Theme.mainTheme("Bank file not found, try creating one..."));
            try {
                if (file.createNewFile()) {
                    console.sendMessage(Theme.mainTheme("Bank file created successfully."));
                }
            }catch (IOException e) {
                console.sendMessage(Theme.errorTheme("Could not create bank file, please check the permissions."));
            }
        }
        bank = YamlConfiguration.loadConfiguration(file);
    }

}
