package com.ks.airtrade.constants;

import org.bukkit.ChatColor;

public class Theme {

    public static ChatColor main_color = ChatColor.LIGHT_PURPLE;
    public static ChatColor error_color = ChatColor.RED;

    public static String mainTheme(String s) {
        return main_color + s;
    }

    public static String errorTheme(String s) {
        return error_color + s;
    }

}
