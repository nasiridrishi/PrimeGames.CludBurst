package net.primegames.kitpvp.listener;

import net.primegames.core.Core;
import net.primegames.core.kit.KitIds;
import net.primegames.kitpvp.Kitpvp;
import org.cloudburstmc.server.event.EventHandler;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerDeathEvent;
import org.cloudburstmc.server.event.player.PlayerJoinEvent;
import org.cloudburstmc.server.event.player.PlayerRespawnEvent;
import org.cloudburstmc.server.player.Player;

public class PlayerKitListener implements Listener {

    public PlayerKitListener(){
        Kitpvp.getInstance().getLogger().info("Registered new Listener" + this.getClass().toString());
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        setClassicKit(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onDeath(PlayerDeathEvent event){
        event.setDrops(null);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onRespawn(PlayerRespawnEvent event){
        setClassicKit(event.getPlayer());
    }

    private void setClassicKit(Player player){
        Core.getInstance().getKitFactory().getKit(KitIds.classicKit).addTo(player);
    }
}
