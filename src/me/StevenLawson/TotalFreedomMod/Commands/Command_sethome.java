package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_API;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_HomesAPI;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_Lists;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Set your home", usage = "/<command> <home>")
public class Command_sethome extends TFM_Command
{
    private EXPLODINGFreedomMod plugin;

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
        {
        File file = new File("plugins/EXPLODINGFreedomModRevamped/Data", sender.getName() + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            Player p = (Player) sender;
                if (args.length == 1)
                {
                    String world = p.getWorld().getName();
                    double x = p.getLocation().getX();
                    double y = p.getLocation().getY();
                    double z = p.getLocation().getZ();
                    double yaw = p.getLocation().getYaw();
                    double pitch = p.getLocation().getPitch();

                    cfg.set(args[0] + ".world", world);
                    cfg.set(args[0] + ".x", Double.valueOf(x));
                    cfg.set(args[0] + ".y", Double.valueOf(y));
                    cfg.set(args[0] + ".z", Double.valueOf(z));
                    cfg.set(args[0] + ".yaw", Double.valueOf(yaw));
                    cfg.set(args[0] + ".pitch", Double.valueOf(pitch));
            try
            {
                cfg.save(file);
            }
            catch (IOException ex)
            {
                Logger.getLogger(Command_setwarp.class.getName()).log(Level.SEVERE, null, ex);
            }
                    p.sendMessage("§4§lEXPLODINGFreedom§e: §bHome §c" + args[0] + " §bset.");
                }
                else
                {
                    p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /sethome <homename>");
                }
                return true;
            }
}

