/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor;

import org.cloudburstmc.server.scheduler.AsyncTask;
import org.sql2o.converters.ConverterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MySQLPostQueryTask extends MySqlTask {
    @Override
    public void onRun() {
        try {
            PreparedStatement statement = preparedStatement(getConnection());
            int resultSet = statement.executeUpdate();
            if(resultSet == 0){
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if(generatedKeys.next()){
                    onInsert(generatedKeys.getInt(1));
                }
                else{
                    throw new SQLException("User registration failed because ID was not obtained");
                }
            }
        } catch (SQLException | ConverterException exception) {
            exception.printStackTrace();
        }
    }

    protected abstract PreparedStatement preparedStatement(Connection connection) throws SQLException, ConverterException;

    protected void onInsert(int Id){}

}
