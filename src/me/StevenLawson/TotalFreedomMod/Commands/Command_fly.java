package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Shoot a fireball.", usage = "/<command> <player>")
public class Command_fly extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length > 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cUsage: /fly <player>");
        }
        if (args.length == 0)
        {
            if (p.getAllowFlight())
            {
                p.setAllowFlight(false);
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou disabled your flight.");
            }
            else
            {
                p.setAllowFlight(true);
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou enabled your flight.");
            }
            return true;
        }
        if ((p.isOp())
                && (args.length == 1))
        {
            Player target = getPlayer(args[0]);
            if (target == null)
            {
                sender.sendMessage(ChatColor.RED + args[0] + " §cis not online.");
            }
            else if (target.getAllowFlight())
            {
                target.setAllowFlight(false);
                if (target == p)
                {
                    sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou disabled your flight.");
                }
                else
                {
                    sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §c" + target.getName() + "§bdisabled your flight.`");
                    sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou enabled §c" + target.getName() + "§b's flight.");
                }
            }
            else
            {
                target.setAllowFlight(true);
                if (target == p)
                {
                    sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou enabled your flight.");
                }
                else
                {
                    sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §c" + target.getName() + "§bdisabled your flight.`");
                    sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou enabled §c" + target.getName() + "§b's flight.");
                }
                return true;
            }
        }
        return true;
    }
}
