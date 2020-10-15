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
import org.cloudburstmc.server.event.EventHandler;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerCreationEvent;

public class CustomCorePlayerListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerCreation(PlayerCreationEvent event) {
        event.setPlayerClass(CorePlayer.class);
    }
}
