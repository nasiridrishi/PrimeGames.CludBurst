/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.providor.task.player.punishment;

import net.primegames.providor.MySQLPostQueryTask;
import org.sql2o.converters.ConverterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

final public class MySQLPardonPlayerTask extends MySQLPostQueryTask {
    @Override
    protected PreparedStatement preparedStatement(Connection connection) throws SQLException, ConverterException {
        return null;
    }
}
