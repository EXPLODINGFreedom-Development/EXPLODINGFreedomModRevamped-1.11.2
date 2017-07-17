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

public class TFM_ColoredChatListener
        implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerChatFormat(AsyncPlayerChatEvent event)
    {
        try
        {
            handleChatEvent(event);
        }
        catch (Exception ex)
        {
            TFM_Log.severe(ex);
        }
    }

    private void handleChatEvent(AsyncPlayerChatEvent event)
    {
        final Player player = event.getPlayer();
        String message = event.getMessage();

        if (player.isOp())
        {
            // Strip color from messages
            message = TFM_Util.colorize(message);
        }
        else
        {
            // Format color
            message = ChatColor.stripColor(message);
        }

        // OPs can use formatting :^)
        if (!player.isOp())
        {
            message = message.replaceAll(ChatColor.BOLD.toString(), "&l");
            message = message.replaceAll(ChatColor.MAGIC.toString(), "&k");
            message = message.replaceAll(ChatColor.ITALIC.toString(), "&o");
            message = message.replaceAll(ChatColor.UNDERLINE.toString(), "&n");
            message = message.replaceAll(ChatColor.STRIKETHROUGH.toString(), "&m");
        }
    }
}
