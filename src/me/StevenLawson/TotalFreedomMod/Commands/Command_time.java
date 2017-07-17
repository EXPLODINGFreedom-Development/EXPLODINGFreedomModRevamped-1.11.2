package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Set the time in the world.", usage = "/<command> set|add <amount|day|night>")
public class Command_time extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if ((args.length == 1) || (args.length > 2))
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /time set|add <amount|day|night>");
            return false;
        }
        if (args.length == 0)
        {
            playerMsg("§6The current time in world §c" + p.getWorld() + "§6is §c" + p.getWorld().getTime() + "§6.", ChatColor.GOLD);
            return true;
        }
        if (args[0].equalsIgnoreCase("set"))
        {
            if (args[1].equalsIgnoreCase("day"))
            {
                p.getWorld().setTime(0L);
                playerMsg("§6You set time in world §c" + p.getWorld() + " §6to §c" + p.getWorld().getTime() + "§6 or day.", ChatColor.GOLD);
            }
            else if (args[1].equalsIgnoreCase("night"))
            {
                p.getWorld().setTime(13000L);
                playerMsg("§6You set time in world §c" + p.getWorld() + " §6to §c" + p.getWorld().getTime() + "§6 or night.", ChatColor.GOLD);
            }
            else
            {
                try
                {
                    long time = Integer.parseInt(args[1]);
                    p.getWorld().setTime(time);
                    playerMsg("§6You set time in world §c" + p.getWorld() + "§6to §c" + time + "§6.", ChatColor.GOLD);
                }
                catch (Exception e)
                {
                    p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: You must use numbers instead of words or letters.");
                }
            }
        }
        else if (args[0].equalsIgnoreCase("add"))
        {
            try
            {
                long time = Integer.parseInt(args[1]);
                long newTime = p.getWorld().getTime() + time;
                p.getWorld().setTime(newTime);
                playerMsg("§6You set time in world §c" + p.getWorld() + "§6to §c" + newTime + "§6.", ChatColor.GOLD);
                
            }
            catch (Exception e)
            {
                p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: You must use numbers instead of words or letters.");
            }
        }
        else
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /time set|add <amount|day|night>");
        }
        return true;
    }

}