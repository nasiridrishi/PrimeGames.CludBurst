/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.utils;

import net.primegames.core.Utils.HeartBeat;
import net.primegames.kitpvp.Kitpvp;
import net.primegames.kitpvp.KitpvpPlayer;

public class KitPvPHeartBeat extends HeartBeat {

    private int pingCountDown = 10;

    public KitPvPHeartBeat(){
        super();
    }

    @Override
    public void onRunPerSec() {
        pingCountDown--;
        if(pingCountDown <= 10){
            updatePlayerPingScore();
        }
    }

    private void updatePlayerPingScore(){
        for (KitpvpPlayer player : Kitpvp.getInstance().getOnlineKitPlayers()){
        }
        pingCountDown = 10;
    }


}
