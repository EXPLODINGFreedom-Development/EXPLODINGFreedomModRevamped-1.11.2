package me.StevenLawson.TotalFreedomMod.Commands;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.StevenLawson.TotalFreedomMod.Bridge.TFM_EssentialsBridge;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Give yourself a nickname.", usage = "/<command> <<nick> | off>")
public class Command_nick extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        File file = new File("plugins/EXPLODINGFreedomModRevamped/Data", "nicknames.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Player p = (Player) sender;
        if ("off".equals(args[0]))
        {
            p.getPlayer().setDisplayName(cfg.getString(p.getPlayer().getName()));
            cfg.set(p.getName(), p.getName());
            try
            {
                cfg.save(file);
            }
            catch (IOException ex)
            {
                Logger.getLogger(Command_nick.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        if (args.length == 0)
        {
            p.sendMessage(ChatColor.RED + "You did not specify a nickname!");
            return true;
        }

        String nick = "";
        for (String arg : args)
        {
            nick += arg + " ";
        }

        nick = nick.substring(0, nick.length() - 1);

        nick = nick.replaceAll("&", "§");

        p.sendMessage(ChatColor.GREEN + "You have changed your nickname to " + nick);
        cfg.set(p.getName(), nick);
        p.setDisplayName(cfg.getString(p.getPlayer().getName()));
        p.setCustomName(cfg.getString(p.getPlayer().getName()));
        try
        {
            cfg.save(file);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Command_nick.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
