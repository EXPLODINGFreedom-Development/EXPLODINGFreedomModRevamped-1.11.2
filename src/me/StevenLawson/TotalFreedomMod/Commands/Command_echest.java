package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Open your enderchest.", aliases = "enderchest", usage = "/<command>")
public class Command_echest extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "§cThis command can only be used ingame!");
            return false;
        }
        Player p = (Player) sender;
        HumanEntity player = p;
        if (args.length != 0)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /echest");
            return false;
        }
        player.openInventory(player.getEnderChest());
        return true;
    }
}
