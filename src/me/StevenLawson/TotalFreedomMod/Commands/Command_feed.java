package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Feed yourself.", aliases = "admininfo", usage = "/<command> <player>")
public class Command_feed extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length > 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /feed <playername>");
            return false;
        }
        if (args.length == 0)
        {
            p.setFoodLevel(20);
            p.setSaturation(20.0F);
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou have satiated the appetite of §c" + p.getDisplayName() + "§b");
            return true;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cERROR: Player is not online.");
        }
        else
        {
            target.setFoodLevel(20);
            target.setSaturation(20.0F);
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou have been satiated.");
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou have satiated the appetite of §c" + target.getDisplayName() + "§b");
        }
        return true;
    }
}
