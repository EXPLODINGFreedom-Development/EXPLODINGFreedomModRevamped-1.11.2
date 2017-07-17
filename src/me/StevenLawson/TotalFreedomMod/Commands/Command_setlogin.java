package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.SENIOR, source=SourceType.ONLY_IN_GAME)
@CommandParameters(description="Sets your login message", usage="/<command> [player] <loginmessage>")
public class Command_setlogin
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (args.length == 0) {
      return false;
    }
    Player player = getPlayer(args[0]);
    if (player == null)
    {
      playerMsg(TFM_Command.PLAYER_NOT_FOUND);
      return true;
    }
    if (args.length < 1) {
      String msg = StringUtils.join(args, " ", 1, args.length);  
    EXPLODINGFreedomMod.setLoginMessage(player, msg);
    TFM_AdminList.saveAll();
    sender.sendMessage(ChatColor.GREEN + "Successfully set " + player.getName() + "'s login message to the following:");
playerMsg("> " + ChatColor.AQUA + player.getName() + " is " +  ChatColor.translateAlternateColorCodes('&', msg));
    return true;
  }
    return false;
  }
}