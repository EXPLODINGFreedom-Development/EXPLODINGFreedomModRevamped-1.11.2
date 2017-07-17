package me.StevenLawson.TotalFreedomMod.Listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TFM_PlayerTabListener implements Listener
{
    private ProtocolManager protocolManager;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        PacketContainer pc = this.protocolManager.createPacket(PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER);

        pc.getChatComponents().write(0, WrappedChatComponent.fromText(fixColors("&4&l>&1&l-&4&l>&eWelcome to &4EXPLODINGFreedom &bAll-OP&e!&4&l<&1&l-&4&l<")))
                .write(1, WrappedChatComponent.fromText(fixColors("&c&kiii&eInvite your friends using &bexplodingfreedom.fadehost.com&e!&c&kiii")));
        try
        {
            this.protocolManager.sendServerPacket(e.getPlayer(), pc);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private String fixColors(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
