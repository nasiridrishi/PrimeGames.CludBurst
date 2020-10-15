/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.player;

import net.primegames.core.CorePlayer;

import java.util.Date;

public class CorePlayerDatabaseData extends PlayerDataBaseData{

    private String uuid;
    private String username;
    private long lastSession;

    public CorePlayerDatabaseData(CorePlayer player, int internal_id, String last_ip, String country_code, String continent_code, int reputation, int warnings, long timePlayed, long lastSessionDuration, Date registeredAt, int voteKeys, int commonKeys, int rareKeys, int legendaryKeys, String locale){
        super(internal_id, last_ip, country_code, continent_code, reputation, warnings, timePlayed, lastSessionDuration, registeredAt, voteKeys,commonKeys, rareKeys, legendaryKeys, locale);
        this.uuid = player.getServerId().toString();
        this.username = player.getName();
        this.lastSession = System.currentTimeMillis();
    }

    public String getUsername() {
        return username;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastSession(long lastSession) {
        this.lastSession = lastSession;
    }

    public long getLastSession() {
        return lastSession;
    }

    public String getUuid() {
        return uuid;
    }
}
