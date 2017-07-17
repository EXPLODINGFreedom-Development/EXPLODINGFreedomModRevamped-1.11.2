package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.ArrayList;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.Rank.TFM_PlayerRank;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Lists the real names of all online players.", usage = "/<command> [-a | -e | -i]", aliases = "who")
public class Command_list extends TFM_Command
{
    private static enum ListFilter
    {
        ALL,
        ADMINS,
        EXECUTIVES,
        IMPOSTORS;
    }

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length > 1)
        {
            return false;
        }

        if (TFM_Util.isFromHostConsole(sender.getName()))
        {
            final List<String> names = new ArrayList<String>();
            for (Player player : server.getOnlinePlayers())
            {
                names.add(player.getName());
            }
            playerMsg("There are " + names.size() + "/" + server.getMaxPlayers() + " players online:\n" + StringUtils.join(names, ", "), ChatColor.WHITE);
            return true;
        }

        final ListFilter listFilter;
        if (args.length == 1)
        {
            if ("-a".equals(args[0]))
            {
                listFilter = ListFilter.ADMINS;
            }
            else if ("-e".equals(args[0]))
            {
                listFilter = ListFilter.EXECUTIVES;
            }
            else if ("-i".equals(args[0]))
            {
                listFilter = ListFilter.IMPOSTORS;
            }
            else
            {
                return false;
            }
        }
        else
        {
            listFilter = ListFilter.ALL;
        }

        final StringBuilder onlineStats = new StringBuilder();
        final StringBuilder onlineUsers = new StringBuilder();

        onlineStats.append(ChatColor.GRAY).append("There are ").append(ChatColor.DARK_AQUA).append(server.getOnlinePlayers().size());
        onlineStats.append(ChatColor.GRAY).append(" out of a maximum ").append(ChatColor.DARK_AQUA).append(server.getMaxPlayers());
        onlineStats.append(ChatColor.GRAY).append(" players online.");

        final List<String> names = new ArrayList<String>();
        for (Player player : server.getOnlinePlayers())
        {
            if (listFilter == ListFilter.ADMINS && !TFM_AdminList.isSuperAdmin(player))
            {
                continue;
            }
            if (listFilter == ListFilter.EXECUTIVES && !TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()) && !TFM_Util.SYS_COOWNERS.contains(sender.getName()) && !TFM_Util.LEADSYSS.contains(sender.getName()) && !TFM_Util.SYS_ADMINS.contains(sender.getName()) && !TFM_Util.SPECIAL_EXECS.contains(sender.getName()) && !TFM_Util.EXECS.contains(sender.getName()))
            {
                continue;
            }
            if (listFilter == ListFilter.IMPOSTORS && !TFM_AdminList.isAdminImpostor(player))
            {
                continue;
            }

            names.add(TFM_PlayerRank.fromSender(player).getPrefix() + player.getName());
        }

        onlineUsers.append("§3Connected Players: ");
        onlineUsers.append(listFilter == Command_list.ListFilter.ADMINS ? "§6Admins:§r " : "");
        onlineUsers.append(listFilter == Command_list.ListFilter.EXECUTIVES ? "§9Executive Admins:§r " : "");
        onlineUsers.append(StringUtils.join(names, ChatColor.DARK_AQUA + ", "));

        if (senderIsConsole)
        {
            sender.sendMessage(ChatColor.stripColor(onlineStats.toString()));
            sender.sendMessage(ChatColor.stripColor(onlineUsers.toString()));
        }
        else
        {
            sender.sendMessage(onlineStats.toString());
            sender.sendMessage(onlineUsers.toString());
        }

        return true;
    }
}
