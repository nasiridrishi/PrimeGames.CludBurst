/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.player;

import lombok.Data;

@Data public class KitPvPPlayerDataStore {

    private int kitpvpId;
    private int rank;
    private int prestige;

    public KitPvPPlayerDataStore(int kitpvpId, int rank, int prestige){
        this.kitpvpId = kitpvpId;
        this.rank = rank;
        this.prestige = prestige;
    }
}
