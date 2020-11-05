/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.provider;

import net.primegames.core.providor.MySQLInitialTask;
import net.primegames.core.providor.utils.MySQLEvent;

import java.sql.SQLException;
import java.sql.Statement;

final public class KitPvPDBInitialTask extends MySQLInitialTask {

    @Override
    public void getInitTableQuery(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS kitpvp_users( " +
                "id BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                "user_id BIGINT(20) UNSIGNED NOT NULL, " +

                "ranking INT UNSIGNED DEFAULT 0, " +

                "prestige INT UNSIGNED DEFAULT 0, " +

                "coins DECIMAL(20,2) UNSIGNED DEFAULT 0, " +

                "FOREIGN KEY (user_id) REFERENCES users(id) " +

                ") ENGINE=INNODB");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS  kitpvp_unique_kill_stats(" +
                "id BIGINT(20) UNSIGNED UNIQUE NOT NULL," +
                "killer_id BIGINT(20)," +
                "victim_id BIGINT(20),"+
                "times_killed INT(20)"+
                ") ENGINE=INNODB");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS kitpvp_user_stats( " +
                "user_id BIGINT(20) UNSIGNED UNIQUE NOT NULL, " +

                "daily_kills MEDIUMINT(20) UNSIGNED DEFAULT 0, " +
                "weekly_kills INT(20) UNSIGNED DEFAULT 0, " +
                "monthly_kills INT(20) UNSIGNED DEFAULT 0, " +
                "total_kills BIGINT(20) UNSIGNED DEFAULT 0, " +

                "daily_unique_kills MEDIUMINT(20) UNSIGNED DEFAULT 0, " +
                "weekly_unique_kills INT(20) UNSIGNED DEFAULT 0, " +
                "monthly_unique_kills INT(20) UNSIGNED DEFAULT 0, " +
                "total_unique_kills BIGINT(20) UNSIGNED DEFAULT 0, " +

                "current_streak MEDIUMINT(20) UNSIGNED DEFAULT 0, " +
                "daily_streak MEDIUMINT(20) UNSIGNED DEFAULT 0, " +
                "weekly_streak INT(20) UNSIGNED DEFAULT 0, " +
                "monthly_streak INT(20) UNSIGNED DEFAULT 0, " +
                "total_streak BIGINT(20) UNSIGNED DEFAULT 0, " +

                "FOREIGN KEY (user_id) REFERENCES kitpvp_users(id) " +
                ") ENGINE=INNODB");

        statement.executeUpdate(MySQLEvent.daily("kitpvp_user_stats", "UPDATE kitpvp_user_stats SET daily_kills = 0, daily_unique_kills = 0 , daily_streak = 0"));
        statement.executeUpdate(MySQLEvent.weekly("kitpvp_user_stats", "UPDATE kitpvp_user_stats SET weekly_kills = 0, weekly_unique_kills = 0 , weekly_streak = 0"));
        statement.executeUpdate(MySQLEvent.monthly("kitpvp_user_stats", "UPDATE kitpvp_user_stats SET monthly_kills = 0, monthly_unique_kills = 0 , monthly_streak = 0"));

    }
}
