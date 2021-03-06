package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Changes god mode", usage = "/<command> [player]", aliases = "/egod")
public class Command_god extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            TFM_Util.setGod(sender_p, !TFM_Util.inGod(sender_p));
            sender_p.setHealth(20);
            sender_p.setFireTicks(0);
            sender_p.setFoodLevel(20);
            sender_p.setSaturation(20.0F);
            TFM_Util.playerMsg(sender_p, "God mode set to " + TFM_Util.inGod(sender_p));
        }
        if (args.length == 1 && TFM_AdminList.isSuperAdmin(sender))
        {
            Player player = null;
            player = getPlayer(args[0]);
            if (player == null)
            {
                TFM_Util.playerMsg(sender, TFM_Command.PLAYER_NOT_FOUND);
            }
            else
            {
                TFM_Util.setGod(player, !TFM_Util.inGod(player));
                player.setHealth(20);
                player.setFireTicks(0);
                player.setFoodLevel(20);
                player.setSaturation(20.0F);
                TFM_Util.playerMsg(player, "God mode of " + player.getName() + " set to " + TFM_Util.inGod(player));
            }
        }
        return true;
    }
}
