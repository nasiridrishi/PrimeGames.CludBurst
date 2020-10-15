package net.primegames.kitpvp.listener;

import net.primegames.kitpvp.Kitpvp;
import net.primegames.kitpvp.KitpvpPlayer;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerCreationEvent;

public class KitpvpCustomPlayerListener implements Listener {
    public KitpvpCustomPlayerListener() {
        Kitpvp.getInstance().getLogger().info("Registered new Listener" + this.getClass().toString());
    }
    public void onCreation(PlayerCreationEvent event){
        event.setPlayerClass(KitpvpPlayer.class);
    }
}
