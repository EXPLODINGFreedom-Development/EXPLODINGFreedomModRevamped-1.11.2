package me.StevenLawson.TotalFreedomMod.Rank;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_BuilderList;
import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_DonatorList;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.BUILDERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.CHIEFEXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.HELPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.LEADSYSS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.MULTICRAFTS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SPECIAL_EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_ADMINS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_COOWNERS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    SUPERDONATOR("a " + ChatColor.BLUE + "Supporter", ChatColor.BLUE + "§8[§9Supporter§8]§9"),
    SENIORDONATOR("a" + ChatColor.BLUE + "Supporter+", ChatColor.BLUE + "§8[§9Supporter+§8]§9"),
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "§8[§5Developer§8]§5"),
    CONSOLE("the " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "§8[§5Console§8]§5"),
    OWNER("the " + ChatColor.DARK_RED + "System-Owner", ChatColor.DARK_RED + "§8[§4System-Owner§8]§4"),
    SYS_COOWNER("the " + ChatColor.DARK_BLUE + "System Co-Owner", ChatColor.DARK_BLUE + "§8[§1System Co-Owner§8]§1"),
    LEADSYS("the " + ChatColor.DARK_RED + "Lead System-Admin", ChatColor.DARK_RED + "§8[§4Lead System-Admin§8]§4"),
    SYS_ADMIN("a " + ChatColor.DARK_RED + "System-Admin", ChatColor.DARK_RED + "§8[§4System-Admin§8]§4"),
    CHIEFEXEC("the " + ChatColor.RED + "Chief Executive Officer", ChatColor.RED + "§8[§cChief Executive Officer§8]§c"),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "§8[§dSrA§8]§d"),
    MULTICRAFT("a " + ChatColor.GREEN + "Telnet MultiCraft Admin", ChatColor.GREEN + "§8[§aTelnet Multi-Admin§8]§a"),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "§8[§2STA§8]§2"),
    EXEC("a " + ChatColor.BLUE + "Executive", ChatColor.BLUE + "§8[§9Executive§8]§9"),
    SPECEXEC("a " + ChatColor.GREEN + "Specialist", ChatColor.GREEN + "§8[§aSpecialist§8]§a"),
    HELPER("a " + ChatColor.YELLOW + "Helper", ChatColor.YELLOW + "§8[§eHelper§8]§e"),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "§8[§6SA§8]§6"),
    ARCHITECT("an " + ChatColor.GOLD + "Architect", ChatColor.GOLD + "§8[§6Architect§8]§6"),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "§8[§cOP§8]§c"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "§8[§eIMP§8]§e");
    private String loginMessage;
    private String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }
        if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }
        if (SYS_COOWNERS.contains(sender.getName()))
        {
            return SYS_COOWNER;
        }
        if (LEADSYSS.contains(sender.getName()))
        {
            return LEADSYS;
        }
        if (SYS_ADMINS.contains(sender.getName()))
        {
            return SYS_ADMIN;
        }
        if (SPECIAL_EXECS.contains(sender.getName()))
        {
            return SPECEXEC;
        }
        if (EXECS.contains(sender.getName()))
        {
            return EXEC;
        }
        if (CHIEFEXECS.contains(sender.getName()))
        {
            return CHIEFEXEC;
        }
        if (HELPERS.contains(sender.getName()))
        {
            return HELPER;
        }
        if (MULTICRAFTS.contains(sender.getName()))
        {
            return MULTICRAFT;
        }
        if (EFMR_DonatorList.isSuperDonor(sender))
        {
            return SUPERDONATOR;
        }
        if (EFMR_BuilderList.isSuperBuilder(sender))
        {
            return ARCHITECT;
        }
        if (BUILDERS.contains(sender.getName()))
        {
            return ARCHITECT;
        }
        if (EFMR_DonatorList.isSeniorDonor(sender))
        {
            return SENIORDONATOR;
        }
        final TFM_Admin entry = TFM_AdminList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }

            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {

                rank = SUPER;
            }
        }
        else if (sender.isOp())
        {
            rank = OP;
        }
        else
        {
            rank = NON_OP;
        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
