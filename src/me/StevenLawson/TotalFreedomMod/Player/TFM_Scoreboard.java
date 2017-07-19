package me.StevenLawson.TotalFreedomMod.Player;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_BuilderList;
import me.StevenLawson.TotalFreedomMod.Rank.TFM_PlayerRank;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import static me.StevenLawson.TotalFreedomMod.TotalFreedomMod.econ;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class TFM_Scoreboard
{

    public static ScoreboardManager manager = Bukkit.getScoreboardManager();

    public static void updateStats(Player player)
    {
        try
        {
            Scoreboard board = manager.getNewScoreboard();
            String name = player.getName();
            Objective o = board.getObjective("stats");
            if (o == null)
            {
                o = board.registerNewObjective("stats", "dummy");
                o.setDisplaySlot(DisplaySlot.SIDEBAR);
                o.setDisplayName(ChatColor.GOLD + "" + ChatColor.MAGIC + "|@|" + ChatColor.BLUE + "Your Info" + ChatColor.GOLD + "" + ChatColor.MAGIC + "|@|");
            }
            String builderstring = "No";
            String djumpstring = "No";
            if (EFMR_BuilderList.isSuperBuilder(player))
            {
                builderstring = "Yes";
            }
            if (TFM_Util.isDoubleJumper(player) == true)
            {
                djumpstring = "Yes";
            }
            else if (TFM_Util.isDoubleJumper(player) == false)
            {
                djumpstring = "No";
            }
            Score rankhead = o.getScore(ChatColor.GOLD + "Your rank: ");
            Score rank = o.getScore(ChatColor.GOLD + " " + TFM_PlayerRank.fromSender(player).getLoginMessage());
            Score builder = o.getScore(ChatColor.GOLD + "Architect: " + ChatColor.RED + builderstring);
            Score djump = o.getScore(ChatColor.GOLD + "D. Jump: " + ChatColor.RED + djumpstring);
            Score level2 = o.getScore(ChatColor.GOLD + "Health: " + ChatColor.RED + player.getHealth());
            long health = Math.round(player.getHealth());
            Score level = o.getScore(ChatColor.GOLD + "Health: "+ ChatColor.RED + String.valueOf(health));
            rankhead.setScore(6);
            rank.setScore(5);
            builder.setScore(4);
            djump.setScore(2);
            level.setScore(1);

            player.setScoreboard(board);
        }
        catch (Exception ex)
        {
            TotalFreedomMod.plugin.handleException(ex);
        }
    }
}
