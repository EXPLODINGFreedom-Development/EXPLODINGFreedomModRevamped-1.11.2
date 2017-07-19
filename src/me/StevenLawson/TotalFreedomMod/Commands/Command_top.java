package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_LocationUtil;
import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Teleport to a player.", aliases = "teleport", usage = "/<command> <playername> <player2>")
public class Command_top extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        try
        {
            Player player = (Player) sender;
            final int topX = player.getLocation().getBlockX();
            final int topZ = player.getLocation().getBlockZ();
            final float pitch = player.getLocation().getPitch();
            final float yaw = player.getLocation().getYaw();
            final Location loc = EFMR_LocationUtil.getSafeDestination(new Location(player.getWorld(), topX, player.getWorld().getMaxHeight(), topZ, yaw, pitch));
            player.teleport(loc, TeleportCause.COMMAND);
            player.sendMessage("§4§lEXPLODINGFreedom§e: §bTeleporting to the top.");
            return true;
        }
        catch (Exception ex)
        {
            Logger.getLogger(Command_top.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
