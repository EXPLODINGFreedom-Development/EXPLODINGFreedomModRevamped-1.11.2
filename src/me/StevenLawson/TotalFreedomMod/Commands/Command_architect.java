package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_Builder;
import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_BuilderList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Manage Architects.", usage = "/<command> <list | <add|delete|info> <username>>")
public class Command_architect extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0 || args.length > 2)
        {
            return false;
        }

        if (args.length == 1)
        {
            if (args[0].equals("list"))
            {
                playerMsg("Builders: " + StringUtils.join(EFMR_BuilderList.getBuilderNames(), ", "), ChatColor.GOLD);
                return true;
            }

            return false;
        }

        if (args[0].equalsIgnoreCase("info"))
        {
            if (!EFMR_BuilderList.isSuperBuilder(sender))
            {
                playerMsg(TotalFreedomMod.MSG_NO_PERMS);
                return true;
            }

            EFMR_Builder builder = EFMR_BuilderList.getEntry(args[1].toLowerCase());

            if (builder == null)
            {
                try
                {
                    builder = EFMR_BuilderList.getEntry(getPlayer(args[1]).getName().toLowerCase());
                }
                catch (Exception ex)
                {
                }
            }

            if (builder == null)
            {
                playerMsg("Superadmin not found: " + args[1]);
            }
            else
            {
                playerMsg(builder.toString());
            }

            return true;
        }

        if (!senderIsConsole)
        {
            playerMsg("This command may only be used from the console.");
            return true;
        }

        if (args[0].equalsIgnoreCase("add"))
        {
            OfflinePlayer player;

            try
            {
                player = getPlayer(args[1]);
            }
            catch (Exception ex)
            {
                final EFMR_Builder builder = EFMR_BuilderList.getEntry(args[1]);

                if (builder == null)
                {
                    playerMsg(ex.getMessage(), ChatColor.RED);
                    return true;
                }

                player = Bukkit.getOfflinePlayer(builder.getLastLoginName());
            }

            TFM_Util.adminAction(sender.getName(), "Adding " + player.getName() + " to the builder list", true);
            EFMR_BuilderList.addSuperadmin(player);

            return true;
        }

        if ("remove".equals(args[0]))
        {
            if (!TFM_Util.OWNERS.contains(sender.getName()))
            {
                playerMsg(TotalFreedomMod.MSG_NO_PERMS);
                return true;
            }

            String targetName = args[1];

            try
            {
                targetName = getPlayer(targetName).getName();
            }
            catch (Exception ex)
            {
            }

            if (!EFMR_BuilderList.getLowerSuperNames().contains(targetName.toLowerCase()))
            {
                playerMsg("Builder not found: " + targetName);
                return true;
            }

            TFM_Util.adminAction(sender.getName(), "Removing " + targetName + " from the Builder list", true);
            EFMR_BuilderList.removeSuperadmin(Bukkit.getOfflinePlayer(targetName));

            return true;
        }
        return false;

    }
}
