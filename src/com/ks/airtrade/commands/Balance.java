package com.ks.airtrade.commands;

import com.ks.airtrade.file.Bank;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Balance implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player player) {
                player.sendMessage(ChatColor.GREEN+"你現在有$"+ Bank.getUserBalance(player.getName()));
            }else {
                sender.sendMessage(ChatColor.RED+"你是誰啊?講話啊!");
            }

        }else {
            String name = args[0];
            int bal = Bank.getUserBalance(name);
            if (bal == -1) {
                sender.sendMessage(ChatColor.RED+"找不到"+name);
            }else {
                sender.sendMessage(ChatColor.GREEN + name + "現在有$" + bal);
            }
        }
        return true;
    }
}
