package net.primegames.kitpvp.listener;

import net.primegames.core.Utils.LoggerUtils;
import net.primegames.kitpvp.Kitpvp;
import net.primegames.kitpvp.KitpvpPlayer;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerCreationEvent;

public class KitpvpCustomPlayerListener{

    @Listener(priority = EventPriority.HIGHEST)
    public void onCreation(PlayerCreationEvent event){
        event.setPlayerClass(KitpvpPlayer.class);
    }
}
