package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Shoot a fireball.", usage = "/<command>")
public class Command_fireball extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "§cThis command can only be used ingame!");
        }
        Player p = (Player) sender;
        if (args.length != 0)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /hat");
            return false;
        }
        Fireball fireball = (Fireball) p.launchProjectile(Fireball.class);
        fireball.setVelocity(fireball.getVelocity().multiply(2));
        return true;
    }
}
