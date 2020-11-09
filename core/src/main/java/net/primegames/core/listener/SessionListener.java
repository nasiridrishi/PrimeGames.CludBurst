/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerLoginEvent;
import net.primegames.core.Core;
import net.primegames.core.CorePlayer;
import net.primegames.core.providor.task.player.PlayerLoadTask;

public class SessionListener implements Listener {

    @EventHandler
    public void onPlayerPreLogin(PlayerLoginEvent event){
        Core.getInstance().getMySQLProvider().scheduleTask(new PlayerLoadTask((CorePlayer)event.getPlayer()));
    }
}
