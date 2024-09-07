package com.ks.airtrade.commands;

import com.ks.airtrade.constants.ShopName;
import com.ks.airtrade.constants.Theme;
import com.ks.airtrade.file.Bank;
import com.ks.airtrade.shops.ShopMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class Shop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player player) {
            ShopMain.openInventory(player);
        }else {
            sender.sendMessage(Theme.mainTheme("WARNING: You cannot execute this command here."));
        }
        return true;
    }
}
