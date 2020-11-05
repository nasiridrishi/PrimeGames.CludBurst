/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.kit;

import net.primegames.core.kit.Kit;
import net.primegames.core.kit.KitIds;
import net.primegames.kitpvp.KitpvpPlayer;
import net.primegames.kitpvp.item.FixedHotBarSword;
import org.checkerframework.checker.units.qual.A;
import org.cloudburstmc.server.item.behavior.Item;
import org.cloudburstmc.server.item.behavior.ItemIds;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.potion.Effect;
import org.cloudburstmc.server.potion.Potion;

import java.util.ArrayList;

public class ClassicKit extends Kit {
    public ClassicKit() {
        super(KitIds.classicKit);
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
        items.add(prepareKitItem(ItemIds.ENDER_PEARL, 0, 5));
        items.add(prepareKitItem(ItemIds.BOW, 0, 1));
        for (int i = 0; i < 32; i++){
            items.add(prepareKitItem(ItemIds.SPLASH_POTION, Potion.INSTANT_HEALTH_II, 1));
        }
        items.add(prepareKitItem(ItemIds.ARROW, 0, 64));
        return items;
    }
}
