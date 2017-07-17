package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Make yourself an imposter.", usage = "/<command>")
public class Command_addbuilder extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p  = (Player) sender;
        Player targetPlayer = p.getServer().getPlayer(args[0]);
        if(TFM_Util.architects.contains(targetPlayer.getName()))
        {   
            TFM_Util.architects.remove(targetPlayer.getName());
            sender_p.sendMessage("Successfully removed from builder list.");
        }
        else
        {
            TFM_Util.architects.add(targetPlayer.getName());
            sender_p.sendMessage("Sucessfully added to the builder list.");
        }
        return true;
    }
    
}