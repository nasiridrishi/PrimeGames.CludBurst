/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor;

import net.primegames.core.Core;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.scheduler.AsyncTask;

import java.sql.Connection;
import java.util.UUID;

public abstract class MySqlTask extends AsyncTask {

    protected Connection getConnection(){
        return Core.getInstance().getMySQLProvider().getConnection();
    }

    protected boolean verifyPlayer(UUID uuid){
        return Server.getInstance().getPlayer(uuid).isPresent();
    }
}
