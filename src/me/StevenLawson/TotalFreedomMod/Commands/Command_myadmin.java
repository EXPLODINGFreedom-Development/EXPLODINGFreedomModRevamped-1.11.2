package me.StevenLawson.TotalFreedomMod.Commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_Admin;
import static org.spigotmc.SpigotConfig.init;

/**
This is the ExplodingManage command. if you obtain the source code DO NOT remove this class or modify it.
Its here for the bad people that decide to rename the plugin and pass it as there own. Similar to the TFM_FrontDoor
This requires BarAPI for the project to compile
If you're wondering what this class exactly does I've noted it with the '//'s
The your wondering what (mode.equals("")) does it defines what you have to say for the command to go through.
*/

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Find info about my admin status or clear my ip.", //Description
        aliases = "ma",
        usage = "/<command> [info | clearme | setlogin <message>]") //Usage
public class Command_myadmin extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
                   } 
        if (args.length == 0)
        {
            return false;
        }

        String mode = args[0].toLowerCase();

        if (mode.equals("info")) 
        {
        server.dispatchCommand(sender, "saconfig info " + sender.getName());	
        }
         if (mode.equals("setlogin"))
            {
                if (args.length < 1)
                {
                    return false;
                }
                Player player = getPlayer(args[0]);
                String loginmsg = StringUtils.join(args, " ", 1, args.length);
                TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + " Setting personal login message");
                   EXPLODINGFreedomMod.setLoginMessage(player, loginmsg);
                playerMsg(ChatColor.AQUA + "Your login message is now: ");
                playerMsg("> " + ChatColor.AQUA + player.getName() + " is " +  ChatColor.translateAlternateColorCodes('&', loginmsg));
                return true;
            }
        if (mode.equals("clearme"))
        {
        server.dispatchCommand(sender, "saconfig clearme");	
        }
         return true;
        }
}