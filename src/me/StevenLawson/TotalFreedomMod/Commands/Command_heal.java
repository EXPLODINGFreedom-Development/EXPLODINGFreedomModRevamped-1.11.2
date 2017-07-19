package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Player.TFM_Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Heal yourself.", aliases = "admininfo", usage = "/<command> <player>")
public class Command_heal extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length > 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /heal <playername>");
            return false;
        }
        if (args.length == 0)
        {
            p.setHealth(20);
            p.setFireTicks(0);
            p.setFoodLevel(20);
            p.setSaturation(20.0F);
            TFM_Scoreboard.updateStats(p);
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou have healed §c" + p.getDisplayName() + "§b");
            return true;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cERROR: Player is not online.");
        }
        else
        {
            target.setHealth(20);
            target.setFireTicks(0);
            target.setFoodLevel(20);
            target.setSaturation(20.0F);
            TFM_Scoreboard.updateStats(target);
            for (PotionEffect potion_effect : target.getActivePotionEffects())
            {
                target.removePotionEffect(potion_effect.getType());
            }
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou have been healed.");
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou have healed §c" + target.getDisplayName() + "§b");
        }
    return true;
    }
}