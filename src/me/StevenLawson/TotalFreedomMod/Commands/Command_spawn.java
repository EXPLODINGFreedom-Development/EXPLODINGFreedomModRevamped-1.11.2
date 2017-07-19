package me.StevenLawson.TotalFreedomMod.Commands;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = false)
@CommandParameters(description = "Sets the Global Spawnpoint.", usage = "/<command>")
public class Command_spawn extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
      if (!(sender instanceof Player))
    {
      sender.sendMessage("§cERROR: Only players may use this command!");
      return true;
    }
    Player p = (Player)sender;
    File file = new File("plugins//EXPLODINGFreedomModRevamped//Spawn.yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      if (file.exists())
      {
        Location loc = p.getLocation();
        
        double yaw = cfg.getDouble("Spawn.YAW");
        double pitch = cfg.getDouble("Spawn.PITCH");
        
        loc.setX(cfg.getDouble("Spawn.X"));
        loc.setY(cfg.getDouble("Spawn.Y"));
        loc.setZ(cfg.getDouble("Spawn.Z"));
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        
        World world = Bukkit.getWorld(cfg.getString("Spawn.WORLD"));
        
        loc.setWorld(world);

        p.sendMessage("§3Teleporting...");
        p.teleport(loc, PlayerTeleportEvent.TeleportCause.COMMAND);
      }
      else
      {
        p.sendMessage("§cERROR: No spawn has been set!");
      }
      return true;
    }
}