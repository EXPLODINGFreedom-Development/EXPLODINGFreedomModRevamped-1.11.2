package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Broadcasts the given message. Supports colors.", usage = "/<command> <message>", aliases = "action")
public class Command_me extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length > 0)
        {
            Player p = (Player) sender;
            TFM_Util.bcastMsg("§5* §r" + p.getDisplayName() + "§5 " + TFM_Util.colorize(StringUtils.join(args, " ")));
        }

        return true;
    }
}
