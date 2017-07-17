package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(
        description = "Owner AdminChat - Chat for discussions among Owners",
        usage = "/<command> [message...]",
        aliases = "ochat,oc")
public class Command_ownerchat extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!(TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName())) && !TFM_Util.SYS_COOWNERS.contains(sender.getName()))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
    

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not an Owner and may NOT use this command. If you feel this in error please contact a Developer.");
            }

            return true;
        }

            if (args.length == 0)
        {
            if (senderIsConsole)
            {
                playerMsg("Only in-game players can toggle OwnerChat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);
            userinfo.setOwnerChat(!userinfo.inOwnerchat());
            playerMsg("Toggled Owner Chat " + (userinfo.inOwnerchat() ? "on" : "off") + ".");
        }
        else
        {
            TFM_Util.OwnerChatMessage(sender, org.apache.commons.lang3.StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}