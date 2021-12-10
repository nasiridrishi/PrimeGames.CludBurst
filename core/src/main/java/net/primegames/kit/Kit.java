/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kit;


import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemArmor;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.potion.Effect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Kit {

    private final String id;

    public Kit(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

     public abstract ArrayList<Effect> getEffects();

    public abstract ArrayList<Item> getItems();

    public void addTo(Player player){
        setItems(player);
        if(getEffects() != null){
            addEffects(player);
        }
        //Core.getInstance().getLogger().info(this.getId() + " kit given to " + player.getName());
        player.sendMessage("Added kit " + this.id);
    }

    private void setItems(Player player){
        Map<Integer, Item> entry = new HashMap<>();
        for (int i = 0; i < getItems().size(); i++){
            entry.put(i, getItems().get(i));
        }
        player.getInventory().setContents(entry);
    }

    public void setDiamondArmor(){

    }

    public void setArmor(ArrayList<Item> armor, Player player){
        Item[] items = new Item[4];
        int n = 0;
        for(Item item: armor){
            if(item instanceof ItemArmor){
                items[n] = item;
            }
            n++;
        }
        player.getInventory().setArmorContents(items);
    }

    private void addEffects(Player player){
        for (Effect effect : getEffects()){
            player.addEffect(effect);
        }
    }

    protected ArrayList<Item> prepareItems(ArrayList<KitItem> kitItems){
        ArrayList<Item> items = new ArrayList<>();
        for(KitItem kitItem:kitItems){
            items.add(kitItem.getItem());
        }
        return items;
    }

    protected ArrayList<Item> getDiamondArmor() {
        Map<Integer, Integer> itemsIds = new HashMap<>();
        itemsIds.put(ItemID.DIAMOND_HELMET, 0);
        itemsIds.put(ItemID.DIAMOND_CHESTPLATE, 0);
        itemsIds.put(ItemID.DIAMOND_LEGGINGS, 0);
        itemsIds.put(ItemID.DIAMOND_BOOTS, 0);
        ArrayList<Item> items = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item: itemsIds.entrySet()){
            items.add(Item.get(item.getKey(), item.getValue()));
        }
        return items;
    }

    protected Item prepareKitItem(int itemId, int meta, int amount, Enchantment... enchantments){
        return (new KitItem( itemId, meta, amount,  enchantments)).getItem();
    }

    protected Item prepareKitItem(int itemId, int meta, int amount){
        return (new KitItem(itemId, meta, amount)).getItem();
    }
}
