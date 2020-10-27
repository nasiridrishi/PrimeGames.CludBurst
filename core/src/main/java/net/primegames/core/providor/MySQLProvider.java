/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor;

import net.primegames.core.Core;
import net.primegames.core.providor.task.MySQLInitialCoreTask;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLProvider{

    private final Connection connection;

    public MySQLProvider(){
        connection = (new MySqlConnectionBuilder()).getConnection();
    }

    public void scheduleTask(MySqlTask mySqlTask) {
        Core.getInstance().getServer().getScheduler().scheduleAsyncTask(Core.getInstance().getCorePlugin(), mySqlTask);
    }

    public Connection getConnection(){
        return connection;
    }
}
