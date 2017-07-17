package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.World.EFMR_HistoryWorld2;
import me.StevenLawson.TotalFreedomMod.Commands.*;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.World.TFM_HistoryWorld;
import me.StevenLawson.TotalFreedomMod.World.TFM_MinigameWorld;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Goto the Heritageworld!.", usage = "/<command>")
public class Command_heritageworld extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (TFM_ConfigEntry.ENABLE_HISTORYWORLD.getBoolean())
        {
            EFMR_HistoryWorld2.getInstance().sendToWorld(sender_p);
            sender.setOp(true);
            sender_p.setGameMode(GameMode.CREATIVE);
            playerMsg("Going to the §eHistory§7 world back in late 2015...");
        }
        else
        {
            playerMsg("The world is currently disabled.");
        }
        return true;
    }
}
