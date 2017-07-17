package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandLoader
{
    private TotalFreedomMod plugin;

    public CommandLoader(TotalFreedomMod plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        return TFM_CommandHandler.handleCommand(sender, cmd, commandLabel, args);
    }
}
