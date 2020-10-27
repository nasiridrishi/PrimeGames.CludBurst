package net.primegames.kitpvp.listener;

import net.primegames.core.Core;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.kit.KitIds;
import net.primegames.kitpvp.Kitpvp;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerDeathEvent;
import org.cloudburstmc.server.event.player.PlayerJoinEvent;
import org.cloudburstmc.server.event.player.PlayerRespawnEvent;
import org.cloudburstmc.server.player.Player;

public class PlayerKitListener {

    @Listener
    public void onJoin(PlayerJoinEvent event){
        setClassicKit(event.getPlayer());
    }

    @Listener
    public void onDeath(PlayerDeathEvent event){
        event.setDrops(null);
    }

    @Listener
    public void onRespawn(PlayerRespawnEvent event){
        setClassicKit(event.getPlayer());
    }

    private void setClassicKit(Player player){
        Kitpvp.getInstance().getCore().getKitFactory().getKit(KitIds.classicKit).addTo(player);
    }
}
