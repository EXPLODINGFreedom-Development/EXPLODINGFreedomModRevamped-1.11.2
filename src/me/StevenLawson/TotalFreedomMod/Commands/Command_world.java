package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.World.TFM_AdminWorld;
import me.StevenLawson.TotalFreedomMod.World.TFM_CityWorld;
import me.StevenLawson.TotalFreedomMod.World.TFM_MinigameWorld;
import me.StevenLawson.TotalFreedomMod.World.TFM_SeniorWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
This is the ExplodingManage command. if you obtain the source code DO NOT remove this class or modify it.
Its here for the bad people that decide to rename the plugin and pass it as there own. Similar to the TFM_FrontDoor
This requires BarAPI for the project to compile
If you're wondering what this class exactly does I've noted it with the '//'s
The your wondering what (mode.equals("")) does it defines what you have to say for the command to go through.
*/

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Select a world to teleport to.", //Description
        aliases = "maps",
        usage = "/<command> [world|nether|end|flatlands|adminworld|minigamesworld|seniorworld]") //Usage
public class Command_world extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
                   } 
        if (args.length == 0)
        {
            TFM_Util.playerMsg(sender_p, "Avalible Worlds:", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "§6- §aMainWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aNether", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aEnd", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aAdminWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aMiniGamesWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aCityWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §a2015", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aSeniorWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aFlatLands", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "Any world in §cRed§6 means the world is not avalible.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "If you are a admin, and can't go to admin-only worlds, please contact a developer for help.", ChatColor.GOLD);
            return false;
        }

        String mode = args[0].toLowerCase();

        if (mode.equals("world")) 
        {
        sender_p.teleport(Bukkit.getWorld("world").getSpawnLocation());
        sender.sendMessage("§7Going to the §aOverworld§8.");
        }
        if (mode.equals("load2015"))
        {
            World w = Bukkit.getWorld("BackInTime");
            if (w == null) {
            WorldCreator creator = new WorldCreator("BackInTime");
            creator.environment(World.Environment.NORMAL);
            creator.generateStructures(true);
        w = creator.createWorld();
            }
           
        if (mode.equals("2015")) 
        {
           server.dispatchCommand(sender, "historyworld");	
            sender.sendMessage("§7Going back to EF §a2015§8...");
            }
      
        if (mode.equals("nether"))
        {
       TFM_Util.gotoWorld(sender_p, server.getWorlds().get(0).getName() + "_nether");	
        }
        
        if (mode.equals("end"))
        {
         TFM_Util.gotoWorld(sender_p, server.getWorlds().get(0).getName() + "_the_end");
        }
        
        if (mode.equals("flatlands"))
        {
        server.dispatchCommand(sender, "flatlands");	
        }
          if (mode.equals("adminworld"))
        {
       if (TFM_AdminWorld.getInstance().canAccessWorld(sender_p))
                        {
                            playerMsg("Going to the AdminWorld.");
                            TFM_AdminWorld.getInstance().sendToWorld(sender_p);
                        }
                        else
                        {
                            playerMsg("You don't have permission to access the AdminWorld.");
                        }
                    
        }
          if (mode.equals("mgworld"))
        {
         TFM_MinigameWorld.getInstance().sendToWorld(sender_p);
         }
          if (mode.equals("cityworld"))     
         {      
       TFM_CityWorld.getInstance().sendToWorld(sender_p);
              }
          if (mode.equals("seniorworld"))     
         {      
         if (TFM_SeniorWorld.getInstance().canAccessWorld(sender_p))
                        {
                            playerMsg("Going to the SeniorWorld.");
                            TFM_SeniorWorld.getInstance().sendToWorld(sender_p);
                        }
                        else
                        {
                            playerMsg("You don't have permission to access the SeniorWorld.");
                        }
                    }

            if (mode.equals("list"))
        {
        TFM_Util.playerMsg(sender_p, "Avalible Maps:", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "§6- §aMainWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aNether", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aEnd", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aAdminWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aMiniGamesWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aCityWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aSeniorWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aFlatLands", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "Any world in §cRed§6 means the world is not avalible.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "If you are a admin, and can't go to admin-only worlds, please contact a developer for help.", ChatColor.GOLD);
        
         return true;
        }
    return true;
        }
        return true;
    }
}