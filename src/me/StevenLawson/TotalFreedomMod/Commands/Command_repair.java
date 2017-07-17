package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Repair item in hand or all items.", usage = "/<command> <hand|all>")
public class Command_repair extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        if (args.length != 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /repair <hand|all>");
            return false;
        }
        if (args[0].equalsIgnoreCase("hand"))
        {
            ItemStack berepaired = p.getItemInHand();
            if ((berepaired.getTypeId() == 256)
                    || (berepaired.getTypeId() == 257)
                    || (berepaired.getTypeId() == 258)
                    || (berepaired.getTypeId() == 259)
                    || (berepaired.getTypeId() == 261)
                    || (berepaired.getTypeId() == 267)
                    || (berepaired.getTypeId() == 268)
                    || (berepaired.getTypeId() == 269)
                    || (berepaired.getTypeId() == 270)
                    || (berepaired.getTypeId() == 271)
                    || (berepaired.getTypeId() == 272)
                    || (berepaired.getTypeId() == 273)
                    || (berepaired.getTypeId() == 274)
                    || (berepaired.getTypeId() == 275)
                    || (berepaired.getTypeId() == 276)
                    || (berepaired.getTypeId() == 277)
                    || (berepaired.getTypeId() == 278)
                    || (berepaired.getTypeId() == 279)
                    || (berepaired.getTypeId() == 283)
                    || (berepaired.getTypeId() == 284)
                    || (berepaired.getTypeId() == 285)
                    || (berepaired.getTypeId() == 286)
                    || (berepaired.getTypeId() == 290)
                    || (berepaired.getTypeId() == 291)
                    || (berepaired.getTypeId() == 292)
                    || (berepaired.getTypeId() == 293)
                    || (berepaired.getTypeId() == 294)
                    || (berepaired.getTypeId() == 298)
                    || (berepaired.getTypeId() == 299)
                    || (berepaired.getTypeId() == 300)
                    || (berepaired.getTypeId() == 301)
                    || (berepaired.getTypeId() == 302)
                    || (berepaired.getTypeId() == 303)
                    || (berepaired.getTypeId() == 304)
                    || (berepaired.getTypeId() == 305)
                    || (berepaired.getTypeId() == 306)
                    || (berepaired.getTypeId() == 307)
                    || (berepaired.getTypeId() == 308)
                    || (berepaired.getTypeId() == 309)
                    || (berepaired.getTypeId() == 310)
                    || (berepaired.getTypeId() == 311)
                    || (berepaired.getTypeId() == 312)
                    || (berepaired.getTypeId() == 313)
                    || (berepaired.getTypeId() == 314)
                    || (berepaired.getTypeId() == 315)
                    || (berepaired.getTypeId() == 316)
                    || (berepaired.getTypeId() == 317)
                    || (berepaired.getTypeId() == 346)
                    || (berepaired.getTypeId() == 359))
            {
                p.getItemInHand().setDurability((short) 0);
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou repaired the item in your hand.");
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cERROR: You cannot repair that item, it must either be repairable or have lost durability.");
            }
        }
        else if (args[0].equalsIgnoreCase("all"))
        {
            ItemStack[] arrayOfItemStack;
            int j = (arrayOfItemStack = p.getInventory().getContents()).length;
            for (int i = 0; i < j; i++)
            {
                ItemStack berepaired = arrayOfItemStack[i];
                if ((berepaired != null) && ((berepaired.getTypeId() == 256)
                        || (berepaired.getTypeId() == 257)
                        || (berepaired.getTypeId() == 258)
                        || (berepaired.getTypeId() == 259)
                        || (berepaired.getTypeId() == 261)
                        || (berepaired.getTypeId() == 267)
                        || (berepaired.getTypeId() == 268)
                        || (berepaired.getTypeId() == 269)
                        || (berepaired.getTypeId() == 270)
                        || (berepaired.getTypeId() == 271)
                        || (berepaired.getTypeId() == 272)
                        || (berepaired.getTypeId() == 273)
                        || (berepaired.getTypeId() == 274)
                        || (berepaired.getTypeId() == 275)
                        || (berepaired.getTypeId() == 276)
                        || (berepaired.getTypeId() == 277)
                        || (berepaired.getTypeId() == 278)
                        || (berepaired.getTypeId() == 279)
                        || (berepaired.getTypeId() == 283)
                        || (berepaired.getTypeId() == 284)
                        || (berepaired.getTypeId() == 285)
                        || (berepaired.getTypeId() == 286)
                        || (berepaired.getTypeId() == 290)
                        || (berepaired.getTypeId() == 291)
                        || (berepaired.getTypeId() == 292)
                        || (berepaired.getTypeId() == 293)
                        || (berepaired.getTypeId() == 294)
                        || (berepaired.getTypeId() == 298)
                        || (berepaired.getTypeId() == 299)
                        || (berepaired.getTypeId() == 300)
                        || (berepaired.getTypeId() == 301)
                        || (berepaired.getTypeId() == 302)
                        || (berepaired.getTypeId() == 303)
                        || (berepaired.getTypeId() == 304)
                        || (berepaired.getTypeId() == 305)
                        || (berepaired.getTypeId() == 306)
                        || (berepaired.getTypeId() == 307)
                        || (berepaired.getTypeId() == 308)
                        || (berepaired.getTypeId() == 309)
                        || (berepaired.getTypeId() == 310)
                        || (berepaired.getTypeId() == 311)
                        || (berepaired.getTypeId() == 312)
                        || (berepaired.getTypeId() == 313)
                        || (berepaired.getTypeId() == 314)
                        || (berepaired.getTypeId() == 315)
                        || (berepaired.getTypeId() == 316)
                        || (berepaired.getTypeId() == 317)
                        || (berepaired.getTypeId() == 346)
                        || (berepaired.getTypeId() == 359)))
                {
                    berepaired.setDurability((short) 0);
                }

            }
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou repaired all items in your inventory.");
        }
        return true;
    }
}
