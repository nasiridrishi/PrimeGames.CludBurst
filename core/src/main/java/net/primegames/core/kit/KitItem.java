/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.kit;

import org.cloudburstmc.server.item.behavior.Item;
import org.cloudburstmc.server.item.enchantment.Enchantment;
import org.cloudburstmc.server.utils.Identifier;

public class KitItem {

    private final Identifier itemId;
    private final int meta;
    private Enchantment[] enchantments;
    private final int count;
    private final Item preparedItem;

    public KitItem(Identifier itemId, int meta, int count, Enchantment... enchantments){
        this.itemId = itemId;
        this.meta = meta;
        this.enchantments = enchantments;
        this.count = count;
        preparedItem = prepareEnchantedItem();
    }

    public KitItem(Identifier itemId, int meta, int count){
        this.itemId = itemId;
        this.meta = meta;
        this.count = count;
        preparedItem = prepareItem();
    }

    public Item getItem() {
        return preparedItem;
    }

    private Item prepareEnchantedItem(){
        Item item = Item.get(itemId, meta, count
        );
        item.addEnchantment(enchantments);
        return item;
    }

    private Item prepareItem(){
        return Item.get(itemId, meta, count);
    }
}
