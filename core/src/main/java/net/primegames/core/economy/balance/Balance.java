/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.economy.balance;

import lombok.Getter;
import lombok.Setter;

public class Balance {

    @Getter @Setter private int balance;

    public Balance(int balance){
        this.balance = balance;
    }

    public void add(float amount) {
        balance+=amount;
    }

    public void subtract(float amount) {
        add(-amount);
    }

    public boolean has(float amount) {
        return amount >= balance;
    }
}
