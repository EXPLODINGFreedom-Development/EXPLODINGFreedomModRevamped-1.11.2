package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_BuilderList;
import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_DonatorList;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "Donator Chat - Chat With other Donators",
        usage = "/<command> [message...]",
        aliases = "donatorchat")

public class Command_d extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        if (args.length == 0)
        {
            return false;
        }
        else
        {
            if (TFM_Util.isHighRank(sender) || EFMR_DonatorList.isSuperDonor(sender))
            {
                TFM_Util.donatorChatMessage(sender, StringUtils.join(args, " "), senderIsConsole);
                return true;
            }
            else
            {
                TFM_Util.playerMsg(sender, "You do not have permission to access Supporter Chat!", ChatColor.RED);
                return true;
            }
        }
    }
}