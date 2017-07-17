package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_HomesAPI;
import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "View your homes.", usage = "/<command>")
public class Command_homes extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (p.isOp())
        {
            if (args.length == 0)
            {
                File file = new File("plugins/EXPLODINGFreedomModRevamped/Data", sender + ".yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
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
            else
            {
                p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /home");
            }
        }
        else
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: No permissions! You must be OP+ to use this command.");
        }
        return true;
    }
}
