package me.StevenLawson.TotalFreedomMod.Commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Validates if a given account is premium.", usage = "/<command> <player>", aliases = "prem")
public class Command_premium extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
   {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);
        final String name;

        if (player != null)
        {
            name = player.getName();
        }
        else
        {
            name = args[0];
        }

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                try
                {
                    final URL getUrl = new URL("http://axis.iaero.me/accstatus?username=" + name + "&format=plain");
                    final URLConnection urlConnection = getUrl.openConnection();
                    final String message;
                    try ( // Read the response
                            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())))
                    {
                        message = (!"PREMIUM".equalsIgnoreCase(in.readLine()) ? ChatColor.RED + "False" : ChatColor.DARK_GREEN + "True");
                    }

                    if (!plugin.isEnabled())
                    {
                        return;
                    }

                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            playerMsg("Player §6" + name + " §7is premium: " + message);
                        }
                    }.runTask(plugin);

                }
                catch (Exception ex)
                {
                    TFM_Log.severe(ex);
                    playerMsg("There was an error querying the mojang server.", ChatColor.RED);
                }
            }
        }.runTaskAsynchronously(plugin);

        return true;
    }
}