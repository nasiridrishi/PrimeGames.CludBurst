/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.kit;

import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;

public class KitItem {

    private final int itemId;
    private final int meta;
    private Enchantment[] enchantments;
    private final int count;
    private final Item preparedItem;

    public KitItem(int itemId, int meta, int count, Enchantment... enchantments){
        this.itemId = itemId;
        this.meta = meta;
        this.enchantments = enchantments;
        this.count = count;
        preparedItem = prepareEnchantedItem();
    }

    public KitItem(int itemId, int meta, int count){
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
