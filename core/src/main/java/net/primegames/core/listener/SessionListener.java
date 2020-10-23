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
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.providor.task.player.PlayerLoadTask;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerLoginEvent;

public class SessionListener {

    @Listener
    public void onPlayerPreLogin(PlayerLoginEvent event){
        Core.getInstance().getMySQLProvider().scheduleTask(new PlayerLoadTask((CorePlayer)event.getPlayer()));
        LoggerUtils.info("Logged in");
    }
}
