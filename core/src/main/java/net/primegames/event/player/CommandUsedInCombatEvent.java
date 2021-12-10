/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.event.player;

import cn.nukkit.event.Cancellable;
import net.primegames.CorePlayer;

public class CommandUsedInCombatEvent extends CorePlayerEvent{

    private final Cancellable cancellable;

    public CommandUsedInCombatEvent(CorePlayer player, Cancellable cancellable) {
        super(player);
        this.cancellable = cancellable;
    }

    public Cancellable getEvent(){
        return cancellable;
    }
}
