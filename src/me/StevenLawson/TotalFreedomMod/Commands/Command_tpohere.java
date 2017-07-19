package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Teleport all players to you. (Overrides tptoggle)", usage = "/<command>")
public class Command_tpohere extends TFM_Command
{
    public final HashMap<Player, ArrayList<Block>> tptoggle = new HashMap();

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player = (Player) sender;
        Player firstPlayer = player.getServer().getPlayer(args[0]);
        if (firstPlayer == null)
        {
            sender.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §cError: Player §4" + args[0] + " §cis not online!");
        }
        else
        {
            Location locationToTeleport = player.getLocation();
            firstPlayer.teleport(locationToTeleport, PlayerTeleportEvent.TeleportCause.COMMAND);
            EXPLODINGFreedomMod.back.put(firstPlayer.getName(), player.getLocation());
            player.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §b" + "Teleporting §c" + firstPlayer.getName() + " §bto you.");
        }
        return true;
    }
}
