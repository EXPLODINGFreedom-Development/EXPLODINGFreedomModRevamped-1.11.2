package me.StevenLawson.TotalFreedomMod.Listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import java.lang.reflect.Field;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_11_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TFM_PlayerTabListener implements Listener
{
    private ProtocolManager protocolManager;

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        sendTablistHeaderAndFooter(e.getPlayer(),
                "§4§l>§1§l-§4§l>§eWelcome to §4EXPLODINGFreedom §bAll-OP§e!§4§l<§1§l-§4l",
                "§c§kiii§eInvite your friends using §bplay.explodingfreedom.us.to§e!§c§kiii");
    }

    @EventHandler
    public void sendTablistHeaderAndFooter(Player p, String header, String footer)
    {
        if (header == null)
        {
            header = "";
        }
        if (footer == null)
        {
            footer = "";
        }

        IChatBaseComponent tabHeader = ChatSerializer.a("{\"text\":\"" + header + "\"}");
        IChatBaseComponent tabFooter = ChatSerializer.a("{\"text\":\"" + footer + "\"}");

        PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
        try
        {
            Field field = headerPacket.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(headerPacket, tabFooter);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(headerPacket);
        }
    }
}
