/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.player;

import java.util.Date;

public class PlayerDataBaseData {

    private int internal_id;

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

    public PlayerDataBaseData(int internal_id, String last_ip, String country_code, String continent_code, int reputation, int warnings, long timePlayed, long lastSessionDuration, Date registeredAt, int voteKeys, int commonKeys, int rareKeys, int legendaryKeys, String locale){
        this.internal_id = internal_id;
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


    public int getWarnings() {
        return warnings;
    }

    public String getContinent_code() {
        return continent_code;
    }

    public int getReputation() {
        return reputation;
    }

    public String getLocale() {
        return locale;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public int getCommonkeys() {
        return commonKeys;
    }

    public int getInternal_id() {
        return internal_id;
    }

    public long getLastSessionDuration() {
        return lastSessionDuration;
    }

    public int getLegendaryKeys() {
        return legendaryKeys;
    }

    public int getRareKeys() {
        return rareKeys;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public long getTimePlayed() {
        return timePlayed;
    }

    public int getVoteKeys() {
        return voteKeys;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public void setContinent_code(String continent_code) {
        this.continent_code = continent_code;
    }

    public void setCommonKeys(int commonKeys) {
        this.commonKeys = commonKeys;
    }

    public void setInternal_id(int internal_id) {
        this.internal_id = internal_id;
    }

    public void setLastSessionDuration(long lastSessionDuration) {
        this.lastSessionDuration = lastSessionDuration;
    }

    public void setLegendaryKeys(int legendaryKeys) {
        this.legendaryKeys = legendaryKeys;
    }

    public void setRareKeys(int rareKeys) {
        this.rareKeys = rareKeys;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public void setTimePlayed(long timePlayed) {
        this.timePlayed = timePlayed;
    }

    public void setVoteKeys(int voteKeys) {
        this.voteKeys = voteKeys;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
