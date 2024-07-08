package com.ks.airtrade.commands;

import com.ks.airtrade.constants.ShopName;
import com.ks.airtrade.constants.Theme;
import com.ks.airtrade.file.Bank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Shop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player player) {

            String name = player.getName();
            int balance = Bank.bank.getInt(name,-1); // deal with new player
            if (balance == -1) {
                Bank.bank.set(name,0);
                Bank.save();
            }

            Inventory shop = Bukkit.createInventory(player,36, ShopName.MAIN);

            ItemStack player_head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta player_head_meta = (SkullMeta) player_head.getItemMeta();
            assert player_head_meta != null;
            player_head_meta.setOwnerProfile(player.getPlayerProfile());
            player_head_meta.setDisplayName(ChatColor.YELLOW + player.getName());
            player_head.setItemMeta(player_head_meta);

            ItemStack[] items = {player_head};
            shop.setContents(items);
            player.openInventory(shop);
        }else {
            sender.sendMessage(Theme.mainTheme("WARNING: You cannot execute this command here."));
        }
        return true;
    }
}
