package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class EFMR_HomesAPI
        extends EFMR_PlayerAPI
{
    String h1 = "homes.";
    String h2 = ".location.";

    public EFMR_HomesAPI(Player player)
    {
        super(player);
    }

    public boolean set(String s, Location location)
    {
        return setHome(s, location);
    }

    public boolean get(String s)
    {
        return getHome(s) != null;
    }

    public boolean remove(String s)
    {
        return delHome(s);
    }

    public boolean teleport(String s)
    {
        if (getHome(s) == null)
        {
            return false;
        }
        getPlayer().teleport(getHome(s));
        return true;
    }

    public void list()
    {
        getPlayerData().reloadYaml();
        ArrayList<String> list = new ArrayList();
        try
        {
            list.addAll(getPlayerData().getYaml().getConfigurationSection("homes").getKeys(false));
        }
        catch (Exception e)
        {
            list = null;
        }
        if (list == null)
        {
            getPlayer().sendMessage(EFMR_API.color("§4§lEXPLODINGFreedom§e: §cERROR: No home set."));
            return;
        }
        String homes = String.join("&8, &7", list);
        if (homes.length() == 0)
        {
            getPlayer().sendMessage(EFMR_API.color("§4§lEXPLODINGFreedom§e: §cERROR: No home set."));
            return;
        }
        getPlayer().sendMessage(EFMR_API.color(String.format("§4§lEXPLODINGFreedom§e: §bYour Homes:§f %s", new Object[]
        {
            homes
        })));
    }

    public List listAll()
    {
        getPlayerData().reloadYaml();
        ArrayList<String> list = new ArrayList();
        try
        {
            list.addAll(getPlayerData().getYaml().getConfigurationSection("homes").getKeys(false));
        }
        catch (Exception e)
        {
            list = null;
        }
        if (list == null)
        {
            return null;
        }
        return list;
    }

}
