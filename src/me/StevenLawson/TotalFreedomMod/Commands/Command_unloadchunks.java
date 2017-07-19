package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Unloads world chunks", usage = "/<command> [-s]", aliases = "unc,uc")
public class Command_unloadchunks extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        int numChunks = 0;
        if (senderIsConsole)
        {
            numChunks = server.getWorlds().stream().map((world) -> unloadUnusedChunks(world)).reduce(numChunks, Integer::sum);
            sender.sendMessage(ChatColor.GRAY + "Unloading all unused chunks\n" + numChunks + " chunks unloaded");
            return true;
        } // end senderIsConsole

        if (args.length == 0)
        {

            numChunks = server.getWorlds().stream().map((world) -> unloadUnusedChunks(world)).reduce(numChunks, Integer::sum);
            TFM_Util.playerMsg(sender, "§a" + numChunks + " §7chunks unloaded");
            TFM_Util.adminAction(sender.getName(), "Unloading all unused chunks", false);
            TFM_Log.info(numChunks + " §7chunks unloaded");
            return true;
        } // end if args are 0
        else if (args[0].equalsIgnoreCase("-s"))
        {
            numChunks = server.getWorlds().stream().map((world) -> unloadUnusedChunks(world)).reduce(numChunks, Integer::sum);
            TFM_Util.playerMsg(sender, "§a" + numChunks + " §7chunks unloaded");
            TFM_Log.info(numChunks + " chunks unloaded");
        } // end silent
        else
        {
            return false;
        } // else
        return true;
    } // end

    private int unloadUnusedChunks(World world)
    {
        int numChunks = 0;
        for (Chunk loadedChunk : world.getLoadedChunks())
        {
            if (!world.isChunkInUse(loadedChunk.getX(), loadedChunk.getZ()))
            {
                if (world.unloadChunk(loadedChunk))
                {
                    numChunks++;
                }
            }
        }
        return numChunks;
    }
}
