/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerLoginEvent;
import net.primegames.Core;
import net.primegames.CorePlayer;
import net.primegames.providor.task.player.PlayerLoadTask;

public class SessionListener implements Listener {

    @EventHandler
    public void onPlayerPreLogin(PlayerLoginEvent event){
        Core.getInstance().getMySQLProvider().scheduleTask(new PlayerLoadTask((CorePlayer)event.getPlayer()));
    }
}
