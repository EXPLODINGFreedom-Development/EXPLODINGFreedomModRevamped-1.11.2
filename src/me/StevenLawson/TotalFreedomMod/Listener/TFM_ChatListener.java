package me.StevenLawson.TotalFreedomMod.Listener;

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_Sync;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TFM_ChatListener
        implements Listener
{
    public static final List<String> FREESRV_HOST_DOMAINS = Arrays.asList(new String[]
    {
        "my-serv.com", "mymcserver.org", "serv.gs", "myserver.gs", "g-s.nu", "mcserv.me",
        "mcpro.io", "1337srv.com", "mcnetwork.me", "serv.nu", "mygs.co", "mchosting.pro",
        "server-minecraft.pro", "mcraft.pro", "mcserv.pro", "mchost.pro", "crafted.pro",
        "cubed.pro", "minecraft-crafting.pro", "aternos.me"
    });

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        final Player player = event.getPlayer();
        String message = event.getMessage();
        if (!TFM_AdminList.isSuperAdmin(player))
        {
            for (String domain : FREESRV_HOST_DOMAINS)
            {
                if (ChatColor.stripColor(message).toLowerCase().contains(domain))
                {
                    player.sendMessage(ChatColor.RED + "Ew, stop trying to advertise that server ran on a terrible host. Get real hosting ya cunt.");
                    event.setCancelled(true);
                    return;
                }
            }
        }
    }
}
