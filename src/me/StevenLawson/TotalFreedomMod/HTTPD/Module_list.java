package me.StevenLawson.TotalFreedomMod.HTTPD;

import java.util.Collection;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Module_list extends TFM_HTTPD_Module
{
    public Module_list(NanoHTTPD.HTTPSession session)
    {
        super(session);
    }

    @Override
    public String getBody()
    {
        final StringBuilder body = new StringBuilder();

        final Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();

        body.append("<p>There are ").append(onlinePlayers.size()).append("/").append(Bukkit.getMaxPlayers()).append(" players online:</p>\r\n");

        body.append("<ul>\r\n");

        for (Player player : onlinePlayers)
        {
            String prefix = "";
            if (TFM_AdminList.isSuperAdmin(player))
            {
                if (TFM_AdminList.isSeniorAdmin(player))
                {
                    prefix = "[SrA]";
                }
                if (TFM_AdminList.isTelnetAdmin(player))
                {
                    prefix = "[STA]";
                }
                else
                {
                    prefix = "[SA]";
                }

                if (TFM_Util.DEVELOPERS.contains(player.getName()))
                {
                    prefix = "[Developer]";
                }
                if (TFM_Util.EXECS.contains(player.getName()))
                {
                    prefix = "[Executive]";
                }
                if (TFM_Util.SPECIAL_EXECS.contains(player.getName()))
                {
                    prefix = "[Specialist]";
                }
                if (TFM_Util.SYS_COOWNERS.contains(player.getName()))
                {
                    prefix = "[Co-Owner]";
                }
                if (TFM_Util.SYS_ADMINS.contains(player.getName()))
                {
                    prefix = "[System-Admin]";
                }
                if (TFM_Util.SYS_COOWNERS.contains(player.getName()))
                {
                    prefix = "[Co-Owner]";
                }
                if (player.getName().equals("Alco_Rs11"))
                {
                    prefix = "[Owner]";
                }
            }
            else
            {
                if (player.isOp())
                {
                    prefix = "[OP]";
                }
            }

            body.append("<li>").append(prefix).append(player.getName()).append("</li>\r\n");
        }

        body.append("</ul>\r\n");

        return body.toString();
    }

    @Override
    public String getTitle()
    {
        return "EXPLODINGFreedom - Online Users";
    }
}
