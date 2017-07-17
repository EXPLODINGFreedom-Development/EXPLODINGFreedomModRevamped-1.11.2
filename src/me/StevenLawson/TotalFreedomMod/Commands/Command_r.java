package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Reply to a player's private message.", usage = "/<command>", aliases = "reply")
public class Command_r extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        HumanEntity player = p;
        if (args.length < 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /r <message>");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
        {
            sb.append(args[i]).append(" ");
        }
        String msg = sb.toString();
        if (Command_msg.reply.containsKey(sender.getName()))
        {
            Player target = Bukkit.getServer().getPlayer((String) Command_msg.reply.get(sender.getName()));
            if (target == null)
            {
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cERROR: Player is not online.");
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "§6[§c" + p.getDisplayName() + " §b-> §c" + target.getDisplayName() + "§6] " + ChatColor.WHITE + msg);

            }
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cERROR: You have nobody to reply to.");
        }
        return true;
    }
}
