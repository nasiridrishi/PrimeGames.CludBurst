/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.Utils;

import de.lucgameshd.scoreboard.api.ScoreboardAPI;
import de.lucgameshd.scoreboard.network.DisplayEntry;
import de.lucgameshd.scoreboard.network.DisplaySlot;
import de.lucgameshd.scoreboard.network.Scoreboard;
import de.lucgameshd.scoreboard.network.ScoreboardDisplay;
import net.primegames.CorePlayer;

public class CoreScoreBoard {

    private final Scoreboard scoreboard;
    private final ScoreboardDisplay scoreboardDisplay;
    DisplayEntry[] scores;
    private final CorePlayer player;

    public CoreScoreBoard(CorePlayer player, String objective, String title){
        scoreboard = ScoreboardAPI.createScoreboard();
        this.player = player;
        scoreboardDisplay = scoreboard.addDisplay(DisplaySlot.SIDEBAR, objective, title);
    }

    public void addScores(String[] values){
        scores = new DisplayEntry[values.length];
        int scoreline = 0;
        for (String value: values){
            if(scores.length >= scoreline){
                scores[scoreline] = scoreboardDisplay.addLine(value, scoreline);
                scoreline +=1;
            }
        }
        ScoreboardAPI.setScoreboard(player, scoreboard);
    }

    private void addScore(int scoreLine, String value){
        if(scores[scoreLine] != null){
            scores[scoreLine] = scoreboardDisplay.addLine(value, scoreLine);
        }else{
            removeScore(scoreLine);
            addScore(scoreLine, value);
        }
    }

    public void removeScore(int scoreLine){
        DisplayEntry entry = scores[scoreLine];
        if(entry != null){
            remove(entry);
            scores[scoreLine] = null;
        }else{
            LoggerUtils.warn("Passed a score line which was not found in scoreboard entry");
        }
    }

    private void remove(DisplayEntry entry){
        scoreboardDisplay.removeEntry(entry);
    }

    public void updateScore(int scoreLine, String newValue, boolean clear){
        if(clear){
            removeScore(scoreLine);
        }
        addScore(scoreLine, newValue);
    }

    public void removeScoreBoard(){
        ScoreboardAPI.removeScorebaord(player, scoreboard);
    }
}
