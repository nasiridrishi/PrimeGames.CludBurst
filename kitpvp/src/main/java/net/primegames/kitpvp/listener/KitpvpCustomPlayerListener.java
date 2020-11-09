package net.primegames.kitpvp.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCreationEvent;
import net.primegames.kitpvp.KitpvpPlayer;

public class KitpvpCustomPlayerListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCreation(PlayerCreationEvent event){
        event.setPlayerClass(KitpvpPlayer.class);
    }
}
