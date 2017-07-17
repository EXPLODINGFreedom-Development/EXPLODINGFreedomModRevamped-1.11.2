package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_EconomyManager;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.StringManager;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Get your balance.", aliases = "bal", usage = "/<command> <player>")
public class Command_balance extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {
            if (!StringManager.getServer.getOfflinePlayer(args[0]).hasPlayedBefore())
            {
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: Player is not online!");
                return true;
            }
            sender.sendMessage("§4§lEXPLODINGFreedom§e: §bPlayer " + args[0] + "§b's balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[0])) + "§b.");
            return true;
        }
        if (!(sender instanceof Player))
        {
            sender.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /balance <playername>");
            return true;
        }
        sender.sendMessage("§4§lEXPLODINGFreedom§e: §bYour balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(sender.getName())) + "§b.");
        return true;
    }
}
