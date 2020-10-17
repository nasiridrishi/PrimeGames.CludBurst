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
import net.primegames.core.event.player.CorePlayerLoadedEvent;
import net.primegames.core.group.Group;
import net.primegames.core.player.CorePlayerDatabaseData;
import net.primegames.core.providor.MySqlFetchQueryTask;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.event.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class PlayerLoadTask extends MySqlFetchQueryTask {

    private final UUID uuid;

    private final CorePlayer player;

    public PlayerLoadTask(CorePlayer player){
        LoggerUtils.debug("Initiating data load task for " + player.getName() + " from MySQL");
        uuid = player.getServerId();
        this.player = player;
    }

    @Override
    protected PreparedStatement preparedStatement(Connection connection) throws SQLException {
        LoggerUtils.debug("preparing stmt load task for " + player.getName());
        PreparedStatement statement = connection.prepareStatement("SELECT users.*, GROUP_CONCAT(user_groups.group_id) AS all_groups FROM users " +
                        "LEFT JOIN user_groups ON user_groups.user_id = users.id" +
                        " WHERE uuid = UUID_TO_BIN(?) " +
                        "GROUP BY users.id " +
                        "LIMIT 1 ");
        statement.setString(1, uuid.toString());
        return statement;
    }

    @Override
    protected void handleResult(ResultSet resultSet) throws SQLException {
        CorePlayerDatabaseData playerDatabaseData = null;
        ArrayList<Group> groups = null;
        if(verifyPlayer(uuid)){
            if(resultSet.next()){
                try {
                    playerDatabaseData = new CorePlayerDatabaseData(
                            player,
                            resultSet.getInt("id"),
                            resultSet.getString("last_ip"),
                            resultSet.getString("country_code"),
                            resultSet.getString("continent_code"),
                            resultSet.getInt("reputation"),
                            resultSet.getInt("warnings"),
                            resultSet.getLong("time_played"),
                            resultSet.getLong("last_connection_duration"),
                            resultSet.getDate("registered_at"),
                            resultSet.getInt("vote_keys"),
                            resultSet.getInt("common_keys"),
                            resultSet.getInt("rare_keys"),
                            resultSet.getInt("legendary_keys"),
                            resultSet.getString("locale")
                    );
                    //LoggerUtils.info(resultSet.getNString("all_groups"));
                    String[] groupIds = resultSet.getString("all_groups").split(",");
                    for (String groupdId: groupIds){
                        Group group = Core.getInstance().getGroupManager().getGroup(Integer.parseInt(groupdId));
                        if(group != null){
                            player.addGroup(group);
                        }
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                if(playerDatabaseData != null){
                    player.setDatabaseData(playerDatabaseData);
                    CorePlayerLoadedEvent event = new CorePlayerLoadedEvent(player);
                    Core.getInstance().getServer().getPluginManager().callEvent(event);
                    LoggerUtils.debug("Successfully loaded data from " + player.getName());
                    player.setStatus(player.STATUS_ONLINE);
                }
            }else {
                LoggerUtils.info("Data was not found for " + player.getName() + " Initiating new registration");
                player.setStatus(player.STATUS_REGISTER_PENDING);
                Core.getInstance().getMySQLProvider().scheduleTask(new PlayerRegisterTask(player));
            }
        }else {
            LoggerUtils.warn("Player disconnected while data was being loaded");
        }
        resultSet.close();
    }
}
