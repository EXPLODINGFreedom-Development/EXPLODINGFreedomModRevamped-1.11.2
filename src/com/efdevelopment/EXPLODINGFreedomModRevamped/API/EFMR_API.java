package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EFMR_API
{
  public static String color(String s)
  {
    return ChatColor.translateAlternateColorCodes('&', s);
  }
  
  public static String stripColor(String s)
  {
    return ChatColor.stripColor(s);
  }
  
  public static String removeAltColorCodes(char altColorChar, String textToTranslate)
  {
    char[] b = textToTranslate.toCharArray();
    for (int i = 0; i < b.length - 1; i++) {
      if ((b[i] == altColorChar) && ("0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[(i + 1)]) > -1))
      {
        b[i] = '§';
        b[(i + 1)] = Character.toLowerCase(b[(i + 1)]);
      }
    }
    return new String(b);
  }
  
  public static Player getPlayer(JavaPlugin plugin, CommandSender sender, String player)
  {
    Player p = plugin.getServer().getPlayerExact(player);
    if (p != null) {
      return p;
    }
    sender.sendMessage(color("&c&lOops! &7that player is currently offline."));
    return null;
  }
  
  public static boolean hasPermission(CommandSender sender, String permission)
  {
    if (!sender.hasPermission(permission))
    {
      sender.sendMessage(color("&c&lHey! &7you don't have permissions to do that."));
      return false;
    }
    return true;
  }
  
  public static String getSenderDisplayName(JavaPlugin plugin, CommandSender sender)
  {
    return !(sender instanceof Player) ? sender.getName() : getPlayer(plugin, sender, sender.getName()).getDisplayName();
  }
}
