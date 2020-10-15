/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.kit;

import net.primegames.core.Core;

import java.util.ArrayList;

public class KitFactory {

    private static final ArrayList<Kit> kits = new ArrayList<Kit>();

    public static ArrayList<Kit> getKits(){
        if(kits.isEmpty()){
            return null;
        }
        return kits;
    }

    public void registerKit(Kit kit){
        kits.add(kit);
        Core.getInstance().getLogger().info("Registered new kit " + kit.getId());
    }

    public Kit getKit(String kitId){
        for (Kit kit : kits){
            if (kit.getId().equals(kitId)){
                return kit;
            }
        }
        return null;
    }
}
