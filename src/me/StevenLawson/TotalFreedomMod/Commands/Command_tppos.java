package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Teleport to a coordinates.", aliases = "tpcoords", usage = "/<command> [x] [y] [z] [yaw] [pitch]")
public class Command_tppos extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player = Bukkit.getServer().getPlayer(sender.getName());
        Location playerloc = player.getLocation();
        Chunk chunk = player.getWorld().getChunkAt(playerloc);
        Bukkit.getWorld(player.getWorld().getName()).loadChunk(chunk);
        try
        {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);
            playerloc = new Location(player.getWorld(), x, y, z);

            player.teleport(playerloc);
            EXPLODINGFreedomMod.back.put(player.getName(), player.getLocation());
        }
        catch (Exception e)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /tppos [x] [y] [z]");
        }
        return true;
    }
}
