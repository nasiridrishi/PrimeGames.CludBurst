/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MySqlFetchQueryTask extends MySqlTask {

    @Override
    public void onRun() {
        ResultSet rs = null;
        try {
            rs = preparedStatement(getConnection()).executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        if(rs != null){
            try {
                handleResult(rs);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }else{
            throw new RuntimeException("Could not load player data from Database since resultSet returned null");
        }
    }

    protected abstract PreparedStatement preparedStatement(Connection connection) throws SQLException;

    protected abstract void handleResult(ResultSet resultSet) throws SQLException;

}
