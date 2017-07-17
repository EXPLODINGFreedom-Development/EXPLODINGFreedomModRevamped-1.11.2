package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlayerExtension
{
  protected Player base;
  
  public PlayerExtension(Player base)
  {
    this.base = base;
  }
  
  public final Player getBase()
  {
    return this.base;
  }
  
  public final Player setBase(Player base)
  {
    return this.base = base;
  }
  
  public Server getServer()
  {
    return this.base.getServer();
  }
  
  public World getWorld()
  {
    return this.base.getWorld();
  }
  
  public Location getLocation()
  {
    return this.base.getLocation();
  }
}
