package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Commands.*;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.World.TFM_AdminWorld;
import me.StevenLawson.TotalFreedomMod.World.TFM_MinigameWorld;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Goto the Minigameworld!.", usage = "/<command>")
public class Command_mgworld extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (TFM_ConfigEntry.FLATLANDS_GENERATE.getBoolean())
        {
            //TFM_MinigameWorld.getInstance().sendToWorld(sender_p);
            World mgWorld = null;
            try
            {
                Location playerloc = sender_p.getLocation();
                Chunk chunk = sender_p.getWorld().getChunkAt(playerloc);
                mgWorld = TFM_MinigameWorld.getInstance().getWorld();
                int x = Integer.parseInt("0");
                int y = Integer.parseInt("50");
                int z = Integer.parseInt("0");
                playerloc = new Location(mgWorld, x, y, z);
                sender_p.teleport(playerloc, PlayerTeleportEvent.TeleportCause.COMMAND);
            }
            catch (Exception ex)
            {
            }
            sender.setOp(true);
            sender_p.setGameMode(GameMode.SURVIVAL);
            playerMsg("Going to the §eMiniGames§7 world.");
        }
        else
        {
            playerMsg("The world is currently disabled.");
        }
        return true;
    }
}
