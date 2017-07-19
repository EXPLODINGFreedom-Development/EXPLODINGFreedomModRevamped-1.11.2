package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_API;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_HomesAPI;
import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Go to your set home", usage = "/<command> <home>")
public class Command_home extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        File file = new File("plugins/EXPLODINGFreedomModRevamped/Data", sender.getName() + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Player p = (Player) sender;
        if (p.isOp())
        {
            if (args.length == 1)
            {
                if (cfg.getString(args[0]) != null)
                {
                    String world = cfg.getString(args[0] + ".world");
                    double x = cfg.getDouble(args[0] + ".x");
                    double y = cfg.getDouble(args[0] + ".y");
                    double z = cfg.getDouble(args[0] + ".z");
                    double yaw = cfg.getDouble(args[0] + ".yaw");
                    double pitch = cfg.getDouble(args[0] + ".pitch");

                    Location loc = new Location(Bukkit.getWorld(world), x, y, z);
                    loc.setPitch((float) pitch);
                    loc.setYaw((float) yaw);
                    EXPLODINGFreedomMod.back.put(p.getName(), loc);
                    p.teleport(loc, PlayerTeleportEvent.TeleportCause.COMMAND);
                    p.sendMessage("§4§lEXPLODINGFreedom§e: §bTeleporting to player-home §c" + args[0] + "§b.");
                }
                else
                {
                    p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: Home " + args[0] + " does not exist! Please enter a valid home name.");
                }
            }
            else
            {
                p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /home <name>");
                int i = 0;
                p.sendMessage("§4§lEXPLODINGFreedom§e: §bYour Homes:");
                for (String key : cfg.getKeys(true))
                {
                    if (!key.contains("."))
                    {
                        i++;
                        p.sendMessage("§7" + i + ". §6'" + key + "'");
                    }
                }
                i = 0;
            }
        }
        else
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: No permissions! You must be OP+ to use this command.");
        }
        return true;
    }
}
