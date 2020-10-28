/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.combatLogger;

import net.primegames.core.CorePlayer;
import net.primegames.core.Utils.HeartBeat;
import net.primegames.core.Utils.Utils;
import org.cloudburstmc.server.utils.TextFormat;

public class CombatLogHeartBeat extends HeartBeat {

    private int countDown = 15;

    private final CorePlayer player;

    public CombatLogHeartBeat(CorePlayer player){
        super();
        this.player = player;
    }

    @Override
    public void onRunPerSec() {
        if(countDown > 0){
            countDown--;
            player.sendTip(TextFormat.RED + "In Combat: " + TextFormat.YELLOW + countDown);
        }else{
            player.sendMessage(Utils.translateColors("[{GREEN}CombatLogger{RESET}] Restrictions have been lifted"));
            player.unsetCombatLog();
        }
    }

    public int getCountDown() {
        return countDown;
    }
}
