package me.StevenLawson.TotalFreedomMod.Commands;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH, blockHostConsole = false)
@CommandParameters(description = "Sets the Global Spawnpoint.", usage = "/<command>")
public class Command_setspawn extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
     
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Only players may use this command!");
      return true;
    }
    Player p = (Player)sender;
    File file = new File("plugins//EXPLODINGFreedomModRevamped//Spawn.yml");
    {
      if (args.length == 0)
      {
        if (!file.exists()) {
          try
          {
            file.createNewFile();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }
        Location loc = p.getLocation();
        
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        float yaw = loc.getYaw();
        float pitch = loc.getPitch();
        String world = loc.getWorld().getName();
        
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        
        cfg.set("Spawn.X", Double.valueOf(x));
        cfg.set("Spawn.Y", Double.valueOf(y));
        cfg.set("Spawn.Z", Double.valueOf(z));
        cfg.set("Spawn.YAW", Float.valueOf(yaw));
        cfg.set("Spawn.PITCH", Float.valueOf(pitch));
        cfg.set("Spawn.WORLD", world);
        try
        {
          cfg.save(file);
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        p.sendMessage("§3Spawnpoint set!");
      }
      else
      {
        p.sendMessage("§eUsage: /spawn");
      }
    }
    return true;
  }
}
