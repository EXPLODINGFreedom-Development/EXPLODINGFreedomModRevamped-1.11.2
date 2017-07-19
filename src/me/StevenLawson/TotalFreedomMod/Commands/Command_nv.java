package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Enable Night Vision!", usage = "/<command> <on|off>", aliases = "nightvision,nightsee")
public class Command_nv extends TFM_Command
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
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1000000, true, false));
            playerMsg("You are now able to see in the dark.", ChatColor.GOLD);
        }

        if (mode.equals("off"))
        {
            sender_p.removePotionEffect(PotionEffectType.NIGHT_VISION);
            playerMsg("You are no longer able to see in the dark.", ChatColor.GOLD);
        }
        return true;
    }
}
