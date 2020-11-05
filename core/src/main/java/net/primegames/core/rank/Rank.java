/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.rank;

import lombok.Getter;

public class Rank {

    @Getter protected String name;

    @Getter protected int priority;

    @Getter protected int cost;

    public Rank(String name, int priority, int cost){
        this.name = name;
        this.priority = priority;
        this.cost = cost;
    }
}
