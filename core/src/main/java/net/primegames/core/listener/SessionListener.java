/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.listener;

import net.primegames.core.Core;
import net.primegames.core.CorePlayer;
import net.primegames.core.providor.task.player.PlayerLoadTask;
import org.cloudburstmc.server.event.EventHandler;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerLoginEvent;

public class SessionListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerPreLogin(PlayerLoginEvent event){
        Core.getInstance().getMySQLProvider().scheduleTask(new PlayerLoadTask((CorePlayer)event.getPlayer()));
    }
}
