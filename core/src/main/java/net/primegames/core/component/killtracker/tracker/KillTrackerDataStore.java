/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.killtracker.tracker;

import lombok.Getter;
import lombok.Setter;
import net.primegames.core.CorePlayer;

import java.util.ArrayList;

public class KillTrackerDataStore {
    
    @Getter private final CorePlayer owner;

    @Getter @Setter private int totalKills;

    @Getter @Setter private int totalDeaths;

    @Getter @Setter private int dailyKills;

    @Getter @Setter private int weeklyKills;

    @Getter @Setter private int monthlyKills;

    @Getter @Setter private ArrayList<UniqueKillTrackerDataStore> uniqueKillTrackers;

    public KillTrackerDataStore(CorePlayer owner){
        this.owner = owner;
    }

    
    public void increment() {
        incrementDaily();
        incrementWeekly();
        incrementMonthly();
        incrementTotal();
    }


    public void addTotal(int amount){
        totalKills += amount;
    }

    public void  incrementDeath(){
        this.totalDeaths++;
    }


    public void addDeaths(int amount){
        this.totalDeaths += amount;
    }


    public void subtractTotal(int amount) {
        totalKills -= amount;
    }


    public void incrementTotal() {
        totalKills++;
    }
    
    public void deIncrementTotal() {
        totalKills--;
    }


    public void addDaily(int amount) {
        dailyKills+=amount;
    }


    public void subtractDaily(int amount) {
        dailyKills-=amount;
    }


    public void incrementDaily() {
        dailyKills++;
    }

    
    public void deincrementDaily() {
        dailyKills--;
    }

    
    public void addWeekly(int amount) {
        weeklyKills += amount;
    }

    
    public void subtractWeekly(int amount) {
        weeklyKills -= amount;
    }

    
    public void incrementWeekly() {
        weeklyKills ++;
    }

    
    public void deincrementWeekly() {
        weeklyKills --;
    }

    
    public void addMonthly(int amount) {
        monthlyKills += amount;
    }

    
    public void subtractMonthly(int amount) {
        monthlyKills -= amount;
    }

    
    public void incrementMonthly() {
        monthlyKills ++;
    }

    
    public void deIncrementMonthly() {
        monthlyKills --;
    }

    
    public void incrementUniqueKills(int playerID) {
        UniqueKillTrackerDataStore dataStore = getUniqueKillDataStore(playerID);
        if(dataStore != null){
            dataStore.increment();
        }else{
            uniqueKillTrackers.add(new UniqueKillTrackerDataStore(owner.getCoreDataStore().getInternalId(), playerID, 1));
        }
    }
    
    public UniqueKillTrackerDataStore getUniqueKillDataStore(int playerID){
        for (UniqueKillTrackerDataStore uniqueKillTrackerDataStore : uniqueKillTrackers){
            if(uniqueKillTrackerDataStore.getVictimPlayerId() == playerID){
                return uniqueKillTrackerDataStore;
            }
        }
        return null;
    }

    
    public ArrayList<UniqueKillTrackerDataStore> getUniquePlayersKilled(){
        return uniqueKillTrackers;
    }

    
    public boolean hasKilledBefore(int playerID) {
        return getUniqueKillDataStore(playerID) != null;
    }
}
