package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import java.util.UUID;
import java.util.Date;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class EFMR_PlayerAPI
{
    private Player player;
    private UUID uuid;
    private EFMR_PlayerData playerData;
    public boolean l = false;

    public EFMR_PlayerAPI(Player player)
    {
        this.player = player;
        this.uuid = player.getUniqueId();
        this.playerData = new EFMR_PlayerData(this.uuid + ".yml", TotalFreedomMod.getPlugin(TotalFreedomMod.class));
        create();
    }

    private void create()
    {
        if (!isSet("player.unique_id"))
        {
            set("player.unique_id", this.uuid.toString());
            this.l = true;
        }
        if (getString("player.username") != this.player.getName())
        {
            set("player.username", this.player.getName());
        }
        if (!isSet("player.first_join.date"))
        {
            set("player.first_join.date", new Date(this.player.getFirstPlayed() * 1000L).toString());
        }
        if (!isSet("player.first_join.int.Long"))
        {
            set("player.first_join.int.Long", Long.valueOf(this.player.getFirstPlayed()));
        }
    }

    protected boolean isSet(String path)
    {
        return this.playerData.getYaml().isSet(path);
    }

    private boolean getBoolean(String path)
    {
        return this.playerData.getYaml().getBoolean(path);
    }

    private String getString(String path)
    {
        return this.playerData.getYaml().getString(path);
    }

    private double getDouble(String path)
    {
        return this.playerData.getYaml().getDouble(path);
    }

    private float getFloat(String path)
    {
        return (float) getDouble(path);
    }

    private void set(String path, Object value)
    {
        this.playerData.getYaml().set(path, value);
        this.playerData.saveYaml();
    }

    public Player getPlayer()
    {
        return this.player;
    }

    public UUID getUuid()
    {
        return this.uuid;
    }

    protected EFMR_PlayerData getPlayerData()
    {
        return this.playerData;
    }

    boolean toggle(String path)
    {
        this.playerData.modifyYaml();
        if (getBoolean(path))
        {
            set(path, Boolean.valueOf(false));
            return false;
        }
        set(path, Boolean.valueOf(true));
        return true;
    }

    public boolean getFlight()
    {
        this.playerData.modifyYaml();
        return getBoolean("flight");
    }

    public void setFlight(boolean value)
    {
        set("flight", Boolean.valueOf(value));
    }

    public boolean getMuted()
    {
        this.playerData.modifyYaml();
        return getBoolean("muted");
    }

    public void setMuted(boolean value)
    {
        set("muted", Boolean.valueOf(value));
    }

    public boolean getFrozen()
    {
        this.playerData.modifyYaml();
        return getBoolean("frozen");
    }

    public void setFrozen(boolean value)
    {
        set("frozen", Boolean.valueOf(value));
    }

    public boolean getVanished()
    {
        this.playerData.modifyYaml();
        return getBoolean("vanished");
    }

    public void setVanished(boolean value)
    {
        set("vanished", Boolean.valueOf(value));
    }

    public String getNickname()
    {
        this.playerData.modifyYaml();
        return getString("player.nickname") + "&r";
    }

    public boolean getNick()
    {
        return isSet("player.nickname");
    }

    public void setNickname(String value)
    {
        set("player.nickname", value);
    }

    protected boolean setHome(String s, Location location)
    {
        s = s.replace(".", "-");
        if (isSet("homes." + s))
        {
            return false;
        }
        set("homes." + s + ".location.world", location.getWorld().getName());
        set("homes." + s + ".location.X", Double.valueOf(location.getX()));
        set("homes." + s + ".location.Y", Double.valueOf(location.getY()));
        set("homes." + s + ".location.Z", Double.valueOf(location.getZ()));
        set("homes." + s + ".location.Yaw", Float.valueOf(location.getYaw()));
        set("homes." + s + ".location.Pitch", Float.valueOf(location.getPitch()));
        return true;
    }

    protected Location getHome(String s)
    {
        if (!isSet("homes." + s))
        {
            return null;
        }
        String x1 = "homes.";
        String x2 = ".location.";
        return new Location(Bukkit.getWorld(getString(x1 + s + x2 + "world")), getDouble(x1 + s + x2 + "X"), getDouble(x1 + s + x2 + "Y"), getDouble(x1 + s + x2 + "Z"), getFloat(x1 + s + x2 + "Yaw"), getFloat(x1 + s + x2 + "Pitch"));
    }

    protected boolean delHome(String s)
    {
        if (!isSet("homes." + s))
        {
            return false;
        }
        set("homes." + s, null);
        return true;
    }
}
