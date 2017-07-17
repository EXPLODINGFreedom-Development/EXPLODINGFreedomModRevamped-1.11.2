package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Open a personal workbench.", usage = "/<command>", aliases = "craft,wb")
public class Command_workbench extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        HumanEntity player = p;
        if (args.length != 0)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /workbench");
            return false;
        }
        player.openWorkbench(p.getLocation(), true);
        return true;
    }
}
