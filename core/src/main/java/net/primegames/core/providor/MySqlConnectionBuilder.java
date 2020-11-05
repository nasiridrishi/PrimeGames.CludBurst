/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor;

import net.primegames.core.Core;
import net.primegames.core.Utils.LoggerUtils;
import org.cloudburstmc.server.utils.Config;

import java.sql.*;

public class MySqlConnectionBuilder{

    private Connection connection;

    public MySqlConnectionBuilder(){
        open(Core.getInstance().getCorePlugin().getDefaultConfig());
    }

    protected void open(Config config) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUri = "jdbc:mysql://" + config.getString("mysql.host") + ":" + config.getString("mysql.port", "3306") + "/" + config.getString("mysql.database") + "?autoReconnect=true&useGmtMillisForDatetimes=true&serverTimezone=GMT";
            connection = DriverManager.getConnection(connectionUri, config.getString("mysql.username"), config.getString("mysql.password"));
            connection.setAutoCommit(true);
            LoggerUtils.info("Mysql Connection successfully established");
        } catch (SQLException ex) {
            Core.getInstance().getLogger().error("Could not Establish connection with MySQL database");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Core.getInstance().getLogger().error("MySQL Driver is missing.. Needs dblib");
            ex.printStackTrace();
        }
    }

    public void close() throws SQLException {
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }
}
