/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.kit;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.potion.Effect;
import cn.nukkit.potion.Potion;
import net.primegames.core.kit.Kit;

import java.util.ArrayList;

public class ClassicKit extends Kit {
    public ClassicKit() {
        super(KitIds.CLASSIC);
    }

    public ArrayList<Effect> getEffects() {
        return null;
    }

    @Override
    public void addTo(Player player) {
        super.addTo(player);
        setDiamondArmor(player);
    }

    public void setDiamondArmor(Player player) {
        super.setArmor(getDiamondArmor(), player);
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(prepareKitItem(ItemID.ENDER_PEARL, 0, 5));
        items.add(prepareKitItem(ItemID.BOW, 0, 1));
        for (int i = 0; i < 32; i++){
            items.add(prepareKitItem(ItemID.SPLASH_POTION, Potion.INSTANT_HEALTH_II, 1));
        }
        items.add(prepareKitItem(ItemID.ARROW, 0, 64));
        return items;
    }
}
