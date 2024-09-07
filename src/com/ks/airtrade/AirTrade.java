package com.ks.airtrade;

import com.ks.airtrade.commands.Balance;
import com.ks.airtrade.commands.Shop;
import com.ks.airtrade.constants.PriceManager;
import com.ks.airtrade.constants.Theme;
import com.ks.airtrade.shops.ShopBank;
import com.ks.airtrade.shops.ShopMain;
import com.ks.airtrade.file.Bank;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class AirTrade extends JavaPlugin {

    @Override
    public void onEnable() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(Theme.mainTheme("Setting up air trade..."));

        console.sendMessage(Theme.mainTheme("----------------------------"));
        console.sendMessage(Theme.mainTheme("      *        *************"));
        console.sendMessage(Theme.mainTheme("     * *             *      "));
        console.sendMessage(Theme.mainTheme("    *   *            *      "));
        console.sendMessage(Theme.mainTheme("   *     *           *      "));
        console.sendMessage(Theme.mainTheme("  *********          *      "));
        console.sendMessage(Theme.mainTheme(" *         *         *      "));
        console.sendMessage(Theme.mainTheme("*           *        *      "));
        console.sendMessage(Theme.mainTheme("----------------------------"));

        Bank.setup();
        Bank.bank.options().copyDefaults(true);
        Bank.save();

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        PriceManager.init(getConfig());

        getCommand("shop").setExecutor(new Shop());
        getCommand("balance").setExecutor(new Balance());

        getServer().getPluginManager().registerEvents(new ShopMain(),this);
        getServer().getPluginManager().registerEvents(new ShopBank(),this);

        console.sendMessage(Theme.mainTheme("Setting done."));
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(Theme.exitTheme("Saving bank data."));
        Bank.save();
        console.sendMessage(Theme.exitTheme("Bank data saved!"));

        console.sendMessage(Theme.exitTheme("----------------------------"));
        console.sendMessage(Theme.exitTheme("      *        *************"));
        console.sendMessage(Theme.exitTheme("     * *             *      "));
        console.sendMessage(Theme.exitTheme("    *   *            *      "));
        console.sendMessage(Theme.exitTheme("   *     *           *      "));
        console.sendMessage(Theme.exitTheme("  *********          *      "));
        console.sendMessage(Theme.exitTheme(" *         *         *      "));
        console.sendMessage(Theme.exitTheme("*           *        *      "));
        console.sendMessage(Theme.exitTheme("----------------------------"));
        console.sendMessage(Theme.exitTheme("Thank you for using."));
    }
}
