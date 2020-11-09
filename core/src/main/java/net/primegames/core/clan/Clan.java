/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.clan;

import lombok.Getter;
import lombok.Setter;

public class Clan {
    @Getter @Setter private String name;
    @Getter @Setter private String clanSlogan;
    @Getter @Setter private float bankBalance;
    @Getter @Setter private int strength;

    public Clan(String name, String clanSlogan, float bankBalance, int strength){
        this.name = name;
        this.clanSlogan = clanSlogan;
        this.bankBalance = bankBalance;
        this.strength = strength;
    }
}
