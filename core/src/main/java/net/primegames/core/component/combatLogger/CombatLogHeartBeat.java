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

import java.util.HashMap;
import java.util.Map;

public class CombatLogHeartBeat extends HeartBeat {

    private static CombatLogHeartBeat instance;

    private final int countDown;

    private final Map<CorePlayer, Integer> taggedPlayers = new HashMap<>();

    public CombatLogHeartBeat(){
        super();
        instance = this;
        countDown = 15;
    }

    @Override
    public void onRunPerSec() {
        for (Map.Entry<CorePlayer, Integer> taggedPlayer : taggedPlayers.entrySet()){
            if(taggedPlayer.getValue() <= 0){
                removeTagged(taggedPlayer.getKey());
            }
            taggedPlayer.setValue(taggedPlayer.getValue() - 1);
        }
    }

    public void setTagged(CorePlayer player){
        taggedPlayers.put(player, countDown);
        player.sendMessage(Utils.translateColors("[{RED}CombatLogger{RESET}] Using commands and quitting from server is prohibited during combat log"));
    }

    public boolean isTagged(CorePlayer player){
        return taggedPlayers.containsKey(player);
    }

    public void removeTagged(CorePlayer player){
        taggedPlayers.remove(player);
        player.sendMessage(Utils.translateColors("[{GREEN}CombatLogger{RESET}] Restrictions have been lifted"));
    }

    public static CombatLogHeartBeat getInstance() {
        return instance;
    }

    public int getCombatTimeLeft(CorePlayer player){
        if (isTagged(player)) {
            return taggedPlayers.get(player);
        }
        return 0;
    }
}
