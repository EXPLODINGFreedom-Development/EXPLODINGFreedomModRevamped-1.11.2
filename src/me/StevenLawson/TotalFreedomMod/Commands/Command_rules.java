package me.StevenLawson.TotalFreedomMod.Commands;

import com.earth2me.essentials.textreader.IText;
import com.earth2me.essentials.textreader.KeywordReplacer;
import com.earth2me.essentials.textreader.TextInput;
import com.earth2me.essentials.textreader.TextPager;
import java.io.File;
import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditBridge;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "View the server rules.", usage = "/<command>")
public class Command_rules extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        playerMsg("§e------------§4§lEXPLODINGFreedom Rules§e------------", ChatColor.GOLD);
        playerMsg("§7These are the server rules. Failure to follow them can result in punishments. Extreme or multiple rule violations can result in §cunappealable permanent ban §7if decided so. Make sure you comply with these rules before gameplay.", ChatColor.GOLD);
        sender.sendMessage(ChatColor.AQUA + "§4§l[1] " + TFM_ConfigEntry.RULES_RULE1.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[2] " + TFM_ConfigEntry.RULES_RULE2.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[3] " + TFM_ConfigEntry.RULES_RULE3.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[4] " + TFM_ConfigEntry.RULES_RULE4.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[5] " + TFM_ConfigEntry.RULES_RULE5.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[6] " + TFM_ConfigEntry.RULES_RULE6.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[7] " + TFM_ConfigEntry.RULES_RULE7.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[8] " + TFM_ConfigEntry.RULES_RULE8.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[9] " + TFM_ConfigEntry.RULES_RULE9.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[10] " + TFM_ConfigEntry.RULES_RULE10.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[11] " + TFM_ConfigEntry.RULES_RULE11.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[12] " + TFM_ConfigEntry.RULES_RULE12.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[13] " + TFM_ConfigEntry.RULES_RULE13.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[14] " + TFM_ConfigEntry.RULES_RULE14.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[15] " + TFM_ConfigEntry.RULES_RULE15.getString());
        sender.sendMessage(ChatColor.AQUA + "§4§l[16] " + TFM_ConfigEntry.RULES_RULE16.getString());
        playerMsg("§cMake sure to follow these rules, otherwise punishment may follow!", ChatColor.AQUA);
        return true;

    }
}
