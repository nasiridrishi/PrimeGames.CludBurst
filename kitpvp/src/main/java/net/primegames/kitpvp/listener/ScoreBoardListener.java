/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import net.primegames.kitpvp.KitpvpPlayer;

import java.lang.reflect.Array;

public class ScoreBoardListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        KitpvpPlayer player = KitpvpPlayer.cast(event.getPlayer());
    }


}
