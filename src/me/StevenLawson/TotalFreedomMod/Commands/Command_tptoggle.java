package me.StevenLawson.TotalFreedomMod.Commands;

import static com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod.tptoggle;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Enable/Disable your teleportation.", usage = "/<command>")
public class Command_tptoggle extends TFM_Command
{
    public static HashMap<Player, ArrayList<Block>> getTpToggle()
    {
        return tptoggle;

    }

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            Player player = (Player) sender;
            if (!this.getTpToggle().containsKey(player))
            {
                this.getTpToggle().put(player, null);
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bTeleportation is now §cdisabled§b.");
            }
            else
            {
                this.getTpToggle().remove(player);
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bTeleportation is now §aenabled§b.");
            }
            return true;
        }
        if (args.length == 1)
        {
            Player player = Bukkit.getServer().getPlayer(args[0]);
            if (!this.getTpToggle().containsKey(player))
            {
                this.getTpToggle().put(player, null);
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bTeleportation is now §cdisabled§b for §e" + args[0] + "§b.");
            }
            else
            {
                this.getTpToggle().remove(player);
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bTeleportation is now §aenabled§b for §e" + args[0] + "§b.");
            }
        }
        return true;
    }
}
