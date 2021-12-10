/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.providor;

import net.primegames.Utils.LoggerUtils;

import java.sql.SQLException;
import java.sql.Statement;

abstract public class MySQLInitialTask extends MySqlTask {

    public abstract void getInitTableQuery(Statement statement) throws SQLException;

    @Override
    public void onRun() {
        Statement statement;
        try {
            statement = getConnection().createStatement();
            getInitTableQuery(statement);
        }catch (SQLException exception){
            LoggerUtils.error("Failed to initialize database tables");
            exception.getStackTrace();
        }
    }
}
