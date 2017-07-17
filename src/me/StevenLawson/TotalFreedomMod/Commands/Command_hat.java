package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Set an item as helmet", usage = "/<command>")
public class Command_hat extends TFM_Command {
      @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(ChatColor.RED + "§cThis command can only be used ingame!");
      }
      Player p = (Player)sender;
      if (args.length != 0)
      {
        sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /hat");
      }
      if ((p.getInventory().getItemInHand().getType() == Material.AIR) || (p.getInventory().getItemInHand().getType() == null))
      {
        sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cYou cannot use that item as a hat!");
      }
      else if (p.getInventory().getHelmet() != null)
      {
        ItemStack hat = p.getInventory().getHelmet();
        p.getInventory().addItem(new ItemStack[] { hat });
        p.getInventory().setHelmet(p.getInventory().getItemInHand());
        p.getInventory().remove(p.getInventory().getItemInHand());
        sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYour hat has been set!");
      }
      else if (p.getInventory().getHelmet() == null)
      {
        p.getInventory().setHelmet(p.getInventory().getItemInHand());
        p.getInventory().remove(p.getInventory().getItemInHand());
        sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYour hat has been set!");
      }
    return true;
  }
}