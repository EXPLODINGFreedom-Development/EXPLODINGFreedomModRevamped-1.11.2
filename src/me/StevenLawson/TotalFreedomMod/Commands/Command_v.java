package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Enable invisibility!", usage = "/<command> <on|off>", aliases = "vanish")
public class Command_v extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        {
        }
        if (args.length == 0)
        {
            return false;
        }

        String mode = args[0].toLowerCase();
        Player p = (Player) sender;
        if (mode.equals("on"))
        {
            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1000000, true, false));
            playerMsg("You are now invisible from other players.", ChatColor.GOLD);
        }

        if (mode.equals("off"))
        {
            sender_p.removePotionEffect(PotionEffectType.INVISIBILITY);
            playerMsg("You are no longer invisible from other players.", ChatColor.GOLD);
        }
        return true;
    }
}
