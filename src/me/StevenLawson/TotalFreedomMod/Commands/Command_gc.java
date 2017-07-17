package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Request Garbage Collector", //Description
        usage = "/<command> ") //Usage
public class Command_gc extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
       playerMsg("§bAttemping to free memory!");
       Runtime.getRuntime().gc();
       System.gc();
   }
   return true;
    }
}