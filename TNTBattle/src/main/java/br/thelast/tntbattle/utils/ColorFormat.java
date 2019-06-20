package br.thelast.tntbattle.utils;

import org.bukkit.ChatColor;

public class ColorFormat {
	public static String formater(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
