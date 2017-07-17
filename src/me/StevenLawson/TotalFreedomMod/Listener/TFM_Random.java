package me.StevenLawson.TotalFreedomMod.Listener;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import net.minecraft.server.v1_11_R1.AttributeInstance;
import net.minecraft.server.v1_11_R1.EntityInsentient;
import net.minecraft.server.v1_11_R1.GenericAttributes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class TFM_Random
{
  public static final List<ChatColor> COLOURS = Arrays.asList(new ChatColor[] { ChatColor.DARK_BLUE, ChatColor.DARK_GREEN, ChatColor.DARK_AQUA, ChatColor.DARK_RED, ChatColor.DARK_PURPLE, ChatColor.GOLD, ChatColor.BLUE, ChatColor.GREEN, ChatColor.AQUA, ChatColor.RED, ChatColor.LIGHT_PURPLE, ChatColor.YELLOW });
  public static Random random = new Random();
  
  public static Entity spawnMob(Player player, EntityType entity, int amount)
  {
    int times = 0;
    if (times < amount)
    {
      player.getWorld().spawnEntity(player.getLocation(), entity);
      times++;
    }
    else
    {
      return player.getWorld().spawnEntity(player.getLocation(), entity);
    }
    return null;
  }
  
  public static String aOrAn(String string)
  {
    if (string.toLowerCase().matches("^[aeiou].*")) {
      return "an";
    }
    return "a";
  }
  
  public static ChatColor randomChatColour()
  {
    return (ChatColor)COLOURS.get(random.nextInt(COLOURS.size()));
  }
  
  public static ChatColor randomChatColor()
  {
    return randomChatColour();
  }
  
  public static String colour(String string)
  {
    string = ChatColor.translateAlternateColorCodes('&', string);
    string = string.replaceAll("&-", randomChatColour().toString());
    return string;
  }
  
  public static ItemStack setArmourColour(ItemStack item, Color colour)
  {
    LeatherArmorMeta meta = null;
    try
    {
      meta = (LeatherArmorMeta)item.getItemMeta();
    }
    catch (Exception ex)
    {
      ItemStack fail = new ItemStack(Material.DEAD_BUSH, 1);
      ItemMeta failmeta = fail.getItemMeta();
      failmeta.setDisplayName(ChatColor.RED + "The item was not leather armour!");
      fail.setItemMeta(failmeta);
      TotalFreedomMod.plugin.getLogger().log(Level.SEVERE, "Failed to get LeatherArmorMeta from item: {0} are you sure this is Leather Armour?", item);
      return fail;
    }
    meta.setColor(colour);
    item.setItemMeta(meta);
    return item;
  }
  
  public static ItemStack setArmorColor(ItemStack item, Color colour)
  {
    return setArmourColour(item, colour);
  }
  
  public Object getPrivateField(Object object, String field)
    throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    Class<?> clazz = object.getClass();
    Field objectField = clazz.getDeclaredField(field);
    objectField.setAccessible(true);
    Object result = objectField.get(object);
    objectField.setAccessible(false);
    return result;
  }
 
  
  public static boolean deleteWorld(File path)
  {
    if (path.exists())
    {
      File[] files = path.listFiles();
      for (int i = 0; i < files.length; i++) {
        if (files[i].isDirectory()) {
          deleteWorld(files[i]);
        } else {
          files[i].delete();
        }
      }
    }
    return path.delete();
  }
  
  public static void unloadWorld(World world)
  {
    if (world != null)
    {
      for (Player player : world.getPlayers())
      {
        for (World newworld : Bukkit.getWorlds()) {
          if (world != newworld) {
            player.teleport(newworld.getSpawnLocation());
          }
        }
        player.kickPlayer("The world you are in is being unloaded.");
      }
      Bukkit.getServer().unloadWorld(world, false);
    }
  }
  
  public static boolean hasChatColours(String string)
  {
    string = colour(string);
    for (ChatColor colour : ChatColor.values()) {
      if (string.contains(colour.toString())) {
        return true;
      }
    }
    return false;
  }
}
