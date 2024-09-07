package com.ks.airtrade.shops;

import com.ks.airtrade.constants.ShopName;
import com.ks.airtrade.file.Bank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class ShopMain implements Listener {

    // ENTITY_ENDERMAN_TELEPORT 0.5f
    // UI_BUTTON_CLICK 1.0f
    // BLOCK_NOTE_BLOCK_HARP 2.0f

    public static void openInventory(Player player) {
        String name = player.getName();
        int balance = Bank.getUserBalance(name); // deal with new player
        if (balance == -1) {
            Bank.bank.set(name,0);
            Bank.save();
        }
        Inventory shop = Bukkit.createInventory(player,54, ShopName.MAIN);

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

        // woods
        ItemStack woods = new ItemStack(Material.OAK_LOG);
        ItemMeta woods_meta = woods.getItemMeta();
        assert woods_meta != null;
        woods_meta.setDisplayName(ChatColor.GREEN+"木頭");
        woods_meta.setLore(List.of(ChatColor.YELLOW+"原木,木材"));
        woods.setItemMeta(woods_meta);

        // stones
        ItemStack stones = new ItemStack(Material.STONE);
        ItemMeta stones_meta = stones.getItemMeta();
        assert stones_meta != null;
        stones_meta.setDisplayName(ChatColor.GREEN+"石頭");
        stones_meta.setLore(List.of(ChatColor.YELLOW+"石頭製品"));
        stones.setItemMeta(stones_meta);

        // natural
        ItemStack natural = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta natural_meta = natural.getItemMeta();
        assert natural_meta != null;
        natural_meta.setDisplayName(ChatColor.GREEN+"自然方塊");
        natural_meta.setLore(List.of(ChatColor.YELLOW+"生物方塊,土"));
        natural.setItemMeta(natural_meta);

        // tool
        ItemStack tool = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta tool_meta = tool.getItemMeta();
        assert tool_meta != null;
        tool_meta.setDisplayName(ChatColor.GREEN+"工具");
        tool_meta.setLore(List.of(ChatColor.YELLOW+"就工具"));
        tool.setItemMeta(tool_meta);

        // mineral
        ItemStack mineral = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta mineral_meta = mineral.getItemMeta();
        assert mineral_meta != null;
        mineral_meta.setDisplayName(ChatColor.GREEN+"礦物");
        mineral_meta.setLore(List.of(ChatColor.YELLOW+"礦石,礦物"));
        mineral.setItemMeta(mineral_meta);

        // storage
        ItemStack storage = new ItemStack(Material.CHEST);
        ItemMeta storage_meta = storage.getItemMeta();
        assert storage_meta != null;
        storage_meta.setDisplayName(ChatColor.GREEN+"儲存體");
        storage_meta.setLore(List.of(ChatColor.YELLOW+"儲物箱,界伏盒..."));
        storage.setItemMeta(storage_meta);

        // redstone
        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemMeta redstone_meta = redstone.getItemMeta();
        assert redstone_meta != null;
        redstone_meta.setDisplayName(ChatColor.GREEN+"紅石");
        redstone_meta.setLore(List.of(ChatColor.YELLOW+"自己腦袋小心"));
        redstone.setItemMeta(redstone_meta);

        // food
        ItemStack food = new ItemStack(Material.COOKED_BEEF);
        ItemMeta food_meta = food.getItemMeta();
        assert food_meta != null;
        food_meta.setDisplayName(ChatColor.GREEN+"食物");
        food_meta.setLore(List.of(ChatColor.YELLOW+"不要吃壞肚子啦"));
        food.setItemMeta(food_meta);

        // egg
        ItemStack egg = new ItemStack(Material.VILLAGER_SPAWN_EGG);
        ItemMeta egg_meta = egg.getItemMeta();
        assert egg_meta != null;
        egg_meta.setDisplayName(ChatColor.GREEN+"蛋");
        egg_meta.setLore(List.of(ChatColor.YELLOW+"神奇的東西出生了"));
        egg.setItemMeta(egg_meta);

        // combat
        ItemStack combat = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta combat_meta = combat.getItemMeta();
        assert combat_meta != null;
        combat_meta.setDisplayName(ChatColor.GREEN+"戰鬥用品");
        combat_meta.setLore(List.of(ChatColor.YELLOW+"好痛"));
        combat.setItemMeta(combat_meta);

        // enchants
        ItemStack enchants = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta enchants_meta = enchants.getItemMeta();
        assert enchants_meta != null;
        enchants_meta.setDisplayName(ChatColor.GREEN+"附魔書");
        enchants_meta.setLore(List.of(ChatColor.YELLOW+"魔法攻擊!!!"));
        enchants.setItemMeta(enchants_meta);


        //bank
        ItemStack bank = new ItemStack(Material.EMERALD);
        ItemMeta bank_meta = bank.getItemMeta();
        assert bank_meta != null;
        bank_meta.setDisplayName(ChatColor.GREEN+"銀行");
        bank_meta.setLore(List.of(ChatColor.YELLOW+"$$$"));
        bank.setItemMeta(bank_meta);

        ItemStack[] items = {
                placeholder,placeholder,placeholder,placeholder,player_head,placeholder,placeholder,placeholder,placeholder,
                placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,
                placeholder,woods,stones,natural,tool,mineral,storage,redstone,placeholder,
                placeholder,food,egg,combat,enchants,null,null,null,placeholder,
                placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,
                placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,placeholder,bank
        };
        shop.setContents(items);
        player.openInventory(shop);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getView().getTitle().equals(ShopName.MAIN)) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            switch (e.getCurrentItem().getType()) {
                case GRAY_STAINED_GLASS_PANE:
                    player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT,1.0f,0.5f);
                    break;
                case OAK_LOG:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case STONE:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case GRASS_BLOCK:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case DIAMOND_AXE:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case NETHERITE_INGOT:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case CHEST:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case REDSTONE:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case COOKED_BEEF:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case VILLAGER_SPAWN_EGG:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case DIAMOND_SWORD:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    break;
                case EMERALD:
                    player.playSound(player, Sound.UI_BUTTON_CLICK,1.0f,1.0f);
                    e.getView().close();
                    ShopBank.openInventory(player);
                    break;
            }
        }
    }

}
