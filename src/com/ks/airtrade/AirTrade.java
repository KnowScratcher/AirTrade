package com.ks.airtrade;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class AirTrade extends JavaPlugin {

    @Override
    public void onEnable() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(ChatColor.LIGHT_PURPLE+"Setting up air trade...");

        console.sendMessage(ChatColor.LIGHT_PURPLE+"Setting done.");
    }
}
