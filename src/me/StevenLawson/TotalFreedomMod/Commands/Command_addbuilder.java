package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.Player.TFM_Scoreboard;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
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
        Player p = (Player) sender;
        Player targetPlayer = p.getServer().getPlayer(args[0]);
        if (!TFM_Util.BUILDERS.contains(targetPlayer.getName()))
        {
            TFM_Util.BUILDERS.add(targetPlayer.getName());
            sender_p.sendMessage("§7Successfully added " + targetPlayer.getDisplayName() + " §7to the builder list.");
            TFM_Scoreboard.updateStats(targetPlayer);
        }

        else
        {
            TFM_Util.BUILDERS.remove(targetPlayer.getName());
            sender_p.sendMessage("§7Sucessfully removed " + targetPlayer.getDisplayName() + " §7from the builder list.");
            TFM_Scoreboard.updateStats(targetPlayer);
        }

        return true;
    }

}
