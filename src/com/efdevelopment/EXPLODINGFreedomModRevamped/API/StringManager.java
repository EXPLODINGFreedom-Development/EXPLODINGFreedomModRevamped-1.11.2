package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class StringManager
{
  public static ChatColor Gray = ChatColor.GRAY;
  public static ChatColor Blue = ChatColor.BLUE;
  public static ChatColor Red = ChatColor.RED;
  public static ChatColor Yellow = ChatColor.YELLOW;
  public static ChatColor Reset = ChatColor.RESET;
  public static String Name = "Alco's Economy";
  public static String PluginName = "EXPLODINGFreedomModRevamped";
  public static Server getServer = Bukkit.getServer();
  public static Plugin getPlugin = getServer.getPluginManager().getPlugin(PluginName);
  public static Integer GetConfig = TFM_ConfigEntry.FIRSTJOINAMOUNT.getInteger();
  public static final String NoPermMessage = Yellow + "You do not have permission to use this command.";
  public static final String InGameOnly = "This command can only be ran in-game";
  
  public static void CInfo(String message)
  {
    Bukkit.getLogger().log(Level.INFO, message);
  }
  
  public static void CWarning(String message)
  {
    Bukkit.getLogger().log(Level.WARNING, message);
  }
  
  public static void CSevere(String message)
  {
    Bukkit.getLogger().log(Level.SEVERE, message);
  }
  
  public static void COff(String message)
  {
    Bukkit.getLogger().log(Level.OFF, message);
  }
  
  public static void CFinest(String message)
  {
    Bukkit.getLogger().log(Level.FINEST, message);
  }
  
  public static void CFine(String message)
  {
    Bukkit.getLogger().log(Level.FINE, message);
  }
  
  public static void CConfig(String message)
  {
    Bukkit.getLogger().log(Level.CONFIG, message);
  }
  
  public static void CAll(String message)
  {
    Bukkit.getLogger().log(Level.ALL, message);
  }
}
