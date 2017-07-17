package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Kill others.", usage = "/<command> <player>")
public class Command_kill extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length != 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /kill <player>");
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cERROR: Player is not online.");
        }
        else
        {
            target.setHealth(0);
            if (target == p)
            {
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou are dead!");
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §c " + target.getDisplayName() + "§b has killed you.");
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou have killed §b" + target.getDisplayName() + "§b.");
            }
        }
        return true;
    }

}
