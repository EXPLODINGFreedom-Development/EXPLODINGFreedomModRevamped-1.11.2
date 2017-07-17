package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "This command shows you how to donate to the server.", usage = "/<command>")
public class Command_supporterinfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        playerMsg(ChatColor.AQUA + "Find our info about the Supporter Rank");
        playerMsg(ChatColor.BLUE + "Supporter ($5)");
        playerMsg(ChatColor.GREEN + "Commands:");
        playerMsg(ChatColor.YELLOW + "/donatorworld /donatorchat");
        playerMsg(ChatColor.GOLD + "Supporter Link: http://cjfreedom.community-piston.net/");
        playerMsg(ChatColor.RED + "Additional Perks");
        playerMsg(ChatColor.BLACK + "Custom Prefix(INCLUDED), Custom Title (INCLUDED)");
        return true;

    }
}