package com.efdevelopment.EXPLODINGFreedomModRevamped.misc;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import java.util.List;
public class EFMR_CommandBlockListener implements Listener
{

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockRedstone(BlockRedstoneEvent event)
    {
        Block block = event.getBlock();

        List list1 = TFM_ConfigEntry.COMMANDBLOCK_COMMANDS.getList();
        {
            if ((block.getType().equals(Material.COMMAND)) && ((block.getState() instanceof CommandBlock))
                    && (event.getNewCurrent() != 0) && (event.getOldCurrent() == 0))
            {
                String command = ((CommandBlock) block.getState()).getCommand().toLowerCase().trim().split(" ")[0];
                if (list1.contains(command))
                {
                    event.setNewCurrent(0);
                }
            }
        }
    }
}
