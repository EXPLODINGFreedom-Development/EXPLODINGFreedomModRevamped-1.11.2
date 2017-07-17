package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Set walking or flight speed.", usage = "/<command> <1-20>]")
public class Command_speed extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length != 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /speed <1-20>");
            return false;
        }
        String amount = args[0];
        try
        {
            int i = Integer.parseInt(amount);
            if ((i > 20) || (i < -20))
            {
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /speed <1-20>");
            }
            else if (p.isFlying())
            {
                p.setFlySpeed(i / 20.0F);
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou set your flight speed to §c" + i);
            }
            else
            {
                p.setWalkSpeed(i / 20.0F);
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou set your waking speed to §c" + i);
            }
        }
        catch (Exception e)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cYou must enter a valid number 1-20.");
        }
        return true;
    }
}
