package com.ks.airtrade.commands;

import com.ks.airtrade.constants.ShopName;
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
            Inventory shop = Bukkit.createInventory(player,36, ShopName.MAIN);

            ItemStack player_head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta player_head_meta = (SkullMeta) player_head.getItemMeta();
            assert player_head_meta != null;
            player_head_meta.setOwnerProfile(player.getPlayerProfile());
            player_head_meta.setDisplayName(ChatColor.YELLOW + player.getName());

        }

        return true;
    }
}
