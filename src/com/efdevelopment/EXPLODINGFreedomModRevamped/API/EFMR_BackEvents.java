package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class EFMR_BackEvents
        implements Listener
{
    public TotalFreedomMod plugin;

    public EFMR_BackEvents(TotalFreedomMod instance)
    {
        this.plugin = instance;
    }
    File file = new File("plugins/EXPLODINGFreedomModRevamped/LastLocation", "PlayerData.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) throws IOException
    {
        Boolean CauseOkay = Boolean.valueOf(false);
        if (this.plugin.getConfig().getStringList("causes").contains("ALL"))
        {
            CauseOkay = Boolean.valueOf(true);
        }
        else
        {
            for (String Cause : this.plugin.getConfig().getStringList("causes"))
            {
                if (e.getCause().toString() == Cause)
                {
                    CauseOkay = Boolean.valueOf(true);
                }
            }
        }
        if (CauseOkay.booleanValue())
        {
            String playerUUID = e.getPlayer().getUniqueId().toString();
            String world = e.getFrom().getWorld().getName();
            double X = e.getFrom().getX();
            double Y = e.getFrom().getY();
            double Z = e.getFrom().getZ();

            cfg.set("players." + playerUUID + "." + world + ".X", Double.valueOf(X));
            cfg.set("players." + playerUUID + "." + world + ".Y", Double.valueOf(Y));
            cfg.set("players." + playerUUID + "." + world + ".Z", Double.valueOf(Z));
            cfg.save(file);
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) throws IOException
    {
        if (e.getEntity().hasPermission(""))
        {
            String playerUUID = e.getEntity().getUniqueId().toString();
            String world = e.getEntity().getWorld().getName();
            double X = e.getEntity().getLocation().getX();
            double Y = e.getEntity().getLocation().getY();
            double Z = e.getEntity().getLocation().getZ();

            cfg.set("players." + playerUUID + "." + world + ".X", Double.valueOf(X));
            cfg.set("players." + playerUUID + "." + world + ".Y", Double.valueOf(Y));
            cfg.set("players." + playerUUID + "." + world + ".Z", Double.valueOf(Z));
            cfg.save(file);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onWorldChange(PlayerChangedWorldEvent e)
    {
        String playerUUID = e.getPlayer().getUniqueId().toString();
        String world = e.getPlayer().getWorld().getName();
        double X = cfg.getInt("players." + playerUUID + "." + world + ".X");
        double Y = cfg.getInt("players." + playerUUID + "." + world + ".Y");
        double Z = cfg.getInt("players." + playerUUID + "." + world + ".Z");
        Location location = new Location(Bukkit.getWorld(world), X, Y, Z);
        e.getPlayer().teleport(location);
    }
}
