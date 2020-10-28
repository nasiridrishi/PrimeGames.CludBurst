/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component;

import java.util.ArrayList;

public class ComponentManager {

    public static ComponentManager instance;

    private ArrayList<Component> components;

    public ComponentManager(){
        instance = this;
    }

    public void addComponent(){

    }

    public static ComponentManager getInstance() {
        return instance;
    }
}
