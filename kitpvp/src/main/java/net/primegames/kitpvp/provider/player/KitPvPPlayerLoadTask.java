/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.provider.player;

import net.primegames.core.providor.MySqlFetchQueryTask;
import net.primegames.kitpvp.Kitpvp;
import net.primegames.kitpvp.KitpvpPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class KitPvPPlayerLoadTask extends MySqlFetchQueryTask {

    private final UUID uuid;

    private final KitpvpPlayer player;

    public KitPvPPlayerLoadTask(KitpvpPlayer player){
        this.player = player;
        uuid = player.getUniqueId();
    }

    @Override
    protected PreparedStatement preparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT kitpvp_users.*, " +
                "kitpvp_user_stats.*" +
                "FROM kitpvp_users LEFT JOIN kitpvp_user_stats ON kitpvp_user_stats.user_id = kitpvp_users.id " +
                "WHERE kitpvp_users.id = ? " +
                "LIMIT 1");
        statement.setInt(1, player.getCoreDataStore().getInternalId());
        return statement;
    }

    @Override
    protected void handleResult(ResultSet resultSet) throws SQLException {
        if(verifyPlayer(uuid)){
            if(resultSet.next()){

            }
        }
    }
}
