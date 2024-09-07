package com.ks.airtrade.shops;

import com.ks.airtrade.actions.SellManage;
import com.ks.airtrade.constants.PriceManager;
import com.ks.airtrade.constants.ShopName;
import com.ks.airtrade.file.Bank;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ShopBank implements Listener {

    private static ItemStack emerald_1;
    private static ItemStack emerald_2;
    private static ItemStack emerald_4;
    private static ItemStack emerald_8;
    private static ItemStack emerald_16;
    private static ItemStack emerald_32;
    private static ItemStack emerald_64;

    public static void openInventory(Player player) {
        String name = player.getName();
        int balance = Bank.getUserBalance(name); // deal with new player
        if (balance == -1) {
            Bank.bank.set(name,0);
            Bank.save();
        }
        Inventory shop = Bukkit.createInventory(player,54, ShopName.BANK);

        // placeholder
        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeholder_meta = placeholder.getItemMeta();
        assert placeholder_meta != null;
        placeholder_meta.setDisplayName(ChatColor.YELLOW + "不要戳我啦");
        placeholder.setItemMeta(placeholder_meta);

        // balance
        ItemStack player_head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta player_head_meta = (SkullMeta) player_head.getItemMeta();
        assert player_head_meta != null;
        player_head_meta.setOwnerProfile(player.getPlayerProfile());
        player_head_meta.setDisplayName(ChatColor.YELLOW + player.getName());
        player_head_meta.setLore(List.of(ChatColor.GREEN+"餘額: "+balance));
        player_head.setItemMeta(player_head_meta);

        // emerald_1
        emerald_1 = new ItemStack(Material.EMERALD,1);
        ItemMeta emerald_1_meta = emerald_1.getItemMeta();
        assert emerald_1_meta != null;
        emerald_1_meta.getPersistentDataContainer().set(NamespacedKey.minecraft("price"), PersistentDataType.INTEGER, PriceManager.price.getInt("emerald"));
        emerald_1_meta.setDisplayName(ChatColor.YELLOW + "綠寶石x1");
        emerald_1_meta.setLore(List.of(ChatColor.LIGHT_PURPLE+"+$"+PriceManager.price.getInt("emerald")));
        emerald_1.setItemMeta(emerald_1_meta);

        // emerald_2
        emerald_2 = new ItemStack(Material.EMERALD,2);
        ItemMeta emerald_2_meta = emerald_2.getItemMeta();
        assert emerald_2_meta != null;
        emerald_2_meta.getPersistentDataContainer().set(NamespacedKey.minecraft("price"), PersistentDataType.INTEGER, PriceManager.price.getInt("emerald")*2);
        emerald_2_meta.setDisplayName(ChatColor.YELLOW + "綠寶石x1");
        emerald_2_meta.setLore(List.of(ChatColor.LIGHT_PURPLE+"+$"+PriceManager.price.getInt("emerald")*2));
        emerald_2.setItemMeta(emerald_2_meta);

        // emerald_4
        emerald_4 = new ItemStack(Material.EMERALD,4);
        ItemMeta emerald_4_meta = emerald_4.getItemMeta();
        assert emerald_4_meta != null;
        emerald_4_meta.getPersistentDataContainer().set(NamespacedKey.minecraft("price"), PersistentDataType.INTEGER, PriceManager.price.getInt("emerald")*4);
        emerald_4_meta.setDisplayName(ChatColor.YELLOW + "綠寶石x1");
        emerald_4_meta.setLore(List.of(ChatColor.LIGHT_PURPLE+"+$"+PriceManager.price.getInt("emerald")*4));
        emerald_4.setItemMeta(emerald_4_meta);

        // emerald_8
        emerald_8 = new ItemStack(Material.EMERALD,8);
        ItemMeta emerald_8_meta = emerald_8.getItemMeta();
        assert emerald_8_meta != null;
        emerald_8_meta.getPersistentDataContainer().set(NamespacedKey.minecraft("price"), PersistentDataType.INTEGER, PriceManager.price.getInt("emerald")*8);
        emerald_8_meta.setDisplayName(ChatColor.YELLOW + "綠寶石x1");
        emerald_8_meta.setLore(List.of(ChatColor.LIGHT_PURPLE+"+$"+PriceManager.price.getInt("emerald")*8));
        emerald_8.setItemMeta(emerald_8_meta);

        // emerald_16
        emerald_16 = new ItemStack(Material.EMERALD,16);
        ItemMeta emerald_16_meta = emerald_16.getItemMeta();
        assert emerald_16_meta != null;
        emerald_16_meta.getPersistentDataContainer().set(NamespacedKey.minecraft("price"), PersistentDataType.INTEGER, PriceManager.price.getInt("emerald")*16);
        emerald_16_meta.setDisplayName(ChatColor.YELLOW + "綠寶石x1");
        emerald_16_meta.setLore(List.of(ChatColor.LIGHT_PURPLE+"+$"+PriceManager.price.getInt("emerald")*16));
        emerald_16.setItemMeta(emerald_16_meta);

        // emerald_32
        emerald_32 = new ItemStack(Material.EMERALD,32);
        ItemMeta emerald_32_meta = emerald_32.getItemMeta();
        assert emerald_32_meta != null;
        emerald_32_meta.getPersistentDataContainer().set(NamespacedKey.minecraft("price"), PersistentDataType.INTEGER, PriceManager.price.getInt("emerald")*32);
        emerald_32_meta.setDisplayName(ChatColor.YELLOW + "綠寶石x1");
        emerald_32_meta.setLore(List.of(ChatColor.LIGHT_PURPLE+"+$"+PriceManager.price.getInt("emerald")*32));
        emerald_32.setItemMeta(emerald_32_meta);

        // emerald_64
        emerald_64 = new ItemStack(Material.EMERALD,64);
        ItemMeta emerald_64_meta = emerald_64.getItemMeta();
        assert emerald_64_meta != null;
        emerald_64_meta.getPersistentDataContainer().set(NamespacedKey.minecraft("price"), PersistentDataType.INTEGER, PriceManager.price.getInt("emerald")*64);
        emerald_64_meta.setDisplayName(ChatColor.YELLOW + "綠寶石x1");
        emerald_64_meta.setLore(List.of(ChatColor.LIGHT_PURPLE+"+$"+PriceManager.price.getInt("emerald")*64));
        emerald_64.setItemMeta(emerald_64_meta);

        // back
        ItemStack back = new ItemStack(Material.BARRIER);
        ItemMeta back_meta = back.getItemMeta();
        assert back_meta != null;
        back_meta.setDisplayName(ChatColor.YELLOW + "回上頁");
        back.setItemMeta(back_meta);

        ItemStack[] items = {
                placeholder,placeholder,placeholder,placeholder,player_head,placeholder,placeholder,placeholder,placeholder,
                placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,
                placeholder,emerald_1,emerald_2,emerald_4,emerald_8,emerald_16,emerald_32,emerald_64,placeholder,
                placeholder,null,null,null,null,null,null,null,placeholder,
                placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,
                placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,back
        };
        shop.setContents(items);
        player.openInventory(shop);
    }

    @EventHandler
    public void onclick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ShopName.BANK)) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem().getType() != Material.BARRIER) {
                if (SellManage.sell(player,e.getCurrentItem())) {
                    player.playSound(player,Sound.BLOCK_NOTE_BLOCK_HARP,1.0f,2.0f);
                }else {
                    player.playSound(player,Sound.ENTITY_ENDERMAN_TELEPORT,1.0f,0.5f);
                }
            }else {
                player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                e.getView().close();
                ShopMain.openInventory(player);
            }
        }
    }
}
