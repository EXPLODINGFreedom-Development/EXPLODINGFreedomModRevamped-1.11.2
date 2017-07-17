package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import com.efdevelopment.EXPLODINGFreedomModRevamped.API.EFMR_API;
import com.efdevelopment.EXPLODINGFreedomModRevamped.Utils.EFMR_DataFile;
import java.util.ArrayList;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class EFMR_WarpAPI
{
    private TotalFreedomMod plugin;
    private EFMR_DataFile data;
    private String w1 = "warps.";
    private String w2 = ".location.";
    private String w3 = ".permission";
    private String w4 = "esscore.warps.";

    public EFMR_WarpAPI(TotalFreedomMod plugin)
    {
        this.plugin = plugin;
        this.data = new EFMR_DataFile(plugin, "warps");
    }

    private boolean setters(String name, Location location)
    {
        name = name.replace(".", "-");
        if (this.data.isSet(this.w1 + name))
        {
            return false;
        }
        this.data.set(this.w1 + name + this.w2 + "World", location.getWorld().getName());
        this.data.set(this.w1 + name + this.w2 + "X", Double.valueOf(location.getX()));
        this.data.set(this.w1 + name + this.w2 + "Y", Double.valueOf(location.getY()));
        this.data.set(this.w1 + name + this.w2 + "Z", Double.valueOf(location.getZ()));
        this.data.set(this.w1 + name + this.w2 + "Yaw", Float.valueOf(location.getYaw()));
        this.data.set(this.w1 + name + this.w2 + "Pitch", Float.valueOf(location.getPitch()));
        return true;
    }

    public boolean create(String name, Location location, boolean permission)
    {
        name = name.toLowerCase();
        this.data.reloadConfig();
        if (!setters(name, location))
        {
            return false;
        }
        if (permission)
        {
            this.data.set(this.w1 + name + this.w3, name);
        }
        this.data.saveConfig();
        return true;
    }

    public boolean remove(String name)
    {
        name = name.toLowerCase();
        this.data.reloadConfig();
        if (this.data.sectionExists(this.w1 + name))
        {
            this.data.set(this.w1 + name, null);
            this.data.saveConfig();
            return true;
        }
        return false;
    }

    public void reload()
    {
        this.data.reloadConfig();
    }

    private Location getLocation(String name)
    {
        World world = this.plugin.getServer().getWorld(this.data.getString(this.w1 + name + this.w2 + "World"));
        Double x = Double.valueOf(this.data.getDouble(this.w1 + name + this.w2 + "X"));
        Double y = Double.valueOf(this.data.getDouble(this.w1 + name + this.w2 + "Y"));
        Double z = Double.valueOf(this.data.getDouble(this.w1 + name + this.w2 + "Z"));
        Float yaw = Float.valueOf(this.data.getFloat(this.w1 + name + this.w2 + "Yaw"));
        Float pitch = Float.valueOf(this.data.getFloat(this.w1 + name + this.w2 + "Pitch"));
        return new Location(world, x.doubleValue(), y.doubleValue(), z.doubleValue(), yaw.floatValue(), pitch.floatValue());
    }

    public void teleport(String name, Player player)
    {
        name = name.toLowerCase();
        this.data.reloadConfig();
        if (this.data.sectionExists(this.w1 + name))
        {
            if (this.data.isSet(this.w1 + name + this.w3))
            {
                if (player.hasPermission(this.w4 + this.data.getString(new StringBuilder().append(this.w1).append(name).append(this.w3).toString())))
                {
                    player.teleport(getLocation(name));
                    player.sendMessage(EFMR_API.color(String.format("§4§lEXPLODINGFreedom§e: §bWarping to §c%s§b.", new Object[]
                    {
                        name
                    })));
                }
                else
                {
                    player.sendMessage(EFMR_API.color("§4§lEXPLODINGFreedom§e: §CError: No permissions."));
                }
            }
            else
            {
                player.teleport(getLocation(name));
                player.sendMessage(EFMR_API.color(String.format("§4§lEXPLODINGFreedom§e: §bWarping to §c%s§b.", new Object[]
                {
                    name
                })));
            }
        }
        else
        {
            player.sendMessage(EFMR_API.color("§4§lEXPLODINGFreedom§e: §cError: That warp does not exist."));
        }
    }

    public void teleport(String name, CommandSender sender, Player player)
    {
        name = name.toLowerCase();
        this.data.reloadConfig();
        if (this.data.sectionExists(this.w1 + name))
        {
            if (this.data.isSet(this.w1 + name + this.w3))
            {
                if (sender.hasPermission(this.w4 + this.data.getString(new StringBuilder().append(this.w1).append(name).append(this.w3).toString())))
                {
                    player.teleport(getLocation(name));
                    player.sendMessage(EFMR_API.color(String.format("§4§lEXPLODINGFreedom§e: §b%s has warped you to §c%s§b.", new Object[]
                    {
                        EFMR_API.getSenderDisplayName(this.plugin, sender), name
                    })));
                    if (sender != player)
                    {
                        sender.sendMessage(EFMR_API.color(String.format("§4§lEXPLODINGFreedom§e: §b%s has been warped to §c%s§b.", new Object[]
                        {
                            player.getName(), name
                        })));
                    }
                }
                else
                {
                    player.sendMessage(EFMR_API.color("§4§lEXPLODINGFreedom§e: §CError: No permissions."));
                }
            }
            else
            {
                player.teleport(getLocation(name));
                player.sendMessage(EFMR_API.color(String.format("§4§lEXPLODINGFreedom§e: §b%s has warped you to §c%s§b.", new Object[]
                {
                    EFMR_API.getSenderDisplayName(this.plugin, sender), name
                })));
                if (sender != player)
                {
                    sender.sendMessage(EFMR_API.color(String.format("§4§lEXPLODINGFreedom§e: §b%s has been warped to §c%s§b.", new Object[]
                    {
                        player.getName(), name
                    })));
                }
            }
        }
        else
        {
            sender.sendMessage(EFMR_API.color("&c&lWooh! &7that warp doesn't exist!"));
        }
    }

    public void list(CommandSender commandSender)
    {
        this.data.reloadConfig();
        ArrayList<String> list = new ArrayList();
        try
        {
            for (String warp : this.data.getConfigurationSection("warps").getKeys(false))
            {
                if (this.data.isSet(this.w1 + warp + this.w3))
                {
                    if (commandSender.hasPermission(this.w4 + this.data.getString(new StringBuilder().append(this.w1).append(warp).append(this.w3).toString())))
                    {
                        list.add(warp);
                    }
                }
                else
                {
                    list.add(warp);
                }
            }
        }
        catch (Exception e)
        {
            list = null;
        }
        if (list == null)
        {
            commandSender.sendMessage(EFMR_API.color("&c&lOops! &7seems like there are no warps ;*("));
            return;
        }
        String warps = String.join("&8, &7", list);
        if (warps.length() == 0)
        {
            commandSender.sendMessage(EFMR_API.color("&c&l&c&lSorry! &7there are no warps available."));
            return;
        }
        commandSender.sendMessage(EFMR_API.color(String.format("&a&lAvailable warps&8: &7%s", new Object[]
        {
            warps
        })));
    }

    public List list()
    {
        this.data.reloadConfig();
        ArrayList<String> list = new ArrayList();
        try
        {
            list.addAll(this.data.getConfigurationSection("warps").getKeys(false));
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
