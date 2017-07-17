package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Go to your last death point.", usage = "/<command>")
public class Command_back extends TFM_Command
{
    Map<UUID, Location> backMap = new HashMap();

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length >= 1)
        {
            sender.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /back");
        }
        else if (EXPLODINGFreedomMod.back.containsKey(sender.getName()))
        {
            Player p = (Player) sender;
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bTeleporting...");
            p.teleport(EXPLODINGFreedomMod.back.get(p.getName()));
            p.teleport((Location)EXPLODINGFreedomMod.back.get(p.getName()));
            
        }
        return true;
    }
}
