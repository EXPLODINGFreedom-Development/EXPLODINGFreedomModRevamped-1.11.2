package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Make fireworks.", usage = "/<command>")
public class Command_firework extends TFM_Command
{
    private Color getColor(int i)
    {
        Color c = null;
        if (i == 1)
        {
            c = Color.AQUA;
        }
        if (i == 2)
        {
            c = Color.BLACK;
        }
        if (i == 3)
        {
            c = Color.BLUE;
        }
        if (i == 4)
        {
            c = Color.FUCHSIA;
        }
        if (i == 5)
        {
            c = Color.GRAY;
        }
        if (i == 6)
        {
            c = Color.GREEN;
        }
        if (i == 7)
        {
            c = Color.LIME;
        }
        if (i == 8)
        {
            c = Color.MAROON;
        }
        if (i == 9)
        {
            c = Color.NAVY;
        }
        if (i == 10)
        {
            c = Color.OLIVE;
        }
        if (i == 11)
        {
            c = Color.ORANGE;
        }
        if (i == 12)
        {
            c = Color.PURPLE;
        }
        if (i == 13)
        {
            c = Color.RED;
        }
        if (i == 14)
        {
            c = Color.SILVER;
        }
        if (i == 15)
        {
            c = Color.TEAL;
        }
        if (i == 16)
        {
            c = Color.WHITE;
        }
        if (i == 17)
        {
            c = Color.YELLOW;
        }
        return c;
    }

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player p = (Player) sender;
        HumanEntity player = p;
        if (args.length != 0)
        {
            sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom§e: §cUsage: /firework");
        }
        Firework firework = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwm = firework.getFireworkMeta();

        Random r = new Random();

        int rt = r.nextInt(4) + 1;
        FireworkEffect.Type type = FireworkEffect.Type.BALL;
        if (rt == 1)
        {
            type = FireworkEffect.Type.BALL;
        }
        if (rt == 2)
        {
            type = FireworkEffect.Type.BALL_LARGE;
        }
        if (rt == 3)
        {
            type = FireworkEffect.Type.BURST;
        }
        if (rt == 4)
        {
            type = FireworkEffect.Type.CREEPER;
        }
        if (rt == 5)
        {
            type = FireworkEffect.Type.STAR;
        }
        int r1i = r.nextInt(17) + 1;
        int r2i = r.nextInt(17) + 1;
        Color c1 = getColor(r1i);
        Color c2 = getColor(r2i);

        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();

        fwm.addEffect(effect);

        int rp = r.nextInt(5) + 1;
        fwm.setPower(rp);

        firework.setFireworkMeta(fwm);
        return true;
    }
}
