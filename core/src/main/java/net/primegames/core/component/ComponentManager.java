/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component;

import net.primegames.core.Utils.LoggerUtils;

import java.util.ArrayList;

public class ComponentManager {

    public static ComponentManager instance;

    private final ArrayList<Component> components = new ArrayList<>();

    public ComponentManager(){
        instance = this;
    }

    public void addComponent(Component component){
        for(Component component1 : components) {
           if(component1.getIdentifier().equals(component.getIdentifier())){
               LoggerUtils.warn("Added " + component.getIdentifier() + " which is already exits");
           }
        }
        components.add(component);
    }

    public static ComponentManager getInstance() {
        return instance;
    }
}
