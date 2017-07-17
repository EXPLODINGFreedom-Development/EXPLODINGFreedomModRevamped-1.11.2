package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_API;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_WarpAPI;
import java.io.File;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Delete a warp", usage = "/<command> <warpname>")
public class Command_delwarp extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (p.isOp())
        {
            if (args.length == 1)
            {
                File file = new File("plugins/EXPLODINGFreedomModRevamped/Data", "warps.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                if (cfg.getString(args[0]) != null)
                {
                    cfg.set(args[0], null);
                    p.sendMessage("§4§lEXPLODINGFreedom§e: §bWarp §c" + args[0] + "%s §bhas been deleted.");
                    try
                    {
                        cfg.save(file);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: Warp " + args[0] + "does not exist! Please enter a valid warp name.");
                }
            }
            else
            {
                p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /delwarp <warpname>");
            }
        }
        else
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: No permissions! You must be OP+ to use this command.");
        }
        return true;
    }
}
