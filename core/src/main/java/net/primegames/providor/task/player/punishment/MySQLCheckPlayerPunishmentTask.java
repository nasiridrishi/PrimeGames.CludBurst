/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.providor.task.player.punishment;

import cn.nukkit.utils.TextFormat;
import net.primegames.Utils.LoggerUtils;
import net.primegames.CorePlayer;
import net.primegames.providor.MySqlFetchQueryTask;

import java.sql.*;
import java.util.UUID;


final public class MySQLCheckPlayerPunishmentTask extends MySqlFetchQueryTask {

    private final UUID uuid;

    private final String username;

    private final CorePlayer player;

    public MySQLCheckPlayerPunishmentTask(CorePlayer corePlayer){
        uuid = corePlayer.getUniqueId();
        username = corePlayer.getName();
        player = corePlayer;
    }

    @Override
    protected PreparedStatement preparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT expires_at, issuer, reason, category FROM sentences WHERE (uuid = UUID_TO_BIN(?) AND expires_at IS NULL) OR (uuid = UUID_TO_BIN(?) AND expires_at > ?)");
        statement.setString(1, uuid.toString());
        statement.setString(2, uuid.toString());
        statement.setDate(3, new Date(System.currentTimeMillis()));
        return statement;
    }

    @Override
    protected void handleResult(ResultSet resultSet) throws SQLException {
        if(verifyPlayer(uuid)){
            while (resultSet.next()){
                Date $expiresAt = resultSet.getDate("expires_at");
                if($expiresAt == null || (new Timestamp(new Date(System.currentTimeMillis()).getTime()).getTime() < new Timestamp($expiresAt.getTime()).getTime())){
                    applySentence(player, resultSet.getInt("category"), resultSet.getString("issuer"), resultSet.getString("reason"));
                }
            }
        }
    }

    private void applySentence(CorePlayer player, int category, String effector, String reason){
        switch (category){
            case PunishmentCategory.BAN:
                player.kick(TextFormat.RED.toString() + "You have been banned on this server\nReason: " + reason + "\nBanned By: " + effector); //todo provide info if the player is perm bannned or temp and with date
                break;
            case PunishmentCategory.MUTE:
                player.mute();
                break;
            default:
                LoggerUtils.error("Unhandled category on the sentence for "+ username +  "Category: " + category);
        }
    }
}
