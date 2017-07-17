package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Open a player's inventory.", usage = "/<command> <player> <seconds>")
public class Command_invsee extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 2)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /invsee <playername>");
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
            sender.sendMessage(ChatColor.RED + args[0] + "§cis not online.");
        }
        else
        {
            sender_p.openInventory(target.getInventory());
        }
        return true;
    }
}
