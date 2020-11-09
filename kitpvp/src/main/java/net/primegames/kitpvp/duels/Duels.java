/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.duels;

import lombok.Getter;
import net.primegames.core.kit.Kit;
import net.primegames.kitpvp.KitpvpPlayer;

public class Duels {

    @Getter private final KitpvpPlayer player1;
    @Getter private final KitpvpPlayer player2;
    @Getter private final Kit kit;

    public Duels(KitpvpPlayer player1, KitpvpPlayer player2, Kit kit, int time){
        this.player1 = player1;
        this.player2 = player2;
        this.kit = kit;
    }
    
}
