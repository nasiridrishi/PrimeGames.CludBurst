/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.killtracker.tracker;

public class UniqueKillTrackerDataStore {

    int killerId;

    int victimId;

    int timesKilled;

    public UniqueKillTrackerDataStore(int killerPlayerId, int victimPlayerId, int timesKilled){
        killerId = killerPlayerId;
        victimId = victimPlayerId;
        this.timesKilled = timesKilled;
    }

    public int getKillerPlayerId() {
        return killerId;
    }

    public int getVictimPlayerId() {
        return victimId;
    }

    public int getTimesKilled() {
        return timesKilled;
    }

    public void increment() {
        timesKilled += 1;
    }
}
