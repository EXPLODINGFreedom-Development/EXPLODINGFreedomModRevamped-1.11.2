package com.efdevelopment.EXPLODINGFreedomModRevamped.misc;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_EconomyManager;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.StringManager;
import java.io.File;
import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditBridge;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EFMR_JoinListener implements Listener
{

    @EventHandler
    public void join(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.BLUE + "§8[§9+§8] §9" + p.getName());
    }

    @EventHandler
    public void motd(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GOLD + "§7§l-=-§4§k§liii§7§l-=-§e§lWelcome,§b " + p.getDisplayName() + " §e§lto EXPLODINGFreedom!§7§l-=-§4§k§liii§7§l-=-");
        p.sendMessage(ChatColor.GOLD + "§2§lThe Founder and §4§lOwner §2§lis §1§lAlco_Rs11!");
        p.sendMessage(ChatColor.GOLD + "§2§lThe Co-Founders are §6§lJayscoob and §e§lKM_Galahad");
        p.sendMessage(ChatColor.GOLD + "§2§lRemember to read the rules in /rules and listen to staff or admins!");
        p.sendMessage(ChatColor.GOLD + "§1§lHave fun at EXPLODINGFreedom All-Op!");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void newPlayer(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore())
        {
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "§1§l>§4§l-§1§l>§b§lWelcome §c" + p.getName() + " §d to §4EXPLODINGFreedom§b§l!§1§l<§4§l-§1§l<");
            TFM_WorldEditBridge.setLimit(p, 2500);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        if (!EFMR_EconomyManager.Isinfile(player.getName()))
        {
            StringManager.CInfo(player.getName() + " is not already in the config, adding " + TFM_ConfigEntry.FIRSTJOINAMOUNT.getInteger() + " to their balance");
            EFMR_EconomyManager.New(player.getName());
        }
    }

    @EventHandler
    public void onPlayerJoin2(PlayerJoinEvent e)
    {
        File file = new File("plugins/EXPLODINGFreedomModRevamped/Data", "nicknames.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Player player = e.getPlayer();
        player.setDisplayName(cfg.getString(player.getName()));
    }

    @EventHandler
    public void leave(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.BLUE + "§8[§9-§8] §9" + p.getName());

    }

}
