/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor.task.player;

import net.primegames.core.CorePlayer;
import net.primegames.core.Utils.Utils;
import net.primegames.core.player.CorePlayerDatabaseData;
import net.primegames.core.providor.MySQLPostQueryTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerUpdateTask extends MySQLPostQueryTask {

    private UUID uuid;
    private String username;
    private CorePlayer player;
    private String ip;

    public PlayerUpdateTask(CorePlayer player){
        player.setStatus(player.STATUS_UPDATING);
        this.username = player.getName();
        this.uuid = player.getServerId();
        this.player = player;
        ip = player.getAddress();
    }

    @Override
    protected PreparedStatement preparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("          UPDATE users SET" +
                "            uuid = ?," +
                "            username = ?," +
                "            last_ip = ?," +

                "            reputation = ?," +

                "            locale = ?," +
                "            continent_code = ?," +
                "            country_code = ?," +

                "            common_keys = ?," +
                "            vote_keys = ?," +
                "            rare_keys = ?," +
                "            legendary_keys = ?," +

                "            time_played = ?," +
                "            last_connection_duration = ?," +

                "            warnings = ?," +

                "            last_connection = CURRENT_TIMESTAMP" +
                "            WHERE id = ?");
        CorePlayerDatabaseData db = player.getDatabaseData();
        statement.setBytes(1, Utils.toBinary(uuid));
        statement.setString(2, username);
        statement.setString(3, ip);
        statement.setInt(4, db.getReputation());
        statement.setString(5, db.getLocale());
        statement.setString(6, db.getContinent_code());
        statement.setString(7, db.getCountry_code());
        statement.setInt(8, db.getCommonkeys());
        statement.setInt(9, db.getVoteKeys());
        statement.setInt(10, db.getRareKeys());
        statement.setInt(11, db.getLegendaryKeys());
        statement.setLong(12, db.getTimePlayed());
        statement.setLong(13, db.getLastSessionDuration());

        statement.setInt(14, db.getWarnings());
        statement.setInt(15, db.getInternal_id());

        return statement;
    }

    @Override
    protected void onInsert(int Id) {
        if (verifyPlayer(uuid)){
             player.setStatus(player.STATUS_ONLINE);
        }
    }
}
