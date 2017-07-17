package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_EconomyManager;
import com.efdevelopment.EXPLODINGFreedomModRevamped.API.StringManager;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Get your balance.", aliases = "eco", usage = "/<command> <add/remove/set> <playername> <amount>")
public class Command_economy extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        if (!(sender instanceof Player))
        { // Checks if person is console or player
            if (args.length != 3)
            { // Person is console so now check if the arguments length is equal to 3
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /eco <add/remove/set> <player name> <amount>"); // Arguments length is not equal to 3 so send them this message
                return true;
            }

            if (args[0].equalsIgnoreCase("add"))
            { // Checks if argument 0 (/command <arg0> <arg1> <arg2> <so on..>) equals "add"
                if (!EFMR_EconomyManager.Isinfile(args[1]))
                { // Arg0 equals "add" so now check if it can find the person in the config
                    sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!"); // Player is not in the config so tell them this message
                    return true;
                }
                double amount = 0;
                try
                { // Checks if the the arg only contaions numbers
                    amount = Double.parseDouble(args[2]);
                }
                catch (Exception e)
                {
                    sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Please enter a valid number!!"); // Arg contions letters and not numbers so tell them this message
                    return true;
                }
                EFMR_EconomyManager.AddBalance(args[1], amount); // Arg only contions numbers so add the entered amount to the players balance
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bYou added §c" + EFMR_EconomyManager.Format(amount) + " §bto§c " + args[1] + "§b's balance."); // Tells the person that ran the command that they added the amount to the players balance
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b."); // Tells the person the new balance for the person they entered
            }
            else if (args[0].equalsIgnoreCase("remove"))
            { // Checks if argument 0 (/command <arg0> <arg1> <arg2> <so on..>) equals "remove"
                if (!EFMR_EconomyManager.Isinfile(args[1]))
                { // Arg0 equals "remove" so now check if it can find the person in the config
                    sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!"); // Player is not in the config so tell them this message
                    return true;
                }
                double amount = 0;
                try
                { // Checks if the the arg only contaions numbers
                    amount = Double.parseDouble(args[2]);
                }
                catch (Exception e)
                {
                    sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Please enter a valid number!!"); // Arg contions letters and not numbers so tell them this message
                    return true;
                }
                EFMR_EconomyManager.RemoveBalance(args[1], amount); // Arg only contions numbers so remove the entered amount from the players balance
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bYou removed §c" + EFMR_EconomyManager.Format(amount) + " §bfrom §c" + args[1] + "§b's balance."); // Tells the person that ran the command that they removed the amount to the players balance
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b."); // Tells the person the new balance for the person they entered
            }
            else if (args[0].equalsIgnoreCase("set"))
            { // Checks if argument 0 (/command <arg0> <arg1> <arg2> <so on..>) equals "set"
                if (!EFMR_EconomyManager.Isinfile(args[1]))
                { // Arg0 equals "set" so now check if it can find the person in the config
                    sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!"); // Player is not in the config so tell them this message
                    return true;
                }
                double amount = 0;
                try
                { // Checks if the the arg only contaions numbers
                    amount = Double.parseDouble(args[2]);
                }
                catch (Exception e)
                {
                    sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Please enter a valid number!!"); // Arg contions letters and not numbers so tell them this message
                    return true;
                }
                EFMR_EconomyManager.SetBalance(args[1], amount); // Arg only contions numbers so set the entered amount to the players balance
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bYou set §c" + args[1] + " §b's balance to§c " + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b."); // Tells the person that ran the command that they set the amount to the players balance
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b."); // Tells the person the new balance for the person they entered
            }
            else if (args[0].equalsIgnoreCase("reset"))
            { //  NOTE: THIS IS A SORT OF BROKEN AND SECRET COMMAND // IF YOU WANT TO USE THIS COMMAND YOU HAVE TO STILL ENTER AN AMOUNT BUT THE PLUGIN WILL NOT USE THAT AMOUNT AND WILL USE THE AMOUNT SET IN THE CONFIG      // Checks if argument 0 (/command <arg0> <arg1> <arg2> <so on..>) equals "reset"
                if (!EFMR_EconomyManager.Isinfile(args[1]))
                { // Arg0 equals "reset" so now check if it can find the person in the config
                    sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!"); // Player is not in the config so tell them this message
                    return true;
                }
                EFMR_EconomyManager.ResetBalance(args[1]); // Resets the players balance to the amount entered in the config
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bYou reset §c" + args[1] + "§b's balance."); // Tells the person that ran the command that they reset the players balance
            }
            else if (args[0].equalsIgnoreCase("new"))
            { //  NOTE: THIS IS A SECRET COMMAND // IF YOU WANT TO USE THIS COMMAND YOU HAVE TO STILL ENTER AN AMOUNT BUT THE PLUGIN WILL NOT USE THAT AMOUNT AND WILL USE THE AMOUNT SET IN THE CONFIG      // Checks if argument 0 (/command <arg0> <arg1> <arg2> <so on..>) equals "new"

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // THIS COMMAND IS SORT OF NO LONGER USED                                                                         //
                // THIS COMMAND ADDS THE NAME ENTERED TO THE CONFIG SO YOU CAN THEN USE THE NAME FOR OTHER COMMANDS LIKE /eco set //
                // IT IGNORES ALL CHECKS SO YOU CAN CHOOSE ANYTHING YOU WANT                                                      //
                // ONLY USE THIS IF THE PLAYERS NAME IS NOT ALREADY IN THE CONFIG                                                 //
                // ONLY USE THIS IF THE PLAYERS NAME HAS NOT ALREADY BEEN ENTERED FROM WHEN THEY FIRST JOINED                     //
                // SPAMMING THIS WITH RANDOM NAMES/CHARACTERS WILL CAUSE THE CONFIG TO GET LARGER AND CONTION MORE THINGS         //
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ////                                  YOU CAN REMOVE THIS COMMAND IF YOU WANT                                   ////
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                EFMR_EconomyManager.New(args[1]); // Arg only contions numbers so set the entered amount to the players balance
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bAdded player §c" + args[1] + " §bto the config."); // Tells the person that ran the command that they added that player to the config
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §bPlayer §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b."); // Tells the person that ran the command that they reset the players balance
            }
            else
            {
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Incorrect argument."); // If the person has entered something that does not equal "add"/"remove"/"set"/"reset"/"new" then send them this message
            }
            return true;
        }

        Player p = (Player) sender;

        if (!p.isOp())
        { // Checks if player is op
            p.sendMessage(StringManager.NoPermMessage); // Player is not op so send them this message
            return true;
        }

        //// This is now virtually the same as the code above so the same rules apply
        if (args.length != 3)
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bUsage: /eco <add/remove/set> <playername> <amount>");
            return true;
        }

        if (args[0].equalsIgnoreCase("add"))
        {
            if (!EFMR_EconomyManager.Isinfile(args[1]))
            {
                // Player is not in file
                p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!");
                return true;
            }
            double amount = 0;
            try
            {
                amount = Double.parseDouble(args[2]);
            }
            catch (Exception e)
            {
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Please enter a valid number!!");
                return true;
            }
            EFMR_EconomyManager.AddBalance(args[1], amount);
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bYou added §c" + EFMR_EconomyManager.Format(amount) + " §bto§c " + args[1] + "§b's balance.");
            p.sendMessage("§4§lEXPLODINGFreedom§e: §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b.");
        }
        else if (args[0].equalsIgnoreCase("remove"))
        {
            if (!EFMR_EconomyManager.Isinfile(args[1]))
            {
                // Player is not in file
                p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!");
                return true;
            }
            double amount = 0;
            try
            {
                amount = Double.parseDouble(args[2]);
            }
            catch (Exception e)
            {
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Please enter a valid number!!");
                return true;
            }
            EFMR_EconomyManager.RemoveBalance(args[1], amount);
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bYou removed §c" + EFMR_EconomyManager.Format(amount) + " §bfrom§c " + args[1] + "§b's balance.");
            p.sendMessage("§4§lEXPLODINGFreedom§e: §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b.");
        }
        else if (args[0].equalsIgnoreCase("set"))
        {
            if (!EFMR_EconomyManager.Isinfile(args[1]))
            {
                // Player is not in file
                p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!");
                return true;
            }
            double amount = 0;
            try
            {
                amount = Double.parseDouble(args[2]);
            }
            catch (Exception e)
            {
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Please enter a valid number!!");
                return true;
            }
            EFMR_EconomyManager.SetBalance(args[1], amount);
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bYou set §c" + args[1] + "§b's balance to §c" + EFMR_EconomyManager.Format(amount) + "§b.");
            p.sendMessage("§4§lEXPLODINGFreedom§e: §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b.");
        }
        else if (args[0].equalsIgnoreCase("reset"))
        {
            if (!EFMR_EconomyManager.Isinfile(args[1]))
            {
                // Player is not in file
                p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Player is not in the database!");
                return true;
            }
            EFMR_EconomyManager.ResetBalance(args[1]);
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bYou reset§c" + args[1] + "§b's balance.");
        }
        else if (args[0].equalsIgnoreCase("new"))
        {
            double amount = 0;
            try
            {
                amount = Double.parseDouble(args[2]);
            }
            catch (Exception e)
            {
                sender.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Please enter a valid number!!");
                return true;
            }
            EFMR_EconomyManager.New(args[1]);
            p.sendMessage("§4§lEXPLODINGFreedom§e: §bYou set §c" + args[1] + "§b's balance to §c" + EFMR_EconomyManager.Format(amount) + "§b.");
            p.sendMessage("§4§lEXPLODINGFreedom§e: §c" + args[1] + "§b's new balance is: §c" + EFMR_EconomyManager.Format(EFMR_EconomyManager.GetBalance(args[1])) + "§b.");
        }
        else
        {
            p.sendMessage("§4§lEXPLODINGFreedom§e: §cError: §4Incorrect argument.");
        }
        return true;
    }
}
