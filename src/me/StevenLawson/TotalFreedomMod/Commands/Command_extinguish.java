package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Extinguish yourself.", usage = "/<command> <player>")
public class Command_extinguish extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /extinguish <playername>");
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
            sender.sendMessage(ChatColor.RED + args[0] + "§cis not online.");
        }
        else
        {
            target.setFireTicks(0);
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou extinguished §c" + target.getName() + "§b.");
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou were extinguished by §c" + sender.getName() + "§b.");
        }
        return true;
    }
}
