package com.efdevelopment.EXPLODINGFreedomModRevamped;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_Lists;
import java.util.ArrayList;
import java.util.HashMap;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EXPLODINGFreedomMod
{
    public static HashMap<Player, ArrayList<Block>> tptoggle = new HashMap();
    public static HashMap<String, Location> back = new HashMap<>();
    public EFMR_Lists lists;

    public static boolean muffledBlowup(Player player)
    {
        return player.getWorld().createExplosion(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 10.0F, false, false);
    }

    public static void killPlayer(Player player)
    {
        player.setHealth(0.0D);
    }

    public static int fakeKillPlayer(Player player)
    {
        return Bukkit.broadcastMessage(player.getName() + " was killed by an admin");
    }

    public static String setLoginMessage(CommandSender sender, String loginmsg)
    {
        TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        return entry.setCustomLoginMessage(loginmsg);
    }
}
