/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.player;

import net.primegames.core.Utils.CoreScoreBoard;
import net.primegames.core.Utils.Utils;
import net.primegames.core.component.combatLogger.CombatLogHeartBeat;
import net.primegames.core.rank.Rank;
import net.primegames.kitpvp.KitpvpPlayer;

public class KitPvPScoreBoard extends CoreScoreBoard {

    public static final int RANK = 0;
    public static final int PRESTIGE = 1;
    public static final int MONEY = 2;
    public static final int TARGET = 3;
    public static final int COMBAT_LOG = 4;
    public static final int PING = 5;

    private final KitpvpPlayer player;

    private final String[] values = new String[6];

    public KitPvPScoreBoard(KitpvpPlayer player) {
        super(player, "KitPvP", Utils.translateColors("{BOLD}{RED}★{GREEN}PrimeGames KitPvP{RED}★"));
        this.player = player;
    }

    public void setScoreBoard(){
        updateRank(false);
        updatePrestige(false);
        updateMoney(false);
        updateTarget(false);
        updateCombatLog(false);
        updatePing(false);
        addScores(values);
    }

    public void updateRank(boolean clear){
        values[RANK] = "0";
        updateScore(RANK, values[RANK], clear);
    }

    public void updateTarget(boolean clear){
        values[TARGET] = "Not set";
        updateScore(TARGET, values[TARGET], clear);
    }

    public void updatePrestige(boolean clear){
        values[PRESTIGE] = "0";
        updateScore(PRESTIGE, values[PRESTIGE], clear);
    }

    public void updateMoney(boolean clear){
        values[MONEY] = "0";
        updateScore(PRESTIGE, values[PRESTIGE], clear);
    }

    public void updateCombatLog(boolean clear){
        if(CombatLogHeartBeat.getInstance().isTagged(player)){
            values[COMBAT_LOG] = Utils.translateColors("{YELLOW}Combat Log: {RED}") + CombatLogHeartBeat.getInstance().getCombatTimeLeft(player);
        }else{
            values[COMBAT_LOG] = Utils.translateColors("{YELLOW}Combat Log: {GREEN}No Tag");
        }
        updateScore(COMBAT_LOG, values[COMBAT_LOG], clear);
    }

     public void updatePing(boolean clear){
        values[PING] = Utils.translateColors("{YELLOW}Ping: ") + colorizePing(player.getPing());
        updateScore(PING, values[PING], clear);
    }

    private String colorizePing(long ping){
        if (ping < 100) {
            return  "\u00A7a" + ping + " ms";
        } else if (ping < 200) {
            return "\u00A7e" + ping + " ms";
        } else if (ping < 300) {
            return  "\u00A76" + ping + " ms";
        } else {
            return  "\u00A7c" + ping + " ms";
        }
    }

}
