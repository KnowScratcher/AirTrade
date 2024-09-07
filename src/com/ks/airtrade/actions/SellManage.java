package com.ks.airtrade.actions;

import com.ks.airtrade.file.Bank;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class SellManage {

    public static boolean buy(Player player, ItemStack itemStack, int price) {
        if (player.getInventory().addItem(itemStack).isEmpty()) {
            return Bank.addUserBalance(player,-1*price); // true if success else false
        }else {
            player.sendMessage(ChatColor.RED+"你的背包已滿");
            return false;
        }
    }

    public static boolean sell(Player player,ItemStack itemStack) {
        NamespacedKey key = NamespacedKey.minecraft("price");
        if (itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER)) {
            int price = itemStack.getItemMeta().getPersistentDataContainer().get(key,PersistentDataType.INTEGER);
            if (player.getInventory().contains(itemStack.getType(),itemStack.getAmount())) {
                player.getInventory().removeItem(new ItemStack(itemStack.getType(),itemStack.getAmount()));
                return Bank.addUserBalance(player,price); // true if success else false
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}
