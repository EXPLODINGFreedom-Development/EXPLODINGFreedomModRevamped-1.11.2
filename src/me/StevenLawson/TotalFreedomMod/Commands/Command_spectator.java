package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Vanilla Freecam-Goodness!", usage = "/<command> [partialname]", aliases = "gmsp")
public class Command_spectator extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (senderIsConsole)
        {
            if (args.length == 0)
            {
                sender.sendMessage("When used from the console, you must define a target user to change gamemode on.");
                return true;
            }
        }

        Player player;
        if (args.length == 0)
        {
            player = sender_p;
        }
        else
        {
            if (args[0].equalsIgnoreCase("-a"))
            {
                if (!TFM_AdminList.isSuperAdmin(sender))
                {
                    sender.sendMessage(TFM_Command.MSG_NO_PERMS);
                    return true;
                }

                for (Player targetPlayer : server.getOnlinePlayers())
                {
                    targetPlayer.setGameMode(GameMode.SPECTATOR);
                }

                TFM_Util.adminAction(sender.getName(), "Changing everyone's gamemode to spectator", false);
                return true;
            }

            if (!(senderIsConsole || TFM_AdminList.isSuperAdmin(sender)))
            {
                playerMsg("Only superadmins can change other user's gamemode.");
                return true;
            }

            player = getPlayer(args[0]);

            if (player == null)
            {
                sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
                return true;
            }

        }

        playerMsg("Setting " + player.getName() + " to game mode '§aSpectator§8'.");
        playerMsg(player, sender.getName() + " set your game mode to '§aSpectator§7'.");
        player.setGameMode(GameMode.SPECTATOR);

        return true;
    }
}
