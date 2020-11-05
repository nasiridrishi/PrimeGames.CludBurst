/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.listener;

import net.primegames.kitpvp.KitpvpPlayer;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerJoinEvent;
import org.cloudburstmc.server.plugin.Plugin;

import java.lang.reflect.Array;

public class ScoreBoardListener {

    @Listener
    public void onJoin(PlayerJoinEvent event){
        KitpvpPlayer player = KitpvpPlayer.cast(event.getPlayer());
    }


}
