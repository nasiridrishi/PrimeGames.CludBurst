/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.provider.player;

import net.primegames.core.providor.MySQLPostQueryTask;
import org.sql2o.converters.ConverterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KitPvPPlayerRegisterTask extends MySQLPostQueryTask {
    @Override
    protected PreparedStatement preparedStatement(Connection connection) throws SQLException, ConverterException {
        return null;
    }
}
