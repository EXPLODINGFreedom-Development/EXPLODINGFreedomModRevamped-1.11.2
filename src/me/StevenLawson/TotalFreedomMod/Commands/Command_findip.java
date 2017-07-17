package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerList;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Shows all IPs registered to a player", usage = "/<command> <player>")
public class Command_findip extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {

            playerMsg(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        }

        playerMsg("Player IPs: " + StringUtils.join(TFM_PlayerList.getEntry(player).getIps(), ", "));

        return true;
    }
}
