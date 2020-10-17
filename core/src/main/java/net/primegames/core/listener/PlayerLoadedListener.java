/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.listener;

import net.primegames.core.Core;
import net.primegames.core.event.player.CorePlayerLoadedEvent;
import net.primegames.core.providor.task.player.punishment.MySQLCheckPlayerPunishmentTask;
import org.cloudburstmc.server.event.EventHandler;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;

public class PlayerLoadedListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onLoaded(CorePlayerLoadedEvent event){
        Core.getInstance().getMySQLProvider().scheduleTask(new MySQLCheckPlayerPunishmentTask(event.getPlayer()));
    }
}
