package com.efdevelopment.EXPLODINGFreedomModRevamped.misc;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_EconomyManager;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.StringManager;
import java.io.File;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.World.TFM_AdminWorld;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EFMR_InteractListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent event)
    {
        if (event.getPlayer().getWorld().equals(TFM_AdminWorld.getInstance()))
        {
            if (!TFM_AdminList.isSuperAdmin(event.getPlayer()))
            {
                event.getPlayer().sendMessage(ChatColor.RED + "You can't place blocks in the adminworld!");
                event.isCancelled();
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event)
    {
        if (event.getPlayer().getWorld().equals(TFM_AdminWorld.getInstance()))
        {
            if (!TFM_AdminList.isSuperAdmin(event.getPlayer()))
            {
                event.getPlayer().sendMessage(ChatColor.RED + "You can't break blocks in the adminworld!");
                event.isCancelled();
            }
        }

    }
}
