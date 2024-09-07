package com.ks.airtrade.file;

import com.ks.airtrade.constants.Theme;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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

    public static boolean save() {
        try {
            bank.save(file);
            return true;
        }catch (IOException e) {
            console.sendMessage(Theme.errorTheme("Bank file cannot be saved!!! Please check the permissions"));
            return false;
        }
    }

    public static boolean register(String name) {
        bank.set(name,0);
        return save();
    }

    public static boolean register(Player player) {
        bank.set(player.getName(),0);
        return save();
    }

    public static int getUserBalance(String name) {
        return bank.getInt(name,-1);
    }

    public static int getUserBalance(Player player) {
        return bank.getInt(player.getName(),-1);
    }

    public static boolean setUserBalance(String name,int balance) {
        bank.set(name,balance);
        return save();
    }

    public static boolean setUserBalance(Player player,int balance) {
        bank.set(player.getName(),balance);
        return save();
    }

    public static boolean addUserBalance(String name,int balance) {
        bank.set(name,getUserBalance(name)+balance);
        return save();
    }

    public static boolean addUserBalance(Player player,int balance) {
        bank.set(player.getName(),getUserBalance(player)+balance);
        return save();
    }

}
