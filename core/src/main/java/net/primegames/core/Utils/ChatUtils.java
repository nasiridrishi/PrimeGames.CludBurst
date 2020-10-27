/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.Utils;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.utils.TextFormat;

public class ChatUtils {

    static public boolean isSpam(CorePlayer player, String message){
        if(player.isMuted()){
            player.sendMessage(TextFormat.RED.toString() + "You are muted");
            return true;
        }
        //todo add more stuffs here like spam filter etc.
        return false;
    }
}
