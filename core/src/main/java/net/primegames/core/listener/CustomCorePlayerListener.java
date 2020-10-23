/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.listener;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerCreationEvent;


public class CustomCorePlayerListener {

    @Listener()
    public void onPlayerCreation(PlayerCreationEvent event) {
        event.setPlayerClass(CorePlayer.class);
    }
}
