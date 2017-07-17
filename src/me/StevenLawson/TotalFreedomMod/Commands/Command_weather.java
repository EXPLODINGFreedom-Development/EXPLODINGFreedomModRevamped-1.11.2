package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Set the weather in the world.", usage = "/<command> <clear|rain|storm>")
public class Command_weather extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player)sender;
        if (args.length != 1)
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /weather <clear|rain|storm>");
            return false;
        }
        if (args[0].equalsIgnoreCase("storm"))
        {
            p.getWorld().setStorm(true);
            playerMsg("§6You set the weather to §cstorm §6in world §c" + p.getWorld(), ChatColor.GOLD);
        }
        else if (args[0].equalsIgnoreCase("rain"))
        {
            p.getWorld().setThundering(true);
            playerMsg("§6You set the weather to §crain §6in world §c" + p.getWorld(), ChatColor.GOLD);
        }
        else if (args[0].equalsIgnoreCase("clear"))
        {
            p.getWorld().setStorm(false);
            p.getWorld().setThundering(false);
            playerMsg("§6You set the weather to §cclear §6in world §c" + p.getWorld(), ChatColor.GOLD);
        }
        return true;
    }
}