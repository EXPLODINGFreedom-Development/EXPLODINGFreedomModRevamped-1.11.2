package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.Rank.TFM_PlayerRank;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Message online admins", usage = "/<command> <message>", aliases = "helpop")
public class Command_alertadmin extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            return false;
        }
        String name = sender.getName() + " " + TFM_PlayerRank.fromSender(sender).getPrefix() + ChatColor.WHITE;
         String message = StringUtils.join(args, " ");
        if (args.length == 1)
        {
            final TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(sender_p);
            TFM_Util.bcastMsg("§e[" + ChatColor.YELLOW + "NOTICE" + ChatColor.YELLOW + "§e] " + ChatColor.DARK_GRAY+ name + ": " + ChatColor.YELLOW + message);
        }
        return true;
    }
}