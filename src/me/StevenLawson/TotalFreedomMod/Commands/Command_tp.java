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

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Teleport to a player.", aliases = "teleport", usage = "/<command> <playername> <player2>")
public class Command_tp extends TFM_Command
{
    Command_tptoggle x = new Command_tptoggle();
    HashMap<Player, ArrayList<Block>> tptoggle = x.getTpToggle();
   
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {

            Player player = (Player) sender;
            Player targetPlayer = player.getServer().getPlayer(args[0]);
            if (targetPlayer == null)
            {
                sender.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §cError: Player §4" + args[0] + " §cis not online!");
            }
            else if (!Command_tptoggle.getTpToggle().containsKey(Bukkit.getServer().getPlayer(args[0])))
            {
                Location targetPlayerLocation = targetPlayer.getLocation();
                Player p = (Player) sender;
                String targetPlayerName = targetPlayer.getDisplayName();
                player.teleport(targetPlayerLocation);
                player.teleport(Bukkit.getServer().getPlayer(args[0]).getLocation());
                EXPLODINGFreedomMod.back.put(p.getName(), p.getLocation());
                player.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §bTeleporting to §c" + targetPlayerName + "§b.");
            }
            else
            {
                sender.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §cError: Player §4" + args[0] + " §chas their teleportation disabled.");
            }

            return true;
        }
        if (args.length == 2)
        {
            if (!Command_tptoggle.getTpToggle().containsKey(Bukkit.getServer().getPlayer(args[0])))
            {
                Player firstPlayer = Bukkit.getServer().getPlayer(args[0]);
                Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
                Player player = (Player) sender;
                if (targetPlayer == null)
                {
                    sender.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §cError: Player §4" + args[0] + " §cis not online!");
                }
                else if (firstPlayer == null)
                {
                    sender.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §cError: Player §4" + args[1] + " §cis not online!");
                }
                else
                {
                    Location targetPlayerLocation = targetPlayer.getLocation();
                    firstPlayer.teleport(Bukkit.getServer().getPlayer(args[1]).getLocation());
                    EXPLODINGFreedomMod.back.put(firstPlayer.getName(), firstPlayer.getLocation());
                    sender.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §bTeleporting §c" + firstPlayer.getDisplayName() + " §bto §c" + targetPlayer.getDisplayName() + "§b.");
                    firstPlayer.sendMessage(ChatColor.YELLOW + "§4§lEXPLODINGFreedom§e: §bPlayer §c" + player.getDisplayName() + " §bteleported you to §c" + targetPlayer.getDisplayName() + "§b.");
                }
            }
            else
            {
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: Player §4" + args[0] + " §chas their teleportation disabled.");
            }
            return true;
        }
        return true;
    }
}
