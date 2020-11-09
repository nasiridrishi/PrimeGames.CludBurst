/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.player;

import lombok.Data;
import net.primegames.core.CorePlayer;

import java.util.Date;

@Data public class CorePlayerDataStore {

    private String uuid;
    private String username;
    private long lastSession;

    private int internalId;

    private String last_ip;
    private String continent_code;
    private String country_code;

    private int reputation;
    private int warnings;
    private long timePlayed;
    private long lastSessionDuration;
    private Date registeredAt;

    private int voteKeys;
    private int legendaryKeys;
    private int rareKeys;
    private int commonKeys;

    private String locale = "eng";

    public CorePlayerDataStore(CorePlayer player, int internalId, String last_ip, String country_code, String continent_code, int reputation, int warnings, long timePlayed, long lastSessionDuration, Date registeredAt, int voteKeys, int commonKeys, int rareKeys, int legendaryKeys, String locale){
        this.uuid = player.getUniqueId().toString();
        this.username = player.getName();
        this.lastSession = System.currentTimeMillis();
        this.internalId = internalId;
        this.last_ip = last_ip;
        this.continent_code = continent_code;
        this.reputation = reputation;
        this.warnings = warnings;
        this.timePlayed = timePlayed;
        this.lastSessionDuration = lastSessionDuration;
        this.registeredAt = registeredAt;
        this.voteKeys = voteKeys;
        this.commonKeys = commonKeys;
        this.rareKeys = rareKeys;
        this.legendaryKeys = legendaryKeys;
        this.locale = locale;
        this.country_code = country_code;
    }
}
