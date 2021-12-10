/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.providor;

import net.primegames.Core;

import java.sql.Connection;

public class MySQLProvider{

    private final Connection connection;

    public MySQLProvider(){
        connection = (new MySqlConnectionBuilder()).getConnection();
    }

    public void scheduleTask(MySqlTask mySqlTask) {
        Core.getInstance().getServer().getScheduler().scheduleAsyncTask(Core.getInstance().getPlugin(), mySqlTask);
    }

    public Connection getConnection(){
        return connection;
    }
}
