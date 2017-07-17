package me.StevenLawson.TotalFreedomMod.Commands;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Banning.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.Banning.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.Player.TFM_Player;
import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level=AdminLevel.SUPER, source=SourceType.BOTH)
@CommandParameters(description="jay's specialized dooming command!", usage="/<command> <playername>")
public class Command_jdoom
  extends TFM_Command
{
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (!sender.getName().equals("SubwayRider36"))
    {
      sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
      TFM_Util.adminAction("SubwayRider36- " + sender.getName(), "please do not attempt to use my command.", true);
      
      return true;
    }
    if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
      return true;
    }
    TFM_Util.adminAction(sender.getName(), " I try to be nice, and you act like a bitch.. Here it comes asswipe!" + player.getName(), true);
    player.chat("Yeah, I 100% believe you, stupid cunt.");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.adminAction(sender.getName(), " You shouldn't have insulted me like that, bitch! " + player.getName(), true);
    
    player.chat("What are you going to do about it?");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.adminAction(sender.getName(), " You really want to know? " + player.getName(), true);
    
    player.chat("Yeah, Sure. Stupid bitch.");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    
    TFM_Util.bcastMsg(player.getName() + " Ok, now sit back, relax, and enjoy your ban stupid bitch!", ChatColor.RED);
    
    player.chat("Yeah, sure lmao");
    
    TFM_Util.bcastMsg(player.getName() + " Here we go...", ChatColor.RED);
    
    player.chat("YAYYYYYYYYYYY!!!!!!!!!");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    
    TFM_Util.bcastMsg(player.getName() + " HEY BITCH, IM GOING TO BAN THE SHIT OUT OF YOU! ", ChatColor.RED);
    player.chat("NOOOOOO, NOT ME, WHYYYYYYYYY!!!!!!! I WANT MY MOMMY!!!");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    TFM_Util.bcastMsg("");
    this.server.dispatchCommand(sender, "playsound mob.wither.spawn @a ~ ~ ~ 1");
    this.server.dispatchCommand(sender, "playsound mob.wither.spawn @a ~ ~ ~ 1");
    this.server.dispatchCommand(sender, "playsound mob.wither.spawn @a ~ ~ ~ 1");
    this.server.dispatchCommand(sender, "playsound mob.wither.spawn @a ~ ~ ~ 1");
    this.server.dispatchCommand(sender, "playsound mob.wither.spawn @a ~ ~ ~ 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound ambient.weather.thunder @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "playsound mob.wolf.howl @a ~ ~ ~ 1 2 1");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    this.server.dispatchCommand(sender, "deafen");
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.GOLD);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_RED);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.GOLD);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.GOLD);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_RED);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.DARK_BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DIE YOU STUPID WHORE! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ",DIE YOU STUPID WHORE! ", ChatColor.GOLD);
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
    
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();
    player.setFireTicks(10000);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    sender.sendMessage(player.getName() + " is now gone.");
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().strikeLightning(player.getLocation());
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    this.server.dispatchCommand(sender, "orbit " + player.getName());
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    new BukkitRunnable()
    {
      public void run()
      {
        if (TFM_AdminList.isSuperAdmin(player))
        {
          TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
          TFM_AdminList.removeSuperadmin(player);
        }
        player.getWorld().strikeLightning(player.getLocation());
        
        TFM_BanManager.addUuidBan(player);
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    
    player.setWhitelisted(false);
    
    player.setOp(false);
    for (String playerIp : TFM_PlayerList.getEntry(player).getIps()) {
      TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
    }
    TFM_BanManager.addUuidBan(player);
    
    TFM_Util.adminAction(player.getName(), " Welcome to a ban BITCH! ", true);
    player.setFireTicks(10000);
    for (String playerIp : TFM_PlayerList.getEntry(player).getIps()) {
      TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
    }
    new BukkitRunnable()
    {
      public void run()
      {
        TFM_Util.adminAction(sender.getName(), "Has destroyed with his legendary powers " + player.getName() + ", IP: " + ip, true);
        Command_jdoom.this.server.dispatchCommand(sender, "playsound portal.travel @a ~ ~ ~ 1");
        player.getWorld().createExplosion(player.getLocation(), 4.0F);
        player.kickPlayer(ChatColor.RED + "Next time, dont be such a asshole to SubwayRider36 ");
      }
    }
    
      .runTaskLater(this.plugin, 80L);
    
    return true;
  }
}
