package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Privately message a player..", usage = "/<command>", aliases = "message")
public class Command_msg extends TFM_Command
{
    public static HashMap<String, String> reply = new HashMap();
    public static HashMap<String, String> sender = new HashMap();

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length < 2)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /msg <player> <message>");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++)
        {
            sb.append(args[i]).append(" ");
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        String msg = sb.toString();
        if (target == null)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cError: Player is not online!");
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "§6[§c" + p.getDisplayName() + " §b-> §c" + target.getDisplayName() + "§6] " + ChatColor.WHITE + msg);

            target.sendMessage(ChatColor.RED + "§6[§c" + p.getDisplayName() + " §b-> §c" + target.getDisplayName() + "§6] " + ChatColor.WHITE + msg);

            reply.remove(target.getName());
            reply.remove(sender.getName());
            reply.put(target.getName(), sender.getName());
            reply.put(sender.getName(), target.getName());

            for (Player op : Bukkit.getOnlinePlayers())
            {

                if (Command_socialspy.spying.containsKey(op.getName()))
                {
                    sender.sendMessage(ChatColor.RED + "§8[§9SOCIALSPY§8] §e| §6[§c" + sender.getName() + " §b-> §c" + target.getName() + "§6] " + ChatColor.WHITE + msg);
                }
            }
        }
        return true;
    }
}
