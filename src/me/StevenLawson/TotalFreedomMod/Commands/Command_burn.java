package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Burn yourself.", usage = "/<command> <player> <seconds>")
public class Command_burn extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 2)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /burn <playername> <seconds>");
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cERROR: Player is not online.");
        }
        else
        {
            try
            {
                target.setFireTicks(Integer.parseInt(args[1]) * 20);
                 sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou burnt §c" + target.getName() + " §bfor§c " + args[1] + " §bseconds.");
                 target.sendMessage(ChatColor.RED + sender.getName() + " §bburnt you for §c" + args[1] + " §bseconds.");
            }
            catch (Exception e)
            {
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cYou must enter a valid number.");
            }
        }
        return true;
    }
}