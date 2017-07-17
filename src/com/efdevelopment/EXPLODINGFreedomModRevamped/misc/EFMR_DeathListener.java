package com.efdevelopment.EXPLODINGFreedomModRevamped.misc;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EFMR_DeathListener implements Listener
{

    @EventHandler
    public void onDeath(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        EXPLODINGFreedomMod.back.put(p.getName(), p.getLocation());
    }
}
