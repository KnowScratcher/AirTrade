package com.ks.airtrade;

import com.ks.airtrade.constants.LogMessage;
import com.ks.airtrade.constants.Theme;
import com.ks.airtrade.file.Bank;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.font.TextHitInfo;

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

        console.sendMessage(Theme.mainTheme("Setting done."));
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(Theme.mainTheme("Saving bank data."));
        Bank.save();
        console.sendMessage(Theme.mainTheme("Bank data saved!"));

        console.sendMessage(Theme.mainTheme("----------------------------"));
        console.sendMessage(Theme.mainTheme("      *        *************"));
        console.sendMessage(Theme.mainTheme("     * *             *      "));
        console.sendMessage(Theme.mainTheme("    *   *            *      "));
        console.sendMessage(Theme.mainTheme("   *     *           *      "));
        console.sendMessage(Theme.mainTheme("  *********          *      "));
        console.sendMessage(Theme.mainTheme(" *         *         *      "));
        console.sendMessage(Theme.mainTheme("*           *        *      "));
        console.sendMessage(Theme.mainTheme("----------------------------"));
        console.sendMessage(Theme.mainTheme("Thank you for using."));
    }
}
