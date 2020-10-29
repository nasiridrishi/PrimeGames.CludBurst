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

    private int countDown;

    private final int combatTime;

    private final CorePlayer player;

    public CombatLogHeartBeat(CorePlayer player){
        super();
        this.player = player;
        countDown = 15;
        combatTime = 15;
    }

    public CombatLogHeartBeat(CorePlayer player, int combatCoolDown){
        super();
        this.player = player;
        combatTime = combatCoolDown;
        countDown = combatCoolDown;
    }

    public void restart(){
        countDown = combatTime;
    }

    @Override
    public void onRunPerSec() {
        if(player.isInCombatLog()){
            if(countDown > 0){
                player.sendTip(TextFormat.RED + "In Combat: " + TextFormat.YELLOW + countDown);
                countDown--;
            }else{
                player.sendMessage(Utils.translateColors("[{GREEN}CombatLogger{RESET}] Restrictions have been lifted"));
                player.unsetCombatLog();
            }
        }
    }

    public int getCountDown() {
        return countDown;
    }
}
