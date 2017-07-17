package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="display a nazi symbol in chat... may be spammy.", usage="/<command>", aliases="cleanswastika")
public class Command_cswastika
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "|              |-------------");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "|              |             ");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "|              |             ");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "|              |             ");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "|              |             ");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "|              |             ");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "---------------|------------|");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |            |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |            |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |            |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |            |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |            |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |            |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "---------------|            |");
    sender_p.playSound(sender_p.getLocation(), Sound.ENTITY_FIREWORK_TWINKLE, 1.0F, 1.0F);
    return true;
  }
}
