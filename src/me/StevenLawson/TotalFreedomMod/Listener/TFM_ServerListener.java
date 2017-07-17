package me.StevenLawson.TotalFreedomMod.Listener;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.Banning.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_ServerInterface;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class TFM_ServerListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onServerPing(ServerListPingEvent event)
    {
        final String ip = event.getAddress().getHostAddress();

        if (TFM_BanManager.isIpBanned(ip))
        {
            event.setMotd(ChatColor.RED + "You are banned.");
            return;
        }

        if (TFM_ConfigEntry.ADMIN_ONLY_MODE.getBoolean())
        {
            event.setMotd(ChatColor.RED + "Server is closed.");
            return;
        }

        if (Bukkit.hasWhitelist())
        {
            event.setMotd(ChatColor.RED + "Whitelist enabled.");
            return;
        }

        if (Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers())
        {
            event.setMotd(ChatColor.RED + "Server is full, please check back soon.");
            return;
        }

        // Colorful MOTD
        String message = String.format("§4§lEXPLODINGFreedom §7|§r §3Enhanced §3Creative §3Sandbox \n              §e§oRethink §e§oyour §e§oCreative §e§oMode.", TFM_Util.getPlayerFromIp(ip), TFM_ServerInterface.getVersion());

        final StringBuilder motd = new StringBuilder();

        for (String word : message.split(" "))
        {
            motd.append(TFM_Util.randomChatColor()).append(word).append(" ");
        }

        event.setMotd(TFM_Util.colorize(motd.toString()));
    }
}
