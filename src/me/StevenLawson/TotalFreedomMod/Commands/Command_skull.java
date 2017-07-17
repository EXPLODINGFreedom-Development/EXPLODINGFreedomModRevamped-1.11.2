package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Give yourself a skull of someone.", usage = "/<command> <player>")
public class Command_skull extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bUsage: /skull <playername> ");
        }
        Player p = (Player) sender;
        PlayerInventory pi = p.getInventory();
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(args[0]);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.RESET);
        skull.setItemMeta(meta);
        pi.addItem(new ItemStack[]
        {
            skull
        });
        sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §bYou were given the skull of §c" + args[0] + "§b.");
        return true;
    }
}
