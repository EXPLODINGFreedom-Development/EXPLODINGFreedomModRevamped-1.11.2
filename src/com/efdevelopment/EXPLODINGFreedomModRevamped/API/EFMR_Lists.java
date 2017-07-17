package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import java.util.ArrayList;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.entity.Player;

public class EFMR_Lists
{
  private TotalFreedomMod core;
  private ArrayList<String> allowedSigns = new ArrayList();
  private boolean debugSigns = false;
  private ArrayList<Player> vanishedPlayers = new ArrayList();
  private ArrayList<String> limitHomes = new ArrayList();
  
  public EFMR_Lists(TotalFreedomMod core)
  {
    this.core = core;
  }
  
  public void startup()
  {
    reload();
    loadVanishedPlayers();
    loadLimitHomes();
  }
  
  public void reload()
  {
    this.allowedSigns.clear();
    this.allowedSigns.addAll(this.core.getConfig().getStringList("allowed-signs"));
    this.debugSigns = this.core.getConfig().getBoolean("debug-signs");
  }
  
  public void loadVanishedPlayers()
  {
    try
    {
      this.vanishedPlayers.clear();
      for (Player player : this.core.getServer().getOnlinePlayers())
      {
        EFMR_PlayerAPI playerAPI = new EFMR_PlayerAPI(player);
        if (playerAPI.getVanished()) {
          this.vanishedPlayers.add(player);
        }
      }
    }
    catch (NullPointerException localNullPointerException1) {}catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void loadLimitHomes()
  {
    try
    {
      this.limitHomes.clear();
      if (this.core.getConfig().getConfigurationSection("limit-homes") != null) {
        this.limitHomes.addAll(this.core.getConfig().getConfigurationSection("limit-homes").getKeys(false));
      }
    }
    catch (NullPointerException localNullPointerException) {}catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public boolean isDebugSigns()
  {
    return this.debugSigns;
  }
  
  public ArrayList<String> getAllowedSigns()
  {
    return this.allowedSigns;
  }
  
  public ArrayList<String> getLimitHomes()
  {
    return this.limitHomes;
  }
  
  public ArrayList<Player> getVanishedPlayers()
  {
    return this.vanishedPlayers;
  }
  
  public void addVanishedPlayers(Player player)
  {
    this.vanishedPlayers.add(player);
  }
  
  public void removeVanishedPlayers(Player player)
  {
    this.vanishedPlayers.remove(player);
  }
}
