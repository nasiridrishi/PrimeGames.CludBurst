/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor.task.player;

import net.primegames.core.Core;
import net.primegames.core.CorePlayer;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.event.player.CorePlayerRegisteredEvent;
import net.primegames.core.player.CorePlayerDataStore;
import net.primegames.core.providor.MySQLPostQueryTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;

final public class PlayerRegisterTask extends MySQLPostQueryTask {

    private UUID uuid;
    private String userName;
    private String address;
    private CorePlayer player;

    public PlayerRegisterTask(CorePlayer player){
        uuid = player.getServerId();
        userName = player.getName();
        address = player.getAddress();
        this.player = player;
    }

    @Override
    protected PreparedStatement preparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO users (uuid, username, last_ip) VALUES (UUID_TO_BIN(?), ?, ?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, uuid.toString());
        statement.setString(2, userName);
        statement.setString(3, address);
        return statement;
    }

    @Override
    protected void onInsert(int id) {
        if(verifyPlayer(uuid)){
            player.setDatabaseData(new CorePlayerDataStore(player,
                    id,
                    player.getAddress(),
                    "??",
                    "??",
                    0,
                    0,
                    0,
                    0,
                    new Date(),
                    0,
                    0,
                    0,
                    0,
                    "??"
                    ));
            Core.getInstance().getServer().getEventManager().fire(new CorePlayerRegisteredEvent(player));
            LoggerUtils.debug("new registration successful for " + player.getName());
            player.setStatus(player.STATUS_ONLINE);
        }
    }
}
