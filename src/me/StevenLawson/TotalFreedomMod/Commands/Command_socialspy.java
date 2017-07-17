package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Spy on people's private messages.", usage = "/<command>")
public class Command_socialspy extends TFM_Command
{
    public static HashMap<String, Boolean> spying = new HashMap();

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length > 0)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /socialspy <player>");
            return false;
        }
        if (!spying.containsKey(p.getName()))
        {
            spying.put(p.getName(), Boolean.valueOf(true));
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou are now seeing other people's private messages.");
        }
        else
        {
            spying.remove(p.getName());
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou are no longer seeing other people's private messages.");
        }
        return true;
    }
}
